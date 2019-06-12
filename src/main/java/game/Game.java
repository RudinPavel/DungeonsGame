package game;

public class Game {

    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public boolean isEnd(){
        if (player1.getHero().getCurrentLevel() == 5)
        {
            System.out.println("player 1 " + player1.getName() + " won!");
            return true;
        }
        if (player2.getHero().getCurrentLevel() == 5)
        {
            System.out.println("player 2 " + player2.getName() + " won!");
            return true;
        }
        return false;
    }

    public void print(){

        String result = "";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 1; j++) {
                result += "[  ] ";
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
