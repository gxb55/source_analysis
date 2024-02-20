package com.trip.atguigu.reactor.flux;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.Executors;

public class FluxDemo {
    public static void demo(String[] args) throws IOException {
        Flux<Integer> just = Flux.just(1, 2, 3, 4, 5, 6, 7);
        just.subscribe(x -> System.out.println("e1:" + Thread.currentThread().getName() + x));
        just.subscribe(x -> System.out.println("e2:" + Thread.currentThread().getName() + x));

        System.out.println("=================================================================");
     /*   Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
        interval.subscribe(System.out::println);
        System.in.read();*/

        Mono<String> a = Mono.just("a");
        a.subscribe(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        Scheduler scheduler = Schedulers.fromExecutor(Executors.newSingleThreadExecutor());
        Flux.range(1,1000)
                        .publishOn(scheduler)
                .log().map(x->{
                    System.out.println(Thread.currentThread().getName());
                   return x;
                })
                .subscribe();
        //Schedulers.boundedElastic()

        System.in.read();

    }
    public static void handle(String[] args) {
        Flux.range(0, 10).log().handle((value, sink) -> {
                    String string = "张三" + value;
                    sink.next(sink);
                })
                .subscribe();
    }

    public static void create(String[] args) {
        Flux<Object> objectFlux = Flux.create(sink -> {
            for (int i = 0; i < 10; i++) {
                sink.next("张" + i);
                try {
                    Thread.sleep(i * 10);
                } catch (InterruptedException e) {

                }
            }
        });
        objectFlux.log().subscribe();
    }

    public static void generate(String[] args) throws IOException {
        Flux<Object> generate = Flux.generate(() -> 0, (state, sink) -> {
            sink.next(state);
            int i = state + 1;
            if (i > 10) {
                sink.complete();
            }
            return i;
        });
        generate.log().subscribe();

        Flux<Integer> log = Flux.range(0, 1000).log().delayElements(Duration.ofSeconds(1));
        Disposable subscribe = log.subscribe();
        new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {

            }
            subscribe.dispose();
        }, "T1").start();
        System.in.read();
    }
}
