package org.tks.dps;

import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.utils.Utils;
import org.tks.dps.CSVSpout;
import org.tks.dps.DataStoreBolt;

class ProcessTopology {
  public static void main(String[] args) throws Exception {
    TopologyBuilder builder = new TopologyBuilder();

    builder.setSpout("csv_spout", new CSVSpout(), 1);
    builder
      .setBolt("data_store_bolt", new DataStoreBolt(), 2)
      .shuffleGrouping("csv_spout");

    Config config = new Config();
    config.setDebug(true);

    LocalCluster cluster = new LocalCluster();
    cluster.submitTopology("dps-process", config, builder.createTopology());
    Utils.sleep(10000);
    cluster.killTopology("dps-process");
    cluster.shutdown();
  }
}
