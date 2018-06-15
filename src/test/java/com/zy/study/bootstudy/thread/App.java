package com.zy.study.bootstudy.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable callableImpl0 = new CallableImpl0();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(callableImpl0);
        Thread thread = new Thread(integerFutureTask);
        thread.start();

        Integer integer = integerFutureTask.get();
        System.out.println(integer);
    }
}
