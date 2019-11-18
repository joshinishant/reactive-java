package com.reactive.rx.subject;

public class AsyncSubject {

    public static void main(String[] args){

        StringBuilder observer1= new StringBuilder();
        StringBuilder observer2= new StringBuilder();
        StringBuilder observer3= new StringBuilder();

        io.reactivex.subjects.AsyncSubject<String> asyncSubject= io.reactivex.subjects.AsyncSubject.create();
        asyncSubject.onNext("A");
        asyncSubject.onNext("B");
        asyncSubject.subscribe(data -> {observer1.append(data);});
        asyncSubject.onNext("C");
        asyncSubject.onNext("D");
        asyncSubject.subscribe(data -> {observer2.append(data);});
        asyncSubject.onNext("E");
        asyncSubject.onComplete();
        asyncSubject.subscribe(data -> {observer3.append(data);});

        System.out.println("Observer1 "+observer1.toString());
        System.out.println("Observer2 "+observer2.toString());
        System.out.println("Observer3 "+observer3.toString());


        return;
    }
}
