package com.reactive.rx.scheduler;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class IOScheduler {

    public static void main(String[] args){

        Observable.just("A","BCD","EFGH","IJK,","LMNO","PQRST","UVW","XYZ")
                .doOnNext(data -> {
                    System.out.println("Data Being sent "+data+" from Thread "+Thread.currentThread().getName());
                    introduceDelay(1000);
                    getLength(data);
                    introduceDelay(1000);
                })
                .subscribeOn(Schedulers.io())
                .subscribe(data -> {
                    System.out.println("Data received "+data+" from Thread "+Thread.currentThread().getName());
                });
        try {
            Thread.sleep(30000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }


    private static void introduceDelay(long timeInMiliSeconds){
        try {
            Thread.sleep(timeInMiliSeconds);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    private static int getLength(String input){
        return input.length();
    }
}
