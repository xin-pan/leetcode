package practice;

import java.util.Random;

public class Thrower extends Thread {

    public static final String HEAD = "HEAD";
    public static final String TAIL = "TAIL";

    @Override
    public void run() {
        Random random = new Random();
        int throwTimes = random.nextInt(50);
        try {
            this.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread[" + Thread.currentThread().getId() + "]" + " total throw times: " + throwTimes);
        for (int i = 0; i < throwTimes; i++) {
            boolean isHead = random.nextBoolean();
            System.out.println("Thread[" + Thread.currentThread().getId() + "]"+"  Throw result, isHead: " + isHead);
            if (isHead) {
                SolutionCoins.throwResult.put(HEAD, SolutionCoins.throwResult.getOrDefault(HEAD, 0) + 1);
            } else {
                SolutionCoins.throwResult.put(TAIL, SolutionCoins.throwResult.getOrDefault(TAIL, 0) + 1);
            }
        }
    }
}
