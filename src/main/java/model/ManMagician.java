package model;

import game.Player;

public class ManMagician extends Hero {

    private String name = "Man Magician";
    public ManMagician() {
        super(30, 13, 15);
    }

    public boolean actionSpecialAction(Player p) {
        if (super.ableToDoAction(super.specialActionCost)){
            this.currentEndurance -= this.specialActionCost;

            if (p.getHero().getCurrentLevel() - this.currentLevel == 1) { // стоит на уровень ниже
                p.getHero().setCurrentLevel(this.currentLevel);
                this.currentLevel += 1;
                System.out.println("Change levels!");
            }
            else {
                this.currentLevel += 1;
                System.out.println("Just descent!");
            }

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
