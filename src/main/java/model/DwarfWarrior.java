package model;

public class DwarfWarrior extends Hero {

    private String name = "Dwarf Warrior";
    public DwarfWarrior() {
        super(50, 15, 20);
    }

    public void actionSpecialAction() {

    }

    @Override
    public String toString() {
        return name;
    }
}
