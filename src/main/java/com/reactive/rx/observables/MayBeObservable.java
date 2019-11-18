package com.reactive.rx.observables;

import io.reactivex.Maybe;

public class MayBeObservable<T extends Object> {



    public static <T>Maybe<T> createMayBe(T data){

        if(data==null) {
            throw new NullPointerException("Data cannot be null");
        }

        return Maybe.just(data);
    }

}
