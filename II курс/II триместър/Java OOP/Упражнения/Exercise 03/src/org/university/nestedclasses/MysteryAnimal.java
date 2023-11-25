package org.university.nestedclasses;

import org.university.enums.AnimalName;

public class MysteryAnimal {

    private AnimalName name;
    private String sound = "default sound";

    private class Cow {
        public Cow() {
            sound = "Muuu";
        }
    }

    private class Dog {
        public Dog() {
            sound = "Bau";
        }
    }

    private class Cat {
        public Cat() {
            sound = "Meuw";
        }
    }

    public MysteryAnimal(AnimalName name) {
        this.name = name;

        switch (name) {
            case Bella:
                new Cow();
                break;
            case Chloe:
                new Cat();
                break;
            case Molly:
                new Dog();
                break;
            default:
                System.out.println("Unsupported Animal Name");
        }
    }

    public void showSound() {
        System.out.printf("Animal with name: %s makes: %s \n",
                this.name, this.sound);
    }
}
