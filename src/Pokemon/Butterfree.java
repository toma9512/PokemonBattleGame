package Pokemon;

import Skill.*;

public class Butterfree extends Pokemon{
    public Butterfree() {
        super("버터플",60,90,65,70, "벌레", "비행",
                new AirSlash(), new BugBuzz(), new Psychic(), new EnergyBall());
    }
}
