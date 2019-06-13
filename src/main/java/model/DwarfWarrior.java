package model;

import game.Player;

public class DwarfWarrior extends Hero {

    private String name = "Dwarf Warrior";
    public DwarfWarrior() {
        super(50, 15, 20);
    }

    public boolean actionSpecialAction(Player p) {
        return true;
    }

    @Override
    public String toString() {
        return name + super.toString();
    }
}
