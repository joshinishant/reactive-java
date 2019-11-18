package com.reactive.rx.observer;

import com.reactive.rx.DTO.Data;
import com.reactive.rx.observables.MayBeObservable;
import io.reactivex.Maybe;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class MayBeObserver {


    public static void main(String[] args){

        Data data= new Data("Nishant","M","Joshi");


        //Observer
        Disposable disposable= MayBeObservable.createMayBe(data)
                .delay(2, TimeUnit.SECONDS, Schedulers.single())
                .subscribeWith(new DisposableMaybeObserver<Data>() {
                    @Override
                    public void onSuccess(Data data) {
                        System.out.println("Received  "+data.toString());
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Exception Occured "+throwable.getStackTrace());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completed execution");
                    }
                });

        try {
            Thread.sleep(3000);

            disposable.dispose();

        }catch(InterruptedException e){
            if(!disposable.isDisposed()) {
                disposable.dispose();
            }
        }

        return;

    }
}
