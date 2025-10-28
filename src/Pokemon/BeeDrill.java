package Pokemon;

import Skill.*;

public class BeeDrill extends Pokemon{
    public BeeDrill() {
        super("독침붕",65,90,60,75,"벌레","독",
                new XScissor(), new PoisonJab(), new BrickBreak(), new AerialAce());
    }
}
