package nl.bramjanssens.generics;

public class Person {
    void speak() { }
}

class Employee extends Person {
    void pay() { }
}

class Developer extends Employee { }

class Manager extends Employee { }

class ProductOwner extends Employee { }

