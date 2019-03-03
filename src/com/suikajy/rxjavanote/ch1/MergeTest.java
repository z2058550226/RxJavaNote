package com.suikajy.rxjavanote.ch1;

import com.suikajy.rxjavanote.util.Sleeper;
import io.reactivex.Observable;

public class MergeTest {

    public static void main(String[] args) {
        Observable<String> b = Observable.create(e -> {
            new Thread(() -> {
                e.onNext("three");
                Sleeper.sleep();
                e.onNext("four");
                e.onComplete();
            }).start();
        });
        Observable<String> a = Observable.create(e -> {
            new Thread(() -> {
                e.onNext("one");
                e.onNext("two");
                e.onComplete();
            }).start();
        });
        Observable.merge(b, a)
                .subscribe(System.out::println);
    }

}
