package no.runsafe.entitycontrol.pets.companions;

import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.World;
import no.runsafe.entitycontrol.pets.CompanionPetVillager;

public class BlacksmithCompanion extends CompanionPetVillager
{
	public BlacksmithCompanion(World world)
	{
		super(world);
		setProfession(3);
	}

	@Override
	public boolean a(EntityHuman entityhuman)
	{
		playSound("mob.villager.idle");
		return false;
	}
}
