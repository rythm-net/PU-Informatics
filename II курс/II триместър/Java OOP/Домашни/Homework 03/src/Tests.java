import Animals.AnimalEntities;
import Enums.AnimalStateEnum;

public class Tests {
    public static void Test1(){
       AnimalEntities animal;
        animal = AnimalFoundry.createAnimal();
        animal.VisualizeStats();
        animal.useAbility();
    }
    public static void Test2(){
        AnimalEntities animal;
        animal = AnimalFoundry.createAnimal();
        AnimalFoundry.upgradeAnimal(animal);
        animal.useAbility();
        animal.VisualizeStats();
    }
    public static void Test3(){
        AnimalEntities animal;
        animal = AnimalFoundry.createAnimal();
        AnimalFoundry.upgradeAnimal(animal);
        AnimalFoundry.upgradeAnimal(animal);
        animal.useAbility();
        animal.VisualizeStats();
    }
    public static void Test4(){
        AnimalEntities animal;
        animal = AnimalFoundry.createAnimal();
        animal.setAnimalState(AnimalStateEnum.SLEEPING);
        AnimalFoundry.upgradeAnimal(animal);
    }
    public static void Test5(){
        AnimalEntities animal;
        animal = AnimalFoundry.createAnimal();
        AnimalFoundry.upgradeAnimal(animal);
        animal.useAbility();
        animal.useAbility();
        animal.useAbility();
        System.out.println("The animal is back to his normal state");
        animal.useAbility();//за да се види , че се е превърнало в обикновено животно
    }
}
