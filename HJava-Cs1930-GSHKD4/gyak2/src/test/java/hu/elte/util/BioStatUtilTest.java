package hu.elte.util;

import hu.elte.util.BioStatUtil.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class BioStatUtilTest {

    private InputStream inputStream;

    @BeforeEach
    public void setUp() throws IOException {
        String resourceName = "/biostats.csv";
        URL resource = BioStatUtil.class.getResource(resourceName);
        inputStream = resource.openStream();
    }

    @ParameterizedTest(name = "{0} = age, {1} = expectedCount")
    @CsvSource({
            "40, 4",
            "100, 0"
    })
    public void testCountOlderThan(int age, int expectedCount) {
        int actualCount = BioStatUtil.countOlderThan(age, inputStream);

        Assertions.assertEquals(expectedCount, actualCount);
    }

    @ParameterizedTest(name = "{0} = age, {1} = expectedAverageHeight")
    @CsvSource({
            "F, 123.28",
            "M, 161.63"
    })
    public void testAverageHeight(String age, double expectedAverageHeight) {
        double actualAverageHeight = BioStatUtil.averageHeight(Gender.valueOf(age), inputStream);

        Assertions.assertEquals(expectedAverageHeight, actualAverageHeight, 0.01);
    }
}
