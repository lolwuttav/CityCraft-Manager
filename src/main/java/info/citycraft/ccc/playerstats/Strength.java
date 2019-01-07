package info.citycraft.ccc.playerstats;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Strength implements PassiveSkill{

    private String name;

    private static HashMap<UUID, Integer> level = new HashMap<>();
    private static HashMap<UUID, Integer> experience = new HashMap<>();


    public Strength()
    {

        

    }
    //TODO: LIST EVERY PLACE THE LEVEL/EXPERIENCE OF THIS CLASS WILL BE MODIFIED, ALSO WHEREVER IT IS USED TO DECIDE SOMETHING
    @Override
    public void effect(Player player)
    {

    }
}
