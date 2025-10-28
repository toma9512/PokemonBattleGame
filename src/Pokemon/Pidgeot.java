package Pokemon;

import Skill.*;

public class Pidgeot extends Pokemon{
    public Pidgeot() {
        super("피죤투",83,80,75,101,"비행","노말",
                new AirSlash(), new Facade(), new SteelWing(), new UTurn());
    }
}
