package no.runsafe.entitycontrol.pets.companions;

import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;

public class CatCompanionFluffers extends OcelotCompanion
{
	public CatCompanionFluffers(IWorld world, IPlayer owner)
	{
		super(world, owner);
		setCatType(3);
	}
}
