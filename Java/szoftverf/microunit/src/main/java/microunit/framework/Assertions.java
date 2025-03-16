package microunit.framework;

import java.util.Objects;

public class Assertions {
    public static void equals(Object lhs, Object rhs){
        if (!Objects.equals(lhs, rhs)) {
            throw new RuntimeException("The two objects are different");
        }
    }
}
