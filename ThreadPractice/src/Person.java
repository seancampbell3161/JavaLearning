import java.util.logging.Level;
import java.util.logging.Logger;

public class Person implements Runnable{

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public void run() {

        try {
            System.out.println(firstName + " " + lastName + " has started their job");

            Thread.sleep(5000);

            System.out.println(firstName + " " + lastName + " has finished their job");
        } catch(InterruptedException e) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
