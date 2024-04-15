package com.trip.atguigu.reactor.netty;

/**
 * @author xbguo
 * @date 2024/4/15 17:06
 */
public class ResponseSample {
    private String code;
    private String data;
    private long timestamp;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public ResponseSample(String code, String data, long timestamp) {
        this.code = code;
        this.data = data;
        this.timestamp = timestamp;
    }

    public ResponseSample() {
    }
}
