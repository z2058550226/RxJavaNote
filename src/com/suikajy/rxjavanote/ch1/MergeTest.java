package com.suikajy.rxjavanote.ch1;

import com.suikajy.rxjavanote.util.Sleeper;
import io.reactivex.*;
import io.reactivex.schedulers.Schedulers;

public class MergeTest {

    public static void main(String[] args) {
        Single<String> a = Single.just("one");
        Single<String> b = Single.just("two").observeOn(Schedulers.io());
        a.mergeWith(b).subscribe(System.out::println);

        Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(CompletableEmitter completableEmitter) throws Exception {
                completableEmitter.onComplete();
            }
        }).subscribe(() -> {
            System.out.println("completable");
        });
    }

    public static void test() {
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
