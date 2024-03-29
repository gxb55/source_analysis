package reactor;

import org.testng.annotations.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TestReactorAPI {
    @Test
    void block() throws IOException {
        List<Integer> block = Flux.just(1, 2, 3, 4)
                .map(x -> x * 10)
                .collectList()
                .block();
        System.out.println(block);
    }
    @Test
    void sinks() throws IOException {
        Sinks.Many<Object> objectMany = Sinks
                .many()
               // .unicast()
                .multicast()
                .onBackpressureBuffer();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                objectMany.tryEmitNext("a" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
        }).start();

        objectMany.asFlux().subscribe(x->System.out.println(x));
        objectMany.asFlux().subscribe(x->System.out.println(x));
        System.in.read();
    }

    @Test
    void timeOutAndRetry() throws IOException {
        Flux.just(1, 2, 3).delayElements(Duration.ofSeconds(3))
                .timeout(Duration.ofSeconds(1))
                .retry(3)
                .map(x -> "aa" + x)
                .log()
                .subscribe();
        System.in.read();
    }

    @Test
    void merge() {
        // 按照流的先后顺序来构建，concat 链接多个流，
        Flux<Integer> merge = Flux.merge(Flux.range(0, 2), Flux.range(0, 2), Flux.range(0, 2));
        merge.log().subscribe();

        Flux<Integer> integerFlux = Flux.just(1, 2).mergeWith(Flux.just(3, 4));
        integerFlux.subscribe();
        // 如果一个流的元素先到，则把这个流的元素全部处理玩再处理后面的，按照首个到底的元素排序
        Flux.mergeSequential();

    }

    @Test
    void empty() {
        Flux<Object> empty = Flux.empty();
        //一个是静态数据，另一个是产生另一个流来代替
        empty.defaultIfEmpty("x").log().subscribe();
        empty.switchIfEmpty(Flux.range(0, 2)).log().subscribe();
    }

    @Test
    void zip() {
        Flux.just(1, 2, 3).zipWith(Flux.just("A", "B", "C"))
                .map(x -> x.getT1() + ":" + x.getT2()).log().subscribe();
    }

    @Test
    void error() {
        Flux<Integer> map = Flux.range(1, 4)
                .map(x -> x / (x - 3));

        //   map.onErrorReturn(NullPointerException.class,100)
//        map.onErrorResume(x -> {
//                    boolean b = x.getClass() == NullPointerException.class;
//                    return Mono.just(20);
//                })
        //   map.onErrorResume(x -> Flux.error(new NullPointerException()))
        //      map.onErrorMap(x->new Exception())
//        map.doOnError(x -> {
//                    System.out.println("error");
//                })
        // do开头的不吃异常
       /* map.doFinally(x -> {
                    System.out.println("只是一个信号别的啥也不干" + x);
                })*/
        map.onErrorContinue((err, val) -> {
                    System.out.println("err" + err);
                    System.out.println("val" + val);
                })
                .subscribe(x -> {
                    System.out.println(x);
                }, x -> {
                    System.out.println(x);
                }, () -> {
                    System.out.println("流结束了");
                });
    }

    @Test
    void transform() {
        //transformDeferred 共享外部变量 每次都执行
        //transform 不共享外部变量 只执行一次
        AtomicInteger integer = new AtomicInteger(0);
        Flux<String> flux = Flux.just("a", "b", "c", "d")
                .transformDeferred(x -> {
                    if (integer.getAndIncrement() == 1) {
                        return x;
                    } else {
                        return x.map(z -> z.toUpperCase());
                    }
                })
                .log();
        flux.subscribe();
        flux.subscribe();

    }

    @Test
    void concat() {
        // concatWith受前一个参数影响
        Flux.just(2, 3).concatWith(Flux.just(10, 20))
                .log()
                .subscribe();

        //concat 静态方法链接，泛型没有要求
      /*  Flux.concat(Flux.range(1,2),Flux.just("10",11))
                .log()
                .subscribe();*/

        //concatMap 一个变多个带格式转换
       /* Flux.range(1, 3)
                .concatMap((x) -> Flux.just(x + "张","hah",1,2))
                .log()
                .subscribe();*/
    }

    @Test
    void flatMap() {
        Flux.just("zhang san", "li si")
                .flatMap(x -> Flux.fromArray(x.toString().split(" ")))
                .log()
                .subscribe();
    }

    @Test
    public void filter() {
        Flux.range(1, 10).filter(x -> x > 3)
                .log()
                .subscribe();
    }
}
