import Pokemon.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Pokemon[] arr = {
                new Venusaur(), new Charizard(), new Blastoise(), new Butterfree(), new BeeDrill(),
                new Pidgeot()
        };
        System.out.println("포켓몬 선택");
        for (int i=0; i<arr.length; i++) {
            System.out.print((i+1)+". "+arr[i].getName()+" ");
            if (i%5==4) System.out.println();
        }
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int select;
        while (true) {
            System.out.print("입력 >> ");
            select = sc.nextInt() - 1;
            if (select <= 0 || select >= arr.length) {
                System.out.println("잘못된 입력!");
                continue;
            }
            break;
        }
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
