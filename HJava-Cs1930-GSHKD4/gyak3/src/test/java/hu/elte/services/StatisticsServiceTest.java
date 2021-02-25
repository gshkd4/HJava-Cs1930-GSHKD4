package hu.elte.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class StatisticsServiceTest {

    @Mock
    private Database database;

    private StatisticsService statisticsService;

    @BeforeEach
    public void setUp() {
        database = mock(Database.class);
        statisticsService = new StatisticsService(database);
    }

    @AfterEach
    public void tearDown() {
        verifyNoMoreInteractions(database);
    }

    @ParameterizedTest(name = "{0} = name, {1} = expectedCount")
    @CsvSource({
            "TEST_NAME_NOT_IN_DATABASE, 0",
            "TEST_NAME_0, 1",
            "TEST_NAME_1, 2"
    })
    public void testCountPersonsWithName(String name, int expectedCount) {
        doNothing().when(database).connect();
        when(database.findPersonsWithName(name)).thenReturn(createPersonList(name, expectedCount));
        doNothing().when(database).disconnect();

        int actualCount = statisticsService.countPersonsWithName(name);
        Assertions.assertEquals(expectedCount, actualCount);

        verify(database).connect();
        verify(database).findPersonsWithName(name);
        verify(database).disconnect();
    }

    private List<Person> createPersonList(String name, int count) {
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            personList.add(new Person(name));
        }

        return personList;
    }
}
