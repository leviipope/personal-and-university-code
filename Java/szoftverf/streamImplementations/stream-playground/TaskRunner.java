import java.lang.reflect.Method;
import java.util.List;

public class TaskRunner {
    /**
     * Automatically executes a method named "feladat_current" with appropriate handling for its return type
     * @param targetClass The class containing the feladat_current method
     * @param parameters The parameters to pass to the method
     */
    public static void runCurrentTask(Class<?> targetClass, Object... parameters) {
        try {
            // Determine parameter types
            Class<?>[] paramTypes = new Class<?>[parameters.length];
            for (int i = 0; i < parameters.length; i++) {
                paramTypes[i] = parameters[i].getClass();

                // Handle List special case (need to use the interface)
                if (List.class.isAssignableFrom(paramTypes[i])) {
                    paramTypes[i] = List.class;
                }
            }

            // Get the feladat_current method using reflection
            Method method = targetClass.getMethod("feladat_current", paramTypes);

            // Check if the method returns void
            boolean isVoid = method.getReturnType() == void.class;

            // Execute the method based on its return type
            if (isVoid) {
                method.invoke(null, parameters);
            } else {
                Object result = method.invoke(null, parameters);
                if (result != null) {
                    System.out.println(result);
                }
            }
        } catch (Exception e) {
            System.err.println("Error executing feladat_current method: " + e.getMessage());
        }
    }
}