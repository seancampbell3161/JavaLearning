import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
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


        Set<Person> orderedSet = new TreeSet<>();
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

        System.out.println();

        System.out.println("ANIMALS-----");
        Animal dog = new Animal("Max", "Dog");
        Animal cat = new Animal("Susie", "Cat");
        Animal hippo = new Animal("Fred", "Hippo");
        Animal tiger = new Animal("Jones", "Tiger");
        Animal spider = new Animal ("Carl", "Spider");

        System.out.println("BY NAME-----");

        TreeSet<Animal> tsName = new TreeSet(new AnimalComparator());

        tsName.add(dog);
        tsName.add(cat);
        tsName.add(hippo);
        tsName.add(tiger);
        tsName.add(spider);

        for(Animal a : tsName) {
            System.out.println(a.getName() + ", " + a.getType());
        }

        System.out.println("BY TYPE-----");

        Set<Animal> tsType = new TreeSet(new TypeComparator());

        tsType.add(dog);
        tsType.add(cat);
        tsType.add(hippo);
        tsType.add(tiger);
        tsType.add(spider);

        for(Animal a : tsType) {
            System.out.println(a.getName() + ", " + a.getType());
        }
    }
}
