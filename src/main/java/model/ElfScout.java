package model;

public class ElfScout extends Hero {

    private String name = "Elf Scout";
    public ElfScout() {
        super(40, 12, 24);
    }

    public void actionSpecialAction() {

    }

    @Override
    public String toString() {
        return name;
    }
}
