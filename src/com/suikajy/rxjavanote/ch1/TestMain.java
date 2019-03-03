package com.suikajy.rxjavanote.ch1;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

import java.util.concurrent.TimeUnit;

public class TestMain {
    public static void main(String[] args) throws InterruptedException {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                new Thread(() -> {
                    observableEmitter.onNext(1);
                    observableEmitter.onNext(1);
                }).start();
                new Thread(() -> {
                    observableEmitter.onNext(2);
                    observableEmitter.onNext(2);
                }).start();
            }
        }).subscribe(integer -> {
            System.out.println(integer);
        });

        TimeUnit.SECONDS.sleep(1);
    }
}
