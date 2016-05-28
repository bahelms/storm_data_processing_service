package org.tks.dps;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Tuple;
import java.util.Map;

class DataStoreBolt extends BaseRichBolt {
  private static final long serialVersionUID = 6537727428628598521L;
  private OutputCollector collector;

  @Override
  public void prepare(Map config,
                      TopologyContext topologyContext,
                      OutputCollector outputCollector) {}

  @Override
  public void execute(Tuple tuple) {
    String record = tuple.getStringByField("record");
    System.out.println("THE RECORD IS: " + record);
  }

  @Override
  public void declareOutputFields(OutputFieldsDeclarer declarer) {}
}
