package Pokemon;

import Skill.*;

public class Venusaur extends Pokemon {
    public Venusaur() {
        super("이상해꽃",80,100,90, 80, "풀","독",
                new EnergyBall(),new SludgeBomb(),new EarthPower(),new FlashCannon());
    }
}
