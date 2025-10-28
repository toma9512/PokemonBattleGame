package Pokemon;

import Skill.*;

public class Venusaur extends Pokemon {
    public Venusaur() {
        super("이상해꽃",80,90,90, "grass","poison",
                new EnergyBall(),new SludgeBomb(),new EarthPower(),new FlashCannon());
    }
}
