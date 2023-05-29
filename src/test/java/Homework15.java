
import org.testng.annotations.Test;

import java.util.HashMap;
public class Homework15  extends BaseTest {
    @Test
    public void namesAndAddress() {


        HashMap<Integer, String> streetNumberAndNames = new HashMap<>();
        streetNumberAndNames.put(1000, "Liam");
        streetNumberAndNames.put(1001, "Noah");
        streetNumberAndNames.put(1002, "Olivia");
        streetNumberAndNames.put(1003, "Emma");
        streetNumberAndNames.put(1004, "Benjamin");
        streetNumberAndNames.put(1005, "Evelyn");
        streetNumberAndNames.put(1006, "Lucas");

        System.out.println(streetNumberAndNames.get(1004));
        for (
                int num : streetNumberAndNames.keySet()) {
            if (num % 2 != 0) {
                System.out.println("Street number: " + num + " |Name: " + streetNumberAndNames.get(num));
            }
        }
    }
    }
