package com.samebug.notifier.agent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ExceptionQueue {
    private ExceptionQueue() {}

    private static final int Capacity = 1000;
    private static final BlockingQueue<Throwable> Instance = new ArrayBlockingQueue<Throwable>(Capacity);

    public static BlockingQueue<Throwable> getInstance() {
        return Instance;
    }
}
