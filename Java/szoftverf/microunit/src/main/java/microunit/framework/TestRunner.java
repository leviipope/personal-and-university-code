package microunit.framework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class TestRunner {
    protected Class<?> testClass;

    public TestRunner(Class<?> testClass){
        this.testClass = testClass;
    }

    private List<Method> getMethodsAnnotatedWith(
            Class<?> klass,
            Class<? extends Annotation> annotation
    ) {
        return Arrays.stream(klass.getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(annotation))
                .toList();
    }

    public void runTests() throws Exception {
        final var testMethods = getMethodsAnnotatedWith(
                testClass,
                Test.class
        );

        final var testClassInstance = testClass
                .getConstructor()
                .newInstance();

        for (final var testMethod: testMethods){
            System.out.println(
                    "Running: " + testMethod.getName()
            );

            testMethod.invoke(
                    testClassInstance
            );
        }
    }
}
