package JunitTestingWIthoutMockito.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

class Test{

    public List<String> list;
    public CompletableFuture<String> completableFuture = new CompletableFuture<>();

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public CompletableFuture<String> getCompletableFuture() {
        return completableFuture;
    }

    public void setCompletableFuture(CompletableFuture<String> completableFuture) {
        this.completableFuture = completableFuture;
    }
}

//class Task implements Callable<CompletableFuture<String>>{
class Task implements Runnable{

    public Test test;

    public Task(Test test){

        this.test = test;
    }

    public void run(){

        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
            this.test.completableFuture.complete(String.join(" ", test.getList()));
        } catch (InterruptedException e) {

        }

    }
}

public class DemoCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

       List<String> list1 = Arrays.asList("Raghu ", "Rama ", "Reddy");
        CompletableFuture<String> completableFuture1 = new CompletableFuture<>();

        List<String> list2 = Arrays.asList("Anitha", "Kotla", "Aarav", "Reddy");
        CompletableFuture<String> completableFuture2 = new CompletableFuture<>();

        Test test1 = new Test();
        Task task1 = new Task(test1);

        test1.setList(list1);
        test1.setCompletableFuture(completableFuture1);

        Test test2 = new Test();
        Task task2 = new Task(test2);

        test2.setList(list2);
        test2.setCompletableFuture(completableFuture2);


        // executorService.submit(new Task(test1));

        executorService.submit(task1);
        executorService.submit(task2);

        task1.test.getCompletableFuture().thenAccept(System.out::println);

        List<CompletableFuture<String>> listFutures = Arrays.asList(completableFuture1,
                completableFuture2);

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(completableFuture1,
                completableFuture2);//.join(); // join is definitely a blocking call



        /*List<CompletableFuture<String>> listFutures = Arrays.asList(task1.test.getCompletableFuture(),
                task2.test.getCompletableFuture());

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(task1.test.getCompletableFuture(),
                task2.test.getCompletableFuture());//.join(); // join is definitely a blocking call */

        CompletableFuture<List<String>> allFuturesStrings = allFutures.thenApply(future -> {

            return listFutures.stream().map(complFuture -> complFuture.join())
                    .collect(Collectors.toList());
        });

        allFuturesStrings.thenAccept((x) -> x.forEach((y) -> System.out.println("Lets test" + y)));


        for(int i = 1; i<= 100; i++)
        System.out.println("Already finishing main method " + i);

    }
}
