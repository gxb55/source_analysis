package com.trip.atguigu.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author xbguo
 * @createTime 2022年05月08日 19:06:00
 */
public class ESClient_test {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient
                (RestClient.builder(new HttpHost("hadoop100", 9200, "http")));

        System.out.println(client);
        client.close();
    }
}
