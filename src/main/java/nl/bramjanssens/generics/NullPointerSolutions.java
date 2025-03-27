package nl.bramjanssens.generics;

import java.util.List;

public class NullPointerSolutions {
    public void pay(Employee e) {
        e.pay();
    }

    public void payAll(List<Employee> es) {
        es.forEach(Employee::pay);  // read
        es.add(new ProductOwner()); // write
    }

    public void payAllCo(List<? extends Employee> es) {
        es.forEach(Employee::pay);     // read
        // es.add(new Employee()); // write
        // es.add(new ProductOwner()); // write
    }

    public void scaleUp(List<? super Employee> team) {
        // Write -----------
        // Allowed are Employee and its subtypes:
        team.add(new Developer());
        team.add(new Manager());
        team.add(new ProductOwner());

        // Not allowed:
        // - Supertypes of Employee
        // team.add(new Person());
        // team.add(new Object());

        // - Unrelated types
        // team.add(new String());
        // team.add(42);

        // Read  -----------
        // Allowed, but type is Object
        Object first = team.getFirst();
    }

    void migrate(List<? extends Employee> from, List<? super Employee> to) {
        for (int i = 0; i < from.size(); i++) {
            Employee e = from.get(i);
            from.remove(e);
            to.add(e);
        }
    }

    void fillWithPros(Employee[] team) {
        team[0] = new Developer();
        team[1] = new Manager();
    }
}
