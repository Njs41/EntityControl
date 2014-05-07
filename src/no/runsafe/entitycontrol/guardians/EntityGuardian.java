package no.runsafe.entitycontrol.guardians;

import net.minecraft.server.v1_7_R2.*;
import org.bukkit.craftbukkit.v1_7_R2.util.UnsafeList;

import java.lang.reflect.Field;

public class EntityGuardian extends EntityIronGolem
{
	public EntityGuardian(World world)
	{
		super(world);

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

		goalSelector.a(1, new PathfinderGoalMeleeAttack(this, 2.0D, true));
		goalSelector.a(2, new PathfinderGoalMoveTowardsTarget(this, 2.0D, 32.0F));
		goalSelector.a(3, new PathfinderGoalRandomStroll(this, 0.6D));
		goalSelector.a(4, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 6.0F));
		goalSelector.a(5, new PathfinderGoalRandomLookaround(this));
		this.targetSelector.a(1, new PathfinderGoalDefendVillage(this));
		this.targetSelector.a(2, new PathfinderGoalHurtByTarget(this, false));
		this.targetSelector.a(3, new PathfinderGoalNearestAttackableTarget(this, EntityPigZombie.class, 0, true));
	}

	@Override
	public boolean damageEntity(DamageSource damagesource, float f)
	{
		return super.damageEntity(damagesource, 0);
	}

	@Override
	protected boolean a(EntityHuman entityhuman)
	{
		return false;
	}
}