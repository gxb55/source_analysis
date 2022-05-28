package com.trip.atguigu.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trip.atguigu.es.entity.User;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;

import java.io.IOException;

/**
 * @author xbguo
 * @createTime 2022年05月08日 20:55:00
 */
public class ESclient_Doc {
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void createDoc() throws IOException {
        ConnectElasticSearch.connect(x -> {
            IndexRequest request = new IndexRequest();
            request.index("user").id("1001");

            User user = new User();
            user.setAge(13);
            user.setName("张三");
            user.setSex("男");
            String s = objectMapper.writeValueAsString(user);
            request.source(s, XContentType.JSON);


            IndexResponse response = x.index(request, RequestOptions.DEFAULT);
            System.out.println("index_" + response.getIndex());
            System.out.println("_id:" + response.getId());
            System.out.println("_result:" + response.getResult());
        });
    }

    @Test
    public void updateDoc() throws IOException {
        ConnectElasticSearch.connect(x -> {
            UpdateRequest request = new UpdateRequest();
            request.index("user").id("1001");
            request.doc(XContentType.JSON, "sex", "nv");


            UpdateResponse update = x.update(request, RequestOptions.DEFAULT);
            System.out.println("index_" + update.getIndex());
            System.out.println("_id:" + update.getId());
            System.out.println("_result:" + update.getResult());
        });
    }

    @Test
    public void delDoc() throws IOException {
        ConnectElasticSearch.connect(x -> {
            DeleteRequest request = new DeleteRequest();
            request.index("user").id("1001");


            DeleteResponse delete = x.delete(request, RequestOptions.DEFAULT);
            System.out.println("index_" + delete.getIndex());
            System.out.println("_id:" + delete.getId());
            System.out.println("_result:" + delete.getResult());
        });
    }

    @Test
    public void getDoc() throws IOException {
        ConnectElasticSearch.connect(x -> {
            GetRequest request = new GetRequest();
            request.index("user").id("1004");


            GetResponse delete = x.get(request, RequestOptions.DEFAULT);
            System.out.println("index_" + delete.getIndex());
            System.out.println("_id:" + delete.getId());
            System.out.println("_result:" + delete.getSource());
        });
    }

    @Test
    public void batchInsertDoc() throws IOException {
        ConnectElasticSearch.connect(x -> {
            BulkRequest request = new BulkRequest();

            request.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON, "name", "lisi"))
                    .add(new IndexRequest().index("user").id("1004").source(XContentType.JSON, "name", "lisi1"))
                    .add(new IndexRequest().index("user").id("1005").source(XContentType.JSON, "age", "1"))
                    .add(new IndexRequest().index("user").id("1006").source(XContentType.JSON, "sex", "3"));
            BulkResponse bulk = x.bulk(request, RequestOptions.DEFAULT);
            System.out.println(bulk.getTook());
        });
    }

    @Test
    public void batchDelDoc() throws IOException {
        ConnectElasticSearch.connect(x -> {
            BulkRequest request = new BulkRequest();

            request.add(new DeleteRequest().index("user").id("1003"))
                    .add(new IndexRequest().index("user").id("1004"))
                    .add(new IndexRequest().index("user").id("1005"))
                    .add(new IndexRequest().index("user").id("1006"));
            BulkResponse bulk = x.bulk(request, RequestOptions.DEFAULT);
            System.out.println(bulk.getTook());
        });
    }
}
