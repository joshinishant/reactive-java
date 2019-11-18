package com.reactive.rx.observables;

import io.reactivex.Observable;

import java.util.Collection;
import java.util.concurrent.Future;

public class ObservableObservable<T> {


    public static <T>Observable<T> createObservable(T data){
        if(data==null){
            throw new NullPointerException("data cannot be null");
        }

        return  (Observable<T>)Observable.just(data);
    }

    public static <T>Observable<T> createObservable(T[] data){
        if(data==null){
            throw new NullPointerException("data cannot be null");
        }

        return  (Observable<T>)Observable.fromArray(data);
    }


    public static <T>Observable<T> createObservable(Iterable<T> data){
        if(data==null){
            throw new NullPointerException("data cannot be null");
        }

        return  (Observable<T>)Observable.fromIterable(data);
    }

    public static <T>Observable<T> createObservable(Future<T> data){
        if(data==null){
            throw new NullPointerException("data cannot be null");
        }

        return  (Observable<T>)Observable.fromFuture(data);
    }

}
