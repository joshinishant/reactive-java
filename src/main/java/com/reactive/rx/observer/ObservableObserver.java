package com.reactive.rx.observer;

import com.reactive.rx.DTO.Data;
import com.reactive.rx.observables.ObservableObservable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ObservableObserver {


    public static void main(String[] args){

        //Create Observer
        Disposable disposable= ObservableObservable.createObservable(getDataList())
                .delay(2, TimeUnit.SECONDS, Schedulers.single())
                .subscribe(data -> {
                    System.out.println("Data "+data.toString());
                }, throwable -> {
                    System.out.println("exception occured "+throwable.getLocalizedMessage().toString());
                },() -> {
                    System.out.println("Completed Successfully");
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

    private static Data[] getDataList(){

        Data[] array= new Data[2];

        Data data1= new Data("Nishant","M","Joshi");
        Data data2= new Data("Nitesh","M","Joshi");

        array[0]=data1;
        array[1]=data2;

        return array;
    }


}
