import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class TreeSetImpl {

    public static void main(String[] args) {

        System.out.println();



        Person hero = new Person("Hero", "Garza", 9);
        Person zoey = new Person("Zoey", "Catkins", 7);
        Person pickles = new Person("Pickles", "Edwards", 2);

        ArrayList<Person> myList = new ArrayList<>();
        myList.add(hero);
        myList.add(zoey);
        myList.add(pickles);

        Collections.sort(myList);
        for(Person p : myList) {
            System.out.println(p.getLastName() + ", " + p.getFirstName() + ": " + p.getAge());
        }


        TreeSet<Person> orderedSet = new TreeSet<>();
        orderedSet.add(hero);
        orderedSet.add(zoey);
        orderedSet.add(pickles);

        System.out.println();
        System.out.println("TREESET HERE-----");
        System.out.println();

        for(Person p : orderedSet) {
            System.out.println(p.getInfo());
        }
        //orderByLastName(myList);
    }
}
