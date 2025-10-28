import Pokemon.*;

public class Main {
    public static void main(String[] args) {
        Pokemon p1 = new Venusaur();
        Pokemon p2 = new Venusaur();

        Battle battle = new Battle(p1,p2);
        battle.start();
    }
}
