import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PersonTest {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i = 0; i < 3; i++) {
            executor.submit(new Person("SpongeBob", "SquarePants"));
        }

        executor.shutdown();

        System.out.println("All tasks submitted");

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch(InterruptedException e) {
            java.util.logging.Logger.getLogger(PersonTest.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }

        System.out.println("All tasks are finished");
    }
}
