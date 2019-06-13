package model;

public class ElfScout extends Hero {

    private String name = "Elf Scout";
    public ElfScout() {
        super(40, 12, 24);
    }

    public boolean actionSpecialAction() {
        if (super.ableToDoAction(super.specialActionCost)){
            this.currentEndurance -= this.specialActionCost;
            this.currentLevel += 3;
            return true;
        }
        else {
            System.out.println("Not enough endurance for special action!");
            return false;
        }
    }

    @Override
    public String toString() {
        return name + super.toString();
    }

}
