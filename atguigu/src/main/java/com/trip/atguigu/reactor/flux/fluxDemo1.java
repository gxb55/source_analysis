package com.trip.atguigu.reactor.flux;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

/**
 * @author xbguo
 * @date 2024/2/14 09:06
 */
public class fluxDemo1 {

    public static void main(String[] args) {
        Flux<Integer> range = Flux.range(0, 1000);

        range
                .log()
                .limitRate(100)
                // .buffer(3)

                .subscribe(x -> System.out.println(x));
    }

    public static void flux1(String[] args) {
        Flux.range(0, 10)
                .filter(x -> x > 0)
                .map(x -> {
                    int i = 8 / (8 - x);
                    System.out.println("map::" + x);
                    return "map" + x;
                })
                // .log()
                .subscribe(x -> System.out.println(x), x -> System.out.println(x), () -> System.out.println("结束了"));

    }

    public static void subscribe(String[] args) {
        Flux<Integer> flux = Flux.range(0, 11)
                .map(x -> {
                    int i = x / (x - 8);
                    System.out.println("map->" + x);
                    return x * 100;
                })
                .doOnError(x -> System.out.println("error:" + x));
        flux.subscribe(new BaseSubscriber<Integer>() {
            @Override
            protected void hookFinally(SignalType type) {
                super.hookFinally(type);
            }

            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                System.out.println("绑定了");
                //请求一个元素
                request(1);

            }

            @Override
            protected void hookOnNext(Integer value) {
                System.out.println("next元素到了：" + value);
                request(1);
            }

            @Override
            protected void hookOnComplete() {
                System.out.println("正常结束");
            }

            @Override
            protected void hookOnError(Throwable throwable) {
                System.out.println("异常结束");
            }

            @Override
            protected void hookOnCancel() {
                System.out.println("流被取消了");
            }

        });

    }


}
