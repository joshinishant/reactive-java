package com.reactive.rx.Miscellaneous;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Buffering {

    public static void main(String args[]){
        Observable<Integer> observable= Observable.just(1,2,3,4,5,6,7,8,9,10);
        observable.delay(1, TimeUnit.SECONDS, Schedulers.io())
                .buffer(3)
                .subscribe(new Observer<List<Integer>>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        System.out.println("subscribed");
                    }

                    @Override
                    public void onNext(List<Integer> integers) {
                        for(Integer data:integers){
                            System.out.println("Data "+data);
                        }
                        System.out.println("Pass completed");
                        try {
                            Thread.sleep(1000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        throwable.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completed");
                    }
                });

        try {
            Thread.sleep(20000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
