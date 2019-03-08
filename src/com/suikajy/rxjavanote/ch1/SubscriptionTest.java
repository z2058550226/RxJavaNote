package com.suikajy.rxjavanote.ch1;

import io.reactivex.Observable;

public class SubscriptionTest {

    public static void main(String[] args) {
        Observable.create(subscriber -> {
            Thread thread = new Thread(() -> {
            });
            thread.start();
        });
    }
}
