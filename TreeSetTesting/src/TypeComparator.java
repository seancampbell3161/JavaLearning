import java.util.Comparator;

public class TypeComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal a1, Animal a2) {
        return a1.getType().compareTo(a2.getType());
    }
}
