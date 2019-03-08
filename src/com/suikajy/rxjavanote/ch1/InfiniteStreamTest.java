package com.suikajy.rxjavanote.ch1;

import com.suikajy.rxjavanote.util.DemoUtil;
import io.reactivex.Observable;

public class InfiniteStreamTest {
    public static void main(String[] args) {
        Observable.create(e -> {
            int i = 0;
            while (true) {
                e.onNext(i++);
            }
        }).subscribe(DemoUtil::log);
    }
}
