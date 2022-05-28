package com.trip.atguigu.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author xbguo
 * @createTime 2022年05月08日 20:57:00
 */
public class ConnectElasticSearch {
    public static void connect(ElasticsearchTask task) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient
                (RestClient.builder(new HttpHost("hadoop100", 9200, "http")));
        task.task(client);
        client.close();
    }
}
