package nl.bramjanssens.generics;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        NullPointerSolutions nps = new NullPointerSolutions();

        Person person = new Person();
        Employee employee = new Employee();
        Developer developer = new Developer();

        List<Person> people = new ArrayList<>();
        List<Employee> emps = new ArrayList<>();
        List<Developer> devs = new ArrayList<>();

        // Simple types -------------
        // nps.pay(person); // not allowed
        nps.pay(employee);
        nps.pay(developer);

        // Generic types ------------
        // Invariant
        // nps.pay(people); // not allowed
        nps.payAll(emps);
        // nps.pay(devs); // not allowed

        // Covariant
        // nps.payDayCo(people); // not allowed
        nps.payAllCo(emps);
        nps.payAllCo(devs);

        // Contravariant
        nps.scaleUp(people);
        nps.scaleUp(emps);
        // nps.scaleUp(devs); // not allowed

        // Co and contra combined
        nps.migrate(emps, people);

        nps.migrate(devs, people);
        nps.migrate(devs, emps);

        // nps.migrate(people, emps); // not allowed
        // nps.migrate(people, devs); // not allowed
        // nps.migrate(people, emps); // not allowed

        // Breaking type safety
        Developer[] resources = new Developer[2];
        nps.fillWithPros(resources); // ⚡⚡⚡ exception ⚡⚡⚡
    }
}
