package com.trip.atguigu.es;

import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author xbguo
 * @createTime 2022年05月08日 20:57:00
 */
public interface ElasticsearchTask {
    public void task(RestHighLevelClient client) throws IOException;
}
