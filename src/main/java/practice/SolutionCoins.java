package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class SolutionCoins {
    public static Map<String, Integer> throwResult = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        int numberOfPeople = 10;
        List<CompletableFuture> throwers = new ArrayList<>();
        for (int i = 0; i < numberOfPeople; i++) {
            CompletableFuture.supplyAsync(()->{return 1;});
            CompletableFuture<Void> thrower = CompletableFuture.runAsync(new Thrower());
            throwers.add(thrower);
        }
        CompletableFuture.allOf(throwers.toArray(new CompletableFuture[numberOfPeople])).join();
        System.out.println("HEAD:" + throwResult.get(Thrower.HEAD));
        System.out.println("TAIL:" + throwResult.get(Thrower.TAIL));
    }
}
