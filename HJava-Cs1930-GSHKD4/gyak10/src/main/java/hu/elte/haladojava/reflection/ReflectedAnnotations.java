package hu.elte.haladojava.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectedAnnotations {

    /**
     * Returns with a list of method names where the methods are public and annotated by {@code annotation}.
     * The method names are lexicographically sorted using {@link String}'s natural order.
     *
     * @param annotation
     * @param <T>
     * @return
     */
    public static <T extends Annotation> List<String> methodsAnnotatedBy(Class<?> clazz, Class<T> annotation) {
        return Arrays
                .stream(clazz.getMethods())
                .filter(method -> method.isAnnotationPresent(annotation))
                .map(Method::getName)
                .sorted()
                .collect(Collectors.toList());
    }

}
