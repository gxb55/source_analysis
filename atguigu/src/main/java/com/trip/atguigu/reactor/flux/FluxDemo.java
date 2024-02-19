package com.trip.atguigu.reactor.flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
public class FluxDemo {
    public static void main(String[] args) throws IOException {
        Flux<Integer> just = Flux.just(1, 2, 3, 4, 5, 6, 7);
        just.subscribe(x-> System.out.println("e1:"+Thread.currentThread().getName()+x));
        just.subscribe(x-> System.out.println("e2:"+Thread.currentThread().getName()+x));

        System.out.println("=================================================================");
     /*   Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
        interval.subscribe(System.out::println);
        System.in.read();*/

        Mono<String> a = Mono.just("a");
        a.subscribe(System.out::println);
    }
}
