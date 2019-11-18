package com.reactive.rx.observables;

import io.reactivex.Flowable;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

public class FlowableObservable<T> {


    public static <T>Flowable<T> createFlowable(T data){
        if(data==null){
            throw new NullPointerException("data cannot be null");
        }

        return Flowable.just(data);
    }


    public static <T>Flowable<T> createFlowable(T[] data){
        if(data==null){
            throw new NullPointerException("data cannot be null");
        }

        return (Flowable<T>)Flowable.fromArray(data);
    }


    /*public static <T>Flowable<T> createFlowable(Iterable<T> data){
        if(data==null){
            throw new NullPointerException("data cannot be null");
        }

        return (Flowable<T>)Flowable.fromIterable(data);
    }

    public static <T>Flowable<T> createFlowable(Future<T> data){
        if(data==null){
            throw new NullPointerException("data cannot be null");
        }

        return (Flowable<T>)Flowable.fromFuture(data);
    }*/

}
