package com.Counter_Thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Counter implements Runnable {

    String s;
    int i;
    public static volatile Map<String, Integer> counter_map = new ConcurrentHashMap<>();
    //public static volatile Map<String, Integer> counter_map = new HashMap<>();
    private volatile Thread stopMe = Thread.currentThread();

    public void stopThread() {
        stopMe = null;
    }

    public void Counter(String page, int view) {
            try {
                // The right place for the synch
                synchronized (counter_map ) {
                    if (counter_map.containsKey(page)) {
                        counter_map.put(page, counter_map.get(page) + view);
                    } else {
                        counter_map.put(page, view);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                stopThread();
            } finally {
                stopThread();
            }
    }

    public void run() {
        this.Counter(s,i);
    }

}
