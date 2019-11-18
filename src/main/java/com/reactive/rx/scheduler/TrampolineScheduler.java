package com.reactive.rx.scheduler;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class TrampolineScheduler {

    public static void main(String[] args){

        Observable.just("A","BCD","EFGH","IJK,","LMNO","PQRST","UVW","XYZ")
                .doOnNext( data -> {
                    System.out.println("Data Being sent "+data+" from Thread "+Thread.currentThread().getName());
                    introduceDelay(1000);
                    getLength(data);
                    introduceDelay(1000);})
                .subscribeOn(Schedulers.trampoline())
                .subscribe(data -> {
                    System.out.println("Data Received "+data+" from Thread "+Thread.currentThread().getName());
                });



        return;
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
