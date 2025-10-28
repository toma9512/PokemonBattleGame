package Pokemon;

import Skill.DarkPulse;
import Skill.DragonPulse;
import Skill.IceBeam;
import Skill.Surf;

public class Blastoise extends Pokemon{
    public Blastoise() {
        super("거북왕",79,84,102,"water","",
                new Surf(), new IceBeam(), new DragonPulse(), new DarkPulse());
    }
}
