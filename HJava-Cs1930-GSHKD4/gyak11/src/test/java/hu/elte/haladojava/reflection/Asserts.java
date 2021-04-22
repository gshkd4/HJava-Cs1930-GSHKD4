package hu.elte.haladojava.reflection;

public class Asserts {

    public static void assertTrue(boolean value) {
        if (!value) {
            throw new AssertionError();
        }
    }

    public static void assertFalse(boolean value) {
        if (value) {
            throw new AssertionError();
        }
    }

    public static void assertEquals(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError();
        }
    }
}
