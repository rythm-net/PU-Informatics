package composite;

public class CompositeMain {

    public static void main(String[] args) {

        Manager man1 = new Manager("Owner Stamat", 12000);
        Manager man2 = new Manager("VP Petar", 11000);
        Manager man3 = new Manager("Head Georgi", 10000);

        Developer dev1 = new Developer("Senior Dimitar", 7000);
        Developer dev2 = new Developer("Dev Stoyan", 5000);
        Developer dev3 = new Developer("Senior Gergana", 9000);

        man1.add(dev1);
        man1.add(man2);
        man1.add(man3);

        man2.add(dev2);
        man3.add(dev3);

        man1.printEmployeeInfo();

    }

}
