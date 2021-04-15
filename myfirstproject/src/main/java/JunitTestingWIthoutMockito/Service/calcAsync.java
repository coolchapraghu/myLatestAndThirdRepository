package JunitTestingWIthoutMockito.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class calcAsync {

    private static CompletableFuture<String> calculateAsynce() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        List<String> list = new ArrayList<>();
        list.add("KK"); list.add("PK");    list.add("SK");

        Executors.newCachedThreadPool().submit(()->{
            try {
                System.out.println("Sleeping for 10");
                Thread.sleep(10);
                String joinStr = String.join(",", list);
                completableFuture.complete(joinStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        });
        return completableFuture;
    }

    public static void main(String[] args) {

        CompletableFuture<String> completableFuture = calculateAsynce();

        completableFuture.thenAccept(x -> System.out.println("Printing Toyota " + x));
    }
}
