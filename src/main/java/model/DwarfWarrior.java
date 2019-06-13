package model;

import game.Player;

public class DwarfWarrior extends Hero {

    private String name = "Dwarf Warrior";
    public DwarfWarrior() {
        super(50, 15, 20);
    }

    public boolean actionSpecialAction(Player p) {
        if (super.ableToDoAction(super.specialActionCost)){
            this.currentEndurance -= this.specialActionCost;
            changeLevel(1);
            p.getHero().setLevelLock(this.currentLevel);
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
