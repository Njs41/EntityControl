package no.runsafe.entitycontrol.pets.companions;

import no.runsafe.entitycontrol.pets.CompanionPetVillager;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;

public class LibrarianCompanion extends CompanionPetVillager
{
	public LibrarianCompanion(IWorld world, IPlayer owner)
	{
		super(world, owner);
		setProfession(1);
	}
}
