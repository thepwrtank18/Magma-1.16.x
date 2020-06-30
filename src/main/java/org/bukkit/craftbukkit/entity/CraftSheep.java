package org.bukkit.craftbukkit.entity;

import net.minecraft.entity.passive.SheepEntity;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.DyeColor;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;

public class CraftSheep extends CraftAnimals implements Sheep {
    public CraftSheep(CraftServer server, SheepEntity entity) {
        super(server, entity);
    }

    // TODO: 29/06/2020 Come back
    @Override
    public DyeColor getColor() {
//        return DyeColor.getByWoolData((byte) getHandle().getColor().getColorIndex());
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setColor(DyeColor color) {
//        getHandle().setColor(EnumColor.fromColorIndex(color.getWoolData()));
    }

    @Override
    public boolean isSheared() {
        return getHandle().getSheared();
    }

    @Override
    public void setSheared(boolean flag) {
        getHandle().setSheared(flag);
    }

    @Override
    public SheepEntity getHandle() {
        return (SheepEntity) entity;
    }

    @Override
    public String toString() {
        return "CraftSheep";
    }

    @Override
    public EntityType getType() {
        return EntityType.SHEEP;
    }
}
