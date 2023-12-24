package com.trip.springbootsource.module;

public class Response {
    private Integer resultCode;
    private String resultMsg;
    private Object data;

    public static Response getSuccessResponse() {
        Response response = new Response();
        response.setResultCode(1);
        response.setResultMsg("success");
        return response;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
