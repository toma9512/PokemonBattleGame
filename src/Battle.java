import Pokemon.*;
import Skill.Skill;

import java.util.*;

public class Battle {
    Pokemon attacker;
    Pokemon target;
    private final List<String> TYPE = Arrays.asList(new String[]
            {"노말","불꽃","물","풀","전기","얼음",
            "격투","독","땅","비행","에스퍼","벌레",
            "바위","고스트","드래곤","악","강철","페어리"});

    private final double[][] TYPE_EFFECTIVE = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.5, 0, 1, 1, 0.5, 1},
            {1, 0.5, 0.5, 2, 1, 2, 1, 1, 1, 1, 1, 2, 0.5, 1, 0.5, 1, 2, 1},
            {1, 2, 0.5, 0.5, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 0.5, 1, 1, 1},
            {1, 0.5, 2, 0.5, 1, 1, 1, 0.5, 2, 0.5, 1, 0.5, 2, 1, 0.5, 1, 0.5, 1},
            {1, 1, 2, 0.5, 0.5, 1, 1, 1, 0, 2, 1, 1, 1, 1, 0.5, 1, 1, 1},
            {1, 0.5, 0.5, 2, 1, 0.5, 1, 1, 2, 2, 1, 1, 1, 1, 2, 1, 0.5, 1},
            {2, 1, 1, 1, 1, 2, 1, 0.5, 1, 0.5, 0.5, 0.5, 2, 0, 1, 2, 2, 0.5},
            {1, 1, 1, 2, 1, 1, 1, 0.5, 0.5, 1, 1, 1, 0.5, 0.5, 1, 1, 0, 2},
            {1, 2, 1, 0.5, 2, 1, 1, 2, 1, 0, 1, 0.5, 2, 1, 1, 1, 2, 1},
            {1, 1, 1, 2, 0.5, 1, 2, 1, 1, 1, 1, 2, 0.5, 1, 1, 1, 0.5, 1},
            {1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 0.5, 1, 1, 1, 1, 0, 0.5, 1},
            {1, 0.5, 1, 2, 1, 1, 0.5, 0.5, 1, 0.5, 2, 1, 1, 0.5, 1, 2, 0.5, 0.5},
            {1, 2, 1, 1, 1, 2, 0.5, 1, 0.5, 2, 1, 2, 1, 1, 1, 1, 0.5, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 0.5, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 0.5, 0},
            {1, 1, 1, 1, 1, 1, 0.5, 1, 1, 1, 2, 1, 1, 2, 1, 0.5, 1, 0.5},
            {1, 0.5, 0.5, 1, 0.5, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 0.5, 2},
            {1, 0.5, 1, 1, 1, 1, 2, 0.5, 1, 1, 1, 1, 1, 1, 2, 0.5, 0.5, 1}
    };

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
        System.out.println(attacker.getName()+"의 "+skill.name+" 공격!");
        int damage = (int) (attacker.getAttack()*skill.power*effective(attacker, target, n))/(target.getDefense()*5);
        target.setHp(damage);
    }

    public double effective(Pokemon attacker, Pokemon target, int n) {
        Skill skill;
        if (n==1) skill = attacker.getSkill1();
        else if (n==2) skill = attacker.getSkill2();
        else if (n==3) skill = attacker.getSkill3();
        else skill = attacker.getSkill4();

        int attackType = TYPE.indexOf(skill.type);
        int defenseType1 = TYPE.indexOf(target.getType1());
        int defenseType2 = TYPE.indexOf(target.getType2());
        double result = TYPE_EFFECTIVE[attackType][defenseType1];
        if (defenseType2>=0) result *= TYPE_EFFECTIVE[attackType][defenseType2];
        if (result>1) System.out.println("효과가 굉장했다!");
        else if (result==0) System.out.println("효과가 없는 것 같다...");
        else if (result<1) System.out.println("효과가 별로인 것 같다...");

        return result;
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

                // 선공권 결정(0이면 내가 선공)
                int firstAttack = 0;
                if (attacker.getSpeed() == target.getSpeed()) {
                    firstAttack = (int) (Math.random()*2);
                } else if (attacker.getSpeed() < target.getSpeed()) {
                    firstAttack = 1;
                }

                int random = (int) (Math.random()*4)+1;
                if (firstAttack == 0) {
                    attack(attacker, target, n);
                    showStatus();
                    if (!target.isAlive() ) break;
                    attack(target, attacker, random);
                    showStatus();
                } else {
                    attack(target, attacker, random);
                    showStatus();
                    if (!attacker.isAlive() ) break;
                    attack(attacker, target, n);
                    showStatus();
                }
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
