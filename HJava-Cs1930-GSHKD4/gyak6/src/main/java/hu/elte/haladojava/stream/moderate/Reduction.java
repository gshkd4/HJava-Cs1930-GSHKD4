package hu.elte.haladojava.stream.moderate;

import hu.elte.haladojava.stream.domain.Person;

import java.util.List;

public class Reduction {

    public String joinFirstNames(List<Person> persons) {
        return persons.stream()
                .map(Person::getName)
                .reduce("", (subtotal, element) -> {
                    String tmp = "";
                    if (!subtotal.isEmpty()) {
                        tmp += ", ";
                    }

                    return subtotal + tmp + element.split(" ")[0];
                });
    }

}
