package microunit;

import microunit.framework.Test;
import microunit.framework.TestRunner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Application {
public static void main(String[] args) throws Exception{ // psvm + tab
        final var runner = new TestRunner(AddterTest.class);

        runner.runTests();
    }
}
