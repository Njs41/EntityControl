package no.runsafe.entitycontrol.pets.companions;

import no.runsafe.entitycontrol.pets.CompanionPetAnimal;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.Sound;

public class SlimeCompanion extends CompanionPetAnimal
{
	public SlimeCompanion(IWorld world, IPlayer owner)
	{
		super(world, owner);
		this.datawatcher.watch(16, (byte) 1);
	}

	@Override
	public Sound getInteractSound()
	{
		return Sound.Creature.Slime.Walk;
	}
}
