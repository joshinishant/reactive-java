package com.reactive.rx.observer;

import com.reactive.rx.DTO.Data;
import com.reactive.rx.observables.FlowableObservable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlowableObserver {


    public static void main(String args[]){

        //Creating observer
        Disposable disposable = FlowableObservable.createFlowable(getDataList())
                .delay(2, TimeUnit.SECONDS, Schedulers.io())
                .subscribe(data ->{
                    System.out.println(data);
                }, error -> {
                    System.out.println(error.getMessage()+error.getStackTrace().toString());
                },() -> {
                    System.out.println("Completed successfully");
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
