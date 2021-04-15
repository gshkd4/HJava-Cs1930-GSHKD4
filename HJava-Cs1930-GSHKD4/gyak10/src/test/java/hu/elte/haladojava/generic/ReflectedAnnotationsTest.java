package hu.elte.haladojava.generic;

import hu.elte.haladojava.reflection.MyAnnotation;
import hu.elte.haladojava.reflection.ReflectedAnnotations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ReflectedAnnotationsTest {

    @Test
    public void methodsAnnotatedBy() {
        List<String> expectedAnnotatedMethodNames = Arrays.asList("annotatedMethod1", "annotatedMethod2", "annotatedMethod3");

        List<String> annotatedMethodNames = ReflectedAnnotations.methodsAnnotatedBy(AnnotatedExample.class, MyAnnotation.class);

        Assertions.assertEquals(expectedAnnotatedMethodNames, annotatedMethodNames);
    }

    class AnnotatedExample {

        // intentionally out-of-order methods in terms of their names
        @MyAnnotation
        public void annotatedMethod3() {
        }

        @MyAnnotation
        public void annotatedMethod1() {
        }

        @MyAnnotation
        public void annotatedMethod2() {
        }

        public void notAnnotatedMethod() {
        }
    }

}
