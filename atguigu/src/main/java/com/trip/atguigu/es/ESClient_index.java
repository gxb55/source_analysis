package com.trip.atguigu.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2022年05月08日 20:30:00
 */
public class ESClient_index {

    @Test
    public void createIndex() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient
                (RestClient.builder(new HttpHost("hadoop100", 9200, "http")));

        CreateIndexRequest createIndexRequest = new CreateIndexRequest("user");
        CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse.isAcknowledged());
        client.close();
    }

    @Test
    public void delIndex() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient
                (RestClient.builder(new HttpHost("hadoop100", 9200, "http")));

        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("tbl_user");
        AcknowledgedResponse delete = client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());
        client.close();
    }

    @Test
    public void queryOneIndex() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient
                (RestClient.builder(new HttpHost("hadoop100", 9200, "http")));

        GetIndexRequest getIndexRequest = new GetIndexRequest("user");
        GetIndexResponse getIndexResponse = client.indices().get(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println("---------------"+Arrays.toString(getIndexResponse.getIndices()));
        client.close();
    }
}
