package Pokemon;

import Skill.AirSlash;
import Skill.DragonPulse;
import Skill.Flamethrower;
import Skill.ScorchingSands;

public class Charizard extends Pokemon {
    public Charizard() {
        super("리자몽",78,96,81, 100, "불꽃", "비행",
                new Flamethrower(), new AirSlash(), new DragonPulse(), new ScorchingSands());
    }
}
