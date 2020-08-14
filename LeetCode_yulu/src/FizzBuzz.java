import java.util.ArrayList;
import java.util.*;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {

        List<String> list = new ArrayList<>();


        for (int i = 1; i <= n; i ++) {
            if (i % 3 == 0 && i % 5 == 0 ) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add("" + i + "");
            }
        }

        return list;

    }


    public void test() {
        List<String> strings = fizzBuzz(5);
        for (int i = 0 ; i < strings.size(); i ++ ){
            System.out.println(strings.get(i));
        }
    }

}