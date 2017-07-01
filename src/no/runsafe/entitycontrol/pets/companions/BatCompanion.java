package no.runsafe.entitycontrol.pets.companions;

import no.runsafe.entitycontrol.pets.CompanionPetAnimal;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.Sound;

public class BatCompanion extends CompanionPetAnimal
{
	public BatCompanion(IWorld world, IPlayer owner)
	{
		super(world, owner);
	}

	@Override
	public Sound getInteractSound()
	{
		return Sound.Creature.Bat.Idle;
	}
}
