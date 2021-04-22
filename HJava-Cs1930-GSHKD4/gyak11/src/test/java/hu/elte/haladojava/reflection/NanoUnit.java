package hu.elte.haladojava.reflection;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NanoUnit {

    private static List<TestResult> testResults;

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        testResults = new ArrayList<>();

        System.out.println("Test Results");
        for (String className: args) {
            runTestsForClass(className);

            System.out.println("\n" + className);
            for (TestResult testResult : testResults) {
                testResult.printResult();
            }

            testResults.clear();
        }
    }

    private static void runTestsForClass(String className) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> testClass = Class.forName(className);
        Object testObject = testClass.getDeclaredConstructor().newInstance();

        List<Method> methods = Arrays.asList(testClass.getMethods());
        Collections.shuffle(methods);

        methods.stream()
                .filter(method -> method.isAnnotationPresent(TestCase.class))
                .forEach(method -> invokeTest(testObject, method));
    }

    private static void invokeTest(Object testObject, Method method) {
        Throwable throwable = null;

        try {
            method.invoke(testObject);
        } catch (InvocationTargetException e) {
            throwable = e.getTargetException();
        } catch (Exception e) {
            throwable = e;
        }

        testResults.add(new TestResult(method, throwable));
    }

    private static class TestResult {

        private final Method method;
        private final Throwable throwable;

        private TestResult(Method method, Throwable throwable) {
            this.method = method;
            this.throwable = throwable;
        }

        private void printResult() {
            if (throwable == null || method.getAnnotation(TestCase.class).expected().equals(throwable.getClass())) {
                System.out.println(method.getName() + "() passed");
            } else {
                System.out.println(method.getName() + "() failed");
                System.out.print("\t" + ExceptionUtils.getStackTrace(throwable));
            }
        }
    }
}
