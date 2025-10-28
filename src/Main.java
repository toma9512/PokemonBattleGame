import Pokemon.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Pokemon[] arr = {
                new Venusaur(), new Charizard()
        };
        System.out.println("포켓몬 선택");
        for (int i=0; i<arr.length; i++) {
            System.out.println((i+1)+". "+arr[i].getName());
        }
        System.out.print("입력 >> ");
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt()-1;
        int random = -1;
        while (random == -1 || select == random) {
            random = (int) (Math.random() * arr.length);
        }
        Pokemon p1 = arr[select];
        Pokemon p2 = arr[random];

        Battle battle = new Battle(p1,p2);
        battle.start();
    }
}
