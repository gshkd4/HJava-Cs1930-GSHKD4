package hu.elte.services;

import java.util.List;

public class StatisticsService {

    Database database;

    public StatisticsService(Database database) {
        this.database = database;
    }

    // test it!
    public int countPersonsWithName(String name) {
        database.connect();

        List<Person> persons = database.findPersonsWithName(name);
        int count = persons.size();

        database.disconnect();

        return count;
    }
}
