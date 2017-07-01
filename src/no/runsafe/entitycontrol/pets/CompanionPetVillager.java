package no.runsafe.entitycontrol.pets;

import net.minecraft.server.v1_8_R3.*;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.Sound;
import org.bukkit.craftbukkit.v1_8_R3.util.UnsafeList;

import java.lang.reflect.Field;

public class CompanionPetVillager extends EntityVillager implements ICompanionPet
{
	/**
	 * Constructor for CompanionPetVillager
	 * @param world World object is created in
	 */
	public CompanionPetVillager(IWorld world, IPlayer owner)
	{
		super(ObjectUnwrapper.getMinecraft(world));

		player = ObjectUnwrapper.getMinecraft(owner);
		if (player == null)
		{
			dead = true;
			return;
		}

		// Remove all default path-finders.
		try
		{
			Field gsa = PathfinderGoalSelector.class.getDeclaredField("b");
			gsa.setAccessible(true);
			gsa.set(this.goalSelector, new UnsafeList());
			gsa.set(this.targetSelector, new UnsafeList());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		this.world = world;
		goalSelector.a(0, new PathfinderGoalFloat(this));
		goalSelector.a(1, new PathfinderGoalFollowPlayer(player, this, 1.0D, 2F, 2F));
		setAgeRaw(Integer.MIN_VALUE);

		/*
		 * Silence default sounds..
		 * v1_9_R2: c
		 * v1_10_R1 and up: setSilent
		 */
		b(false);
	}

	/**
	 * In spigot this would give birth to a baby villager.
	 * Companion pets are sterile, so they don't give birth.
	 * @param entityAgeable Nothing.
	 * @return null
	 */
	@Override
	public EntityAgeable createChild(EntityAgeable entityAgeable)
	{
		return null;
	}

	/**
	 * Damages entity if possible.
	 * This entity can't be damaged.
	 * @param damagesource Source of damage
	 * @param f Amount of damage
	 * @return true if damaged, otherwise false. Always false here.
	 */
	@Override
	public boolean damageEntity(DamageSource damagesource, float f)
	{
		return false;
	}

	/**
	 * Gets the sound to be made when right clicked by a player.
	 * @return Sound to make when right clicked by a player.
	 */
	public Sound getInteractSound()
	{
		return Sound.Get("villager_idle");
	}

	/**
	 * Decides amount of loot to drop on death and drops it.
	 * Object will never drop loot.
	 * @param flag Nothing
	 * @param i Nothing / Number of items to drop.
	 */
	@Override
	protected void dropDeathLoot(boolean flag, int i)
	{
		// Do nothing! We don't want loot.
	}

	/**
	 * Entity base tick.
	 * Names of this method in various spigot versions:
	 * v1_8_R3: K
	 * v1_9_R2/v1_10_R1/v1_11_R1: U
	 * v1_12_R1: Y
	 */
	@Override
	public void K()
	{
		super.K();

		if (!player.isAlive() || !player.world.worldData.getName().equals(world.getName()) || !CompanionHandler.entityIsSummoned(this))
			dead = true;
	}

	private IWorld world;
	protected EntityPlayer player;
}
