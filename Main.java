package com.Counter_Thread;


public class Main {

    public static void main(String[] args) {

        String[] pages = {"index", "services", "mission", "about","contacts"};

        for (int n = 0; n < 50; n++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 10; j++) {
                    Runnable counter = new Counter();
                    ((Counter) counter).s = pages[i];
                    new Thread(counter).start();
                    ((Counter) counter).Counter(pages[i], j);
                }
            }
        }

        System.out.println(Counter.counter_map);
    }
}
