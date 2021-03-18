package hu.elte.haladojava.stream.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private final LocalDate birthDay;
    private final String name;

    public Person(LocalDate birthDay, String name) {
        this.birthDay = birthDay;
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(birthDay, person.birthDay) && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthDay, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "birthDay=" + birthDay +
                ", name='" + name + '\'' +
                '}';
    }
}
