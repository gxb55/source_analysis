package com.trip.atguigu.es;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;

import java.io.IOException;

/**
 * @author xbguo
 * @createTime 2022年05月08日 21:18:00
 */
public class ESclient_query {
    @Test
    public void queryAll() throws IOException {
        ConnectElasticSearch.connect(x -> {
            SearchRequest searchRequest = new SearchRequest();
            searchRequest.indices("user");
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            sourceBuilder.query(QueryBuilders.matchAllQuery());
            searchRequest.source(sourceBuilder);

            SearchResponse search = x.search(searchRequest, RequestOptions.DEFAULT);
            System.out.println("index_" + search.getTook());
            SearchHits hits = search.getHits();
            for (SearchHit hits1:hits.getHits()){
                System.out.println(hits1);
            }
        });
    }

}
