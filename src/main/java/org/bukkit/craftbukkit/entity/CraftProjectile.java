package org.bukkit.craftbukkit.entity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Projectile;
import org.bukkit.projectiles.ProjectileSource;

public abstract class CraftProjectile extends AbstractProjectile implements Projectile {
    public CraftProjectile(CraftServer server, net.minecraft.entity.Entity entity) {
        super(server, entity);
    }

    @Override
    public ProjectileSource getShooter() {
        return getHandle().projectileSource;
    }

    @Override
    public void setShooter(ProjectileSource shooter) {
        if (shooter instanceof CraftLivingEntity) {
            getHandle().setShooter((LivingEntity) ((CraftLivingEntity) shooter).entity);
        } else {
            getHandle().setShooter(null);
        }
        getHandle().projectileSource = shooter;
    }

    @Override
    public ThrowableEntity getHandle() {
        return (ThrowableEntity) entity;
    }

    @Override
    public String toString() {
        return "CraftProjectile";
    }
}
