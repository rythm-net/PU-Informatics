import Animals.*;
import Enums.AnimalStateEnum;
import Enums.UtilityTypeEnum;

import java.util.Random;
import java.util.Scanner;

public class AnimalFoundry {
    private static Scanner scanner = new Scanner(System.in);

    public static AnimalEntities createAnimal(){
        AnimalMenu();
        String command= scanner.nextLine();
        AnimalEntities animal = checkAnimalType(command);
        setAnimalName(animal,command);
        rollAnimalStats(animal);


        return animal;
    }


    public void MainMenu(){// щях да имплементирам меню , но щом само тестове се изискват от нас го оставям така
        System.out.println("Choose an action");
        System.out.println("[1] - Add new animal");
        System.out.println("[2] - Browse animals");
    }

    public static void upgradeAnimal(AnimalEntities animal){
        String command;
        System.out.println("Do you want to upgrade your animal?");
        System.out.println("[Y]-Yes  [N]-No");
        command=scanner.nextLine();
        if(command.equals("Y")){
            feedingAnimal(animal);
        }
    }

    private static AnimalEntities checkAnimalType(String command){
        if(command.equals("H")){
            return new Horse();
        }
        if(command.equals("C")){
            return new Cow();
        }
        if(command.equals("Ch")){
            return new Chicken();
        }
        if(command.equals("Ca")){
            return new Camel();
        }
        if(command.equals("D")){
            return new Dog();
        }
        if(command.equals("S")){
            return new Sheep();
        }
        return new Horse();
    }
    private static void rollAnimalStats(AnimalEntities animal){
        Random random= new Random();
        int randomNum1= random.nextInt(10)+1;
        int randomNum2= random.nextInt(10)+1;
        int randomNum3= random.nextInt(10)+1;
        int randomNum4= random.nextInt(10)+1;
        animal.setWeight(randomNum1);
        animal.setAggression(randomNum2);
        animal.setEnergy(randomNum3);
        animal.setSpeed(randomNum4);
    }
    private static void chooseFood(AnimalEntities animal){
        System.out.println("Choose food");
        System.out.println("[B]-Battle Food");
        System.out.println("[T]-Travel Food");
        System.out.println("[F]-Edible Food");
        String command = scanner.nextLine();
        if(command.equals("B")){
            animal.setUtilityType(UtilityTypeEnum.BATTLE);
            animal.setName("Battle "+animal.getName());
        }
        if(command.equals("T")){
            animal.setUtilityType(UtilityTypeEnum.TRANSPORT);
            animal.setName("Transport "+animal.getName());
        }
        if(command.equals("F")){
            animal.setUtilityType(UtilityTypeEnum.FOOD);
            animal.setName("Food "+animal.getName());
        }
    }
    private static void feedingAnimal(AnimalEntities animal){
        decreaseStats(animal);
        if(animal.getAggression()==0||animal.getSpeed()==0||animal.getEnergy()==0||animal.getWeight()==0){
            animal.setAnimalState(AnimalStateEnum.SLEEPING);
        }
        if(animal.getAnimalState().equals(AnimalStateEnum.SLEEPING)){

            for (int i=1;i<4;i++){
                System.out.println("Do you want to feed the animal ?");
                System.out.println("[Y]-Yes  [N]-No");
                String command = scanner.nextLine();
                if(command.equals("Y")&&i==3){
                    chooseFood(animal);
                    return;
                }
                if(command.equals("Y")){
                    System.out.println("The animal denies your food");
                }

            }
        }
        chooseFood(animal);
    }
    private static void decreaseStats(AnimalEntities animal){
        int temp = animal.getSpeed();
        animal.setSpeed(temp--);
        int temp2 = animal.getWeight();
        animal.setWeight(temp2--);
        int temp3 = animal.getAggression();
        animal.setAggression(temp3--);
        int temp4 = animal.getEnergy();
        animal.setEnergy(temp4--);

    }
    private static void setAnimalName(AnimalEntities animal,String command){
        if(command.equals("H")){
            animal.setName("Horse");
        }
        if(command.equals("C")){
            animal.setName("Cow");
        }
        if(command.equals("Ch")){
            animal.setName("Chicken");
        }
        if(command.equals("Ca")){
            animal.setName("Camel");
        }
        if(command.equals("D")){
            animal.setName("Dog");
        }
        if(command.equals("S")){
            animal.setName("Sheep");
        }
    }
    private static void AnimalMenu(){
        System.out.println("Choose an animal");
        System.out.println("[H]-Horse");
        System.out.println("[C]-Cow");
        System.out.println("[Ch]-Chicken");
        System.out.println("[D]-Dog");
        System.out.println("[Ca]-Camel");
        System.out.println("[S]-Sheep");
    }
}
