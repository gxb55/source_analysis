package com.trip.algorithm.leet.some.leet11;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @auther: xbguo
 * @date: 2022/11/4 11:23
 * @description: TODO
 */
public class Demo {
    public static void main(String[] args) {
        CompletableFuture<String> base = new CompletableFuture<>();


        CompletableFuture<String> completion2 = base.thenApply(s -> {
            System.out.println("completion 2");
            return s + " 2";
        });

        CompletableFuture<String> completion1 = base.thenApply(s -> {
            System.out.println("completion 1");
            return s + " 1";
        });
        CompletableFuture<String> completion0 = base.thenApply(s -> {
            System.out.println("completion 0");
            return s + " 0";
        });

        completion1.thenApply(s -> {
            System.out.println("completion 3");
            return s + " 3";
        });
        completion1.thenApply(s -> {
            System.out.println("completion 4");
            return s + " 4";
        });
        completion1.thenApply(s -> {
            System.out.println("completion 5");
            return s + " 5";
        });


        completion2.thenApply(s -> {
            System.out.println("completion 6");
            return s + " 6";
        });
        completion2.thenApply(s -> {
            System.out.println("completion 7");
            return s + " 7";
        });
        completion2.thenApply(s -> {
            System.out.println("completion 8");
            return s + " 8";
        });

        base.complete("start");



        HashMap<String, Object> toastMap = new HashMap<>();
        toastMap.put("title", "本单赠免费安心退改");
        toastMap.put("img", "https://images3.c-ctrip.com/ztrip/train_xie/2022-07/img_axcx.png");
        List<String> list = new ArrayList<>();
        list.add("<SPAN style=\"TEXT-DECORATION: line-through\">9元/人</SPAN> 免费送, 退票/改签最高<font color=\"#00B96C\">全额赔</font>");
        list.add("支持<font color=\"#00B96C\">微信提现</font>, 赔款发放至钱包");
        list.add("添加智行福利官一键领取");
        toastMap.put("confirmButtonText", "免费领取");
        toastMap.put("context", list);
        toastMap.put("confirmSubText", "限时5分钟领取");
        System.out.println(JSON.toJSON(toastMap));
    }
}
