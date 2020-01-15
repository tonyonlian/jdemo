package com.tongyl.jdemo.stormtest.spout;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Random;

/**
 * 生成随机数的spout
 * @author create by Tunyl on 2020/1/7
 * @version 1.0
 */
public class RandomIntegerSpout extends BaseRichSpout {
    private static final Logger log = LoggerFactory.getLogger(RandomIntegerSpout.class);
    private SpoutOutputCollector collector;
    private Random random;
    private long msgId = 0;
    //初始化
    @Override
    public void open(Map<String, Object> map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.collector = spoutOutputCollector;
        this.random = new Random();
    }
   //发送消息到下游
    @Override
    public void nextTuple() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        collector.emit(new Values(random.nextInt(1000),System.currentTimeMillis()-(24*60*60*1000),++msgId));

    }
    //消息发送的申明字段
    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("value","ts","msgid"));
    }

    //消息处理成功的确认
    @Override
    public void ack(Object msgId) {
        log.debug("Got Ack for msgId: {}",msgId);
    }
    //消息处理失败时调用
    @Override
    public void fail(Object msgId) {
        log.debug("Got FaIL for msgId: {}",msgId);
    }


}
