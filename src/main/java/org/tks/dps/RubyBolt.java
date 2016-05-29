package org.tks.dps;

import java.util.Map;
import org.apache.storm.task.ShellBolt;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;

class RubyBolt extends ShellBolt implements IRichBolt {
  private static final long serialVersionUID = 6537727428628598521L;

  public RubyBolt() {
    super("ruby", "ruby_bolt.rb");
  }

  @Override
  public void declareOutputFields(OutputFieldsDeclarer declarer) {}

  @Override
  public Map<String, Object> getComponentConfiguration() { return null; }
}
