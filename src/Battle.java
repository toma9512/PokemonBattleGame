import Pokemon.*;
import Skill.Skill;

import java.util.Scanner;

public class Battle {
    Pokemon attacker;
    Pokemon target;
    Scanner sc = new Scanner(System.in);

    public Battle(Pokemon attacker, Pokemon target) {
        this.attacker = attacker;
        this.target = target;
    }

    public void attack(Pokemon attacker, Pokemon target, int n) {
        Skill skill;
        if (n == 1) skill = attacker.getSkill1();
        else if (n==2) skill = attacker.getSkill2();
        else if (n==3) skill = attacker.getSkill3();
        else skill = attacker.getSkill4();
        int damage = attacker.getAttack()*skill.power/(target.getDefense()*3+2);
        System.out.println(attacker.getName()+"의 "+skill.name+" 공격!");
        target.setHp(damage);
    }

    public void showStatus() {
        System.out.println("나의 "+attacker.getName()+"의 체력 : "+attacker.getHp());
        System.out.println("적의 "+target.getName()+"의 체력 : "+target.getHp());
    }

    public void start() {
        System.out.println(attacker.getName()+"을 선택하셨습니다");
        System.out.println("=== 배틀 시작! ===");
        System.out.println("야생의 "+target.getName()+"이 나타났다!");
        boolean runAway = false;
        while (attacker.isAlive() && target.isAlive()) {
            System.out.println("1. 공격\n2. 도망친다");
            System.out.print("입력 >> ");
            int n = sc.nextInt();

            if (n == 1) {
                System.out.println("1. "+attacker.getSkill1().name);
                System.out.println("2. "+attacker.getSkill2().name);
                System.out.println("3. "+attacker.getSkill3().name);
                System.out.println("4. "+attacker.getSkill4().name);
                System.out.print("입력 >> ");
                n = sc.nextInt();
                attack(attacker, target, n);
                showStatus();

                if (!target.isAlive()) break;

                int random = (int) (Math.random()*4)+1;
                attack(target, attacker, random);
                showStatus();
            }

            else if (n==2) {
                runAway = true;
                System.out.println("도망쳤다!");
                break;
            }
        }

        if (!runAway) {
            System.out.println("배틀 종료");
            System.out.println(attacker.isAlive() ? "승리" : "패배");
        }
    }
}
