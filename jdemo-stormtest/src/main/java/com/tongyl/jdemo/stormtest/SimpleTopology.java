package com.tongyl.jdemo.stormtest;


import com.tongyl.jdemo.stormtest.bolt.PrinterBolt;
import com.tongyl.jdemo.stormtest.spout.RandomIntegerSpout;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.ConfigurableTopology;
import org.apache.storm.topology.TopologyBuilder;

/**
 * @author create by Tunyl on 2020/1/7
 * @version 1.0
 */
public class SimpleTopology  {


    public static void main(String[] args) throws Exception {
       // ConfigurableTopology.start(new SiampleTopology(),args);
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("spout",new RandomIntegerSpout());
        builder.setBolt("printBolt",new PrinterBolt())
                .shuffleGrouping("spout");

        Config conf = new Config();
       // conf.setClasspath("D:\\IdeaProjects\\jdemo\\jdemo-strom\\target\\classes");
        conf.setDebug(true);
        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("stromTest", conf, builder.createTopology());
       // cluster.shutdown();
    }

}
