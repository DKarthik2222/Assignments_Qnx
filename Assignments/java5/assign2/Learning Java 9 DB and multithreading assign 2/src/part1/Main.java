package part1;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String args[]) {
    	//creating thread pool with 10 threads
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.submit(getRunnable());
        }

        executorService.shutdown();
    }

    private static Runnable getRunnable() {
        return () -> {
        	String threadName = Thread.currentThread().getName();
            char[] t=threadName.toCharArray();
            System.out.println("Hello-T" + Arrays.toString(Arrays.copyOfRange(t, 8, t.length)).replace(",", "").replace("[", "").replace("]", "").replace(" ", ""));
        };
    }
}
