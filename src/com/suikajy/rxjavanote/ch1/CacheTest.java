package com.suikajy.rxjavanote.ch1;

import io.reactivex.Observable;

import static com.suikajy.rxjavanote.util.DemoUtil.log;

public class CacheTest {

    public static void main(String[] args) {
        Observable<Integer> ints =
                Observable.<Integer>create(subscriber -> {
                    log("Create");
                    subscriber.onNext(42);
                    subscriber.onComplete();
                }).cache();
        log("Starting");
        ints.subscribe(i -> log("Element A: " + i));
        ints.subscribe(i -> log("Element B: " + i));
        log("Exit");
    }
}
