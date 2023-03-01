package L05Inheritance.P03RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    public RandomArrayList(){
        super();
    }

    public Object getRandomElement() {
        Random random = new Random();
        int index = random.nextInt(super.size());
        Object result = super.get(index);
        super.remove(index);
        return result;
    }
}
