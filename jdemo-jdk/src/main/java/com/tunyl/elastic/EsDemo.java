package com.tunyl.elastic;



import transwarp.org.elasticsearch.action.get.GetResponse;
import transwarp.org.elasticsearch.client.transport.TransportClient;
import transwarp.org.elasticsearch.common.settings.Settings;
import transwarp.org.elasticsearch.common.transport.InetSocketTransportAddress;
import transwarp.org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * tdh的Elasticsearch的客户端连接
 * @author create by Tunyl on 2020/3/11
 * @version 1.0
 */
public class EsDemo {

    public static void main(String[] args) throws UnknownHostException {
        Settings settings = Settings.builder().put("cluster.name", "cluster").build();

        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("tdh-1"), 9301))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("tdh-2"), 9301))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("tdh-3"), 9301));

        //搜索数据
        GetResponse response = client.prepareGet("navapp_crash_search_20200309", "doc", "3184e7455789e233f95a328bfc8c80cb").execute().actionGet();
        //输出结果
        System.out.println(response.getSourceAsString());
        //关闭client
        client.close();


    }
}
