package game;

import model.DwarfWarrior;
import model.ElfScout;
import model.ManMagician;

public class Game {

    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public boolean isEnd(){
        if (player1.getHero().getCurrentLevel() >= 500)
        {
            System.out.println("player 1 " + player1.getName() + " won!");
            return true;
        }
        if (player2.getHero().getCurrentLevel() >= 500)
        {
            System.out.println("player 2 " + player2.getName() + " won!");
            return true;
        }
        return false;
    }

    private String printHeroShortName(Player player){
        if (player.getHero().getClass() == DwarfWarrior.class){
            return "dw";
        }
        if (player.getHero().getClass() == ElfScout.class){
            return "es";
        }
        if (player.getHero().getClass() == ManMagician.class){
            return "mm";
        }
        return "";
    }

    public void print(){

        String result = "";
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 1; j++) {
                result += "[ ";

                if (player1.getHero().getCurrentLevel() == (i+1))
                    result += printHeroShortName(player1) + " ";

                if (player2.getHero().getCurrentLevel() == (i+1))
                    result += printHeroShortName(player2);

                result += " ] ";
            }
            result += (i+1) + " level";
            result += '\n';
            result += " || ";
            result += '\n';
        }

        System.out.println(result);
    }

    public void nextStep() {
    }
}
