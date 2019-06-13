package model;

public class DwarfWarrior extends Hero {

    private String name = "Dwarf Warrior";
    public DwarfWarrior() {
        super(50, 15, 20);
    }

    public boolean actionSpecialAction() {
        return true;
    }

    @Override
    public String toString() {
        return name + super.toString();
    }
}
