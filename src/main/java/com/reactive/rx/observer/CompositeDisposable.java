package com.reactive.rx.observer;

import com.reactive.rx.DTO.Data;
import com.reactive.rx.observables.FlowableObservable;
import com.reactive.rx.observables.ObservableObservable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class CompositeDisposable {


    public static void main(String[] args){

        io.reactivex.disposables.CompositeDisposable compositeDisposable= new io.reactivex.disposables.CompositeDisposable();


        //Observer 1
        Disposable flowableDisposable= FlowableObservable.createFlowable(getDataList())
                .delay(2, TimeUnit.SECONDS, Schedulers.single())
                .subscribe(data ->{
                    System.out.println(data);
                }, error -> {
                    System.out.println(error.getMessage()+error.getStackTrace().toString());
                },() -> {
                    System.out.println("Completed successfully");
                });
        compositeDisposable.add(flowableDisposable);

        //Observer 2
        Disposable observableDisposable= ObservableObservable.createObservable(getDataList())
                .delay(2, TimeUnit.SECONDS, Schedulers.single())
                .subscribe(data ->{
                    System.out.println(data);
                }, error -> {
                    System.out.println(error.getMessage()+error.getStackTrace().toString());
                },() -> {
                    System.out.println("Completed successfully");
                });

        compositeDisposable.add(observableDisposable);

        try {
            Thread.sleep(3000);

            compositeDisposable.dispose();

        }catch(InterruptedException e){
            if(!compositeDisposable.isDisposed()) {
                compositeDisposable.dispose();
            }
        }

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
