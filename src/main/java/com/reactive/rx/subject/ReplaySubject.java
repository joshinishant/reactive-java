package com.reactive.rx.subject;

public class ReplaySubject {

    public static void main(String[] args){

        StringBuilder observer1= new StringBuilder();
        StringBuilder observer2= new StringBuilder();
        StringBuilder observer3= new StringBuilder();
        StringBuilder observer4= new StringBuilder();

        io.reactivex.subjects.ReplaySubject<String> replaySubject=  io.reactivex.subjects.ReplaySubject.create();
        replaySubject.onNext("A");
        replaySubject.onNext("B");
        replaySubject.subscribe(data -> {observer1.append(data);});
        replaySubject.onNext("C");
        replaySubject.onNext("D");
        replaySubject.subscribe(data -> {observer2.append(data);});
        replaySubject.onNext("E");
        replaySubject.onNext("F");
        replaySubject.subscribe(data -> {observer3.append(data);});
        replaySubject.onComplete();
        replaySubject.subscribe(data -> {observer4.append(data);});


        System.out.println("Observer1 "+observer1.toString());
        System.out.println("Observer2 "+observer2.toString());
        System.out.println("Observer3 "+observer3.toString());
        System.out.println("Observer4 "+observer4.toString());
    }

}
