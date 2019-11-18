package com.reactive.rx.subject;

import org.reactivestreams.Publisher;

public class PublishSubject {



    public static void main(String[] args){

        io.reactivex.subjects.PublishSubject<String> publishSubject= io.reactivex.subjects.PublishSubject.create();

        StringBuilder observer1= new StringBuilder();
        StringBuilder observer2= new StringBuilder();

        publishSubject.onNext("A");
        publishSubject.subscribe(data ->{observer1.append(data);});
        publishSubject.onNext("B");
        publishSubject.onNext("C");
        publishSubject.onNext("D");
        publishSubject.subscribe(data -> {observer2.append(data);});
        publishSubject.onNext("E");
        publishSubject.onNext("F");
        publishSubject.onNext("G");
        publishSubject.onComplete();


        System.out.println("Observer1 "+observer1.toString());
        System.out.println("Observer2 "+observer2.toString());

        return;
    }
}
