package org.bukkit.craftbukkit.entity;

import net.minecraft.entity.passive.WolfEntity;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.DyeColor;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wolf;

public class CraftWolf extends CraftTameableAnimal implements Wolf {
    public CraftWolf(CraftServer server, WolfEntity wolf) {
        super(server, wolf);
    }

    @Override
    public boolean isAngry() {
//        return getHandle().isAngry(); // TODO: 29/06/2020 Come Back
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setAngry(boolean angry) {
        if (angry) {
//            getHandle().anger();
//        } else {
//            getHandle().pacify();
        }
    }

    @Override
    public WolfEntity getHandle() {
        return (WolfEntity) entity;
    }

    @Override
    public EntityType getType() {
        return EntityType.WOLF;
    }

    @Override
    public DyeColor getCollarColor() {
//        return DyeColor.getByWoolData((byte) getHandle().getCollarColor().getColorIndex());
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setCollarColor(DyeColor color) {
//        getHandle().setCollarColor(EnumColor.fromColorIndex(color.getWoolData()));
    }
}
