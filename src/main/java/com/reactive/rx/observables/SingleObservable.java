package com.reactive.rx.observables;

import io.reactivex.Single;

public class SingleObservable<T>{


    public static <T>Single createSingle(T data){

        if(data==null) {
            throw new NullPointerException("Data cannot be null");
        }

        return Single.just(data);
    }

}
