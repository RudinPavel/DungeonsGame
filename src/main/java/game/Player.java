package game;

import model.Hero;

public class Player {

    private String name;
    private Hero hero;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

//    public void printHeroParams(){
//        System.out.println(hero.toString());}



    @Override
    public String toString() {
        return "Player{" +
                "" + name + "" +
                ", " + hero +
                '}';
    }
}
