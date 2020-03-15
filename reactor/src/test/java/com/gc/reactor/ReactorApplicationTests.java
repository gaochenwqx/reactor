package com.gc.reactor;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

class ReactorApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void reactorCreate() {
		Flux<Integer> just = Flux.just(1, 2, 3);

		Flux<Integer> fromArray = Flux.fromArray(new Integer[]{1, 2, 3});

		Flux<Integer> fromIterable = Flux.fromIterable(Lists.newArrayList(1, 2, 3));

		Flux<Integer> fromStream = Flux.fromStream(Stream.of(1, 2, 3));

		Flux<?> empty = Flux.empty();

		Flux<?> error = Flux.error(new Exception());

		Flux<?> never = Flux.never();

		Flux<Integer> range = Flux.range(1, 3);


//        Flux.create().handle();
//        Flux.generate(sink -> {});
//        Flux.push(fluxSink -> {
//            fluxSink.onRequest()
//        })
	}

	@Test
	void intervalTest() throws InterruptedException {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(3), Duration.ofSeconds(1));
        interval.subscribe(System.out::println);
        Thread.sleep(5000);
    }

    @Test
    void generateTest() {
        Flux<String> flux = Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3*state);
                    if (state == 10) sink.complete();
                    return state + 1;
                });
        flux.subscribe(System.out::println);
    }
}
