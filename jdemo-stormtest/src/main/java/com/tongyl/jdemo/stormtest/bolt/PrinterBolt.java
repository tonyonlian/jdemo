package com.tongyl.jdemo.stormtest.bolt;

import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 打印bolt
 * @author create by Tunyl on 2020/1/7
 * @version 1.0
 */
public class PrinterBolt extends BaseBasicBolt {
    private static final Logger log = LoggerFactory.getLogger(PrinterBolt.class);
    //消息接收方法
    @Override
    public void execute(Tuple tuple, BasicOutputCollector basicOutputCollector) {
        System.out.println(tuple);
        log.info("=================={}",tuple);
    }
    //消息发送的field的申明
    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

    }
}
