package org.tks.dps;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.util.Map;

class CSVSpout extends BaseRichSpout {
  private static final long serialVersionUID = 5537727428628598521L;
  private SpoutOutputCollector collector;
  private BufferedReader reader;
  private String csvPath = "/Users/barretthelms/storm_apps/dps/tmp/source.csv";

  @Override
  public void open(Map config, 
                   TopologyContext context,
                   SpoutOutputCollector collector) {
    this.collector = collector;
    try {
      this.reader = new BufferedReader(new FileReader(csvPath));
    } catch (FileNotFoundException e) {
      System.out.println("FILE NOT FOUND EXCEPTION");
    }
  }

  @Override
  public void nextTuple() {
    String record;
    try {
      while ((record = reader.readLine()) != null) {
        collector.emit(new Values(record));
      }
    } catch (IOException e) {
      System.out.println("IO EXCEPTION on ReadLine");
    }
  }

  @Override
  public void declareOutputFields(OutputFieldsDeclarer declarer) {
    declarer.declare(new Fields("record"));
  }

  @Override
  public void close() {
    try {
      this.reader.close();
    } catch (IOException e) {
      System.out.println("IO EXCEPTION on CLOSE");
    }
  }
}
