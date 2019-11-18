package com.reactive.rx.observer;

import com.reactive.rx.DTO.Data;
import com.reactive.rx.observables.SingleObservable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class SingleObserver {

    public static void main(String[] args){

        Data data= new Data("Nishant","M","Joshi");

        //Observer
        Disposable disposable = SingleObservable.createSingle(data)
                .delay(2000, TimeUnit.MILLISECONDS, Schedulers.single())
                .subscribe(value -> {
                    System.out.println(value);
                }, error -> {
                    System.out.println(error);
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
