package Pokemon;

import Skill.Skill;

public class Pokemon {
    protected String name;
    protected int hp;
    protected int attack;
    protected int defense;
    protected String type1;
    protected String type2;
    protected Skill skill1;
    protected Skill skill2;
    protected Skill skill3;
    protected Skill skill4;

    public Pokemon(String name, int hp, int attack, int defense, String type1, String type2,
                   Skill skill1, Skill skill2, Skill skill3, Skill skill4) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.type1 = type1;
        this.type2 = type2;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
        this.skill4 = skill4;
    }

    public boolean isAlive() {
        return hp>0;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public Skill getSkill1() {
        return skill1;
    }

    public Skill getSkill2() {
        return skill2;
    }

    public Skill getSkill3() {
        return skill3;
    }

    public Skill getSkill4() {
        return skill4;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setHp(int damage) {
        hp = Math.max(hp-damage, 0);
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }
}
