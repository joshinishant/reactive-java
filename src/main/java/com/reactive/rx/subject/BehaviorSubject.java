package com.reactive.rx.subject;

public class BehaviorSubject {


    public static void main(String[] args){

        io.reactivex.subjects.BehaviorSubject<String> behaviorSubject= io.reactivex.subjects.BehaviorSubject.create();

        StringBuilder observer1= new StringBuilder();
        StringBuilder observer2= new StringBuilder();
        StringBuilder observer3= new StringBuilder();

        behaviorSubject.onNext("A");
        behaviorSubject.onNext("B");
        behaviorSubject.subscribe(data -> {observer1.append(data);});
        behaviorSubject.onNext("C");
        behaviorSubject.onNext("D");
        behaviorSubject.onNext("E");
        behaviorSubject.onNext("F");
        behaviorSubject.subscribe(data -> {observer2.append(data);});
        behaviorSubject.onNext("G");
        behaviorSubject.onNext("H");
        behaviorSubject.onNext("I");
        behaviorSubject.subscribe(data -> {observer3.append(data);});
        behaviorSubject.onComplete();


        System.out.println("Observer1 "+observer1.toString());
        System.out.println("Observer2 "+observer2.toString());
        System.out.println("Observer3 "+observer3.toString());

        return;
    }
}
