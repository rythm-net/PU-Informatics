package Animals;

import Enums.AnimalStateEnum;
import Enums.UtilityTypeEnum;

public abstract class AnimalEntities {
    String name;
    int weight;
    int aggression;
    int speed;
    int energy;
    AnimalStateEnum animalState=AnimalStateEnum.AWAKE;
    UtilityTypeEnum utilityType=null;

    int abilitiesUsed=0;

    public void setWeight(int number){
        this.weight=number;
    }
    public void setAggression(int number){
        this.aggression=number;
    }
    public void setSpeed(int number){
        this.speed=number;
    }
    public void setEnergy(int number){
        this.energy=number;
    }
    public void setUtilityType(UtilityTypeEnum utilityType){
        this.utilityType=utilityType;
    }

    public int getWeight() {
        return weight;
    }

    public int getAggression() {
        return aggression;
    }

    public int getEnergy() {
        return energy;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnimalState(AnimalStateEnum animalState) {
        this.animalState = animalState;
    }

    public AnimalStateEnum getAnimalState() {
        return animalState;
    }

    public void VisualizeStats(){
        System.out.println("Name: "+this.getName());
        System.out.println("Weight: "+this.getWeight());
        System.out.println("Aggression: "+this.getAggression());
        System.out.println("Speed: "+this.getSpeed());
        System.out.println("Energy: "+this.getEnergy());
        System.out.println("Current State: "+getAnimalState().toString());
    }


    public void useAbility(){
        if(this.utilityType == null){
            noTypeAbility();
        }
        else {
            specialTypeAbility();
        }
        abilitiesUsed++;
        if(abilitiesUsed==3){
            this.setSpeed(0);
            this.setEnergy(0);
            this.setAggression(0);
            this.setWeight(0);
            this.setUtilityType(null);
        }
    }
    public abstract void noTypeAbility();
    private void specialTypeAbility(){
        if(this.utilityType.equals(UtilityTypeEnum.TRANSPORT)){
            this.setSpeed(this.getSpeed()+(this.getSpeed()/2));
        }
        if(this.utilityType.equals(UtilityTypeEnum.BATTLE)){
            this.setAggression(this.getAggression()+1);
        }
        if(this.utilityType.equals(UtilityTypeEnum.FOOD)){
            this.setWeight((int) (this.getWeight()+(this.getWeight()*0.10)));//znam che trqbva da e double no nqmam vreme da go smenq navsqkude
        }
    }

}