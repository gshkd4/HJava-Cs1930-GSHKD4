package hu.elte.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StatisticsServiceTest {

    private StatisticsService statisticsService;

    @BeforeEach
    public void setUp() {
        statisticsService = new StatisticsService();
    }

    @ParameterizedTest(name = "{0} = name, {1} = expectedCount")
    @CsvSource({
            "TEST_NAME_NOT_IN_DATABASE, 0",
            "TEST_NAME_0, 1",
            "TEST_NAME_1, 2"
    })
    public void testCountPersonsWithName(String name, int expectedCount) {
        int actualCount = statisticsService.countPersonsWithName(name);

        Assertions.assertEquals(expectedCount, actualCount);
    }
}
