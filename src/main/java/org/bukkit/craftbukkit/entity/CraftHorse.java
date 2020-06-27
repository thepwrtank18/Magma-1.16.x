package org.bukkit.craftbukkit.entity;

import net.minecraft.entity.passive.horse.CoatColors;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.server.EntityHorse;
import net.minecraft.server.HorseColor;
import net.minecraft.server.HorseStyle;
import org.apache.commons.lang.Validate;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.inventory.CraftInventoryHorse;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.inventory.HorseInventory;

public class CraftHorse extends CraftAbstractHorse implements Horse {

    public CraftHorse(CraftServer server, HorseEntity entity) {
        super(server, entity);
    }

    @Override
    public HorseEntity getHandle() {
        return (HorseEntity) super.getHandle();
    }

    @Override
    public Variant getVariant() {
        return Variant.HORSE;
    }

    @Override
    public Color getColor() {
        return Color.values()[getHandle().getColor().a()];
    }

    @Override
    public void setColor(Color color) {
        Validate.notNull(color, "Color cannot be null");
        getHandle().func_234238_a_(CoatColors.func_234254_a_(color.ordinal()), getHandle().getStyle());
    }

    @Override
    public Style getStyle() {
        return Style.values()[getHandle().getStyle().a()];
    }

    @Override
    public void setStyle(Style style) {
        Validate.notNull(style, "Style cannot be null");
        getHandle().func_234238_a_(getHandle().variant, CoatColors.func_234254_a_(style.ordinal()));
    }

    @Override
    public boolean isCarryingChest() {
        return false;
    }

    @Override
    public void setCarryingChest(boolean chest) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public HorseInventory getInventory() {
        return new CraftInventoryHorse(getHandle().horseChest);
    }

    @Override
    public String toString() {
        return "CraftHorse{variant=" + getVariant() + ", owner=" + getOwner() + '}';
    }

    @Override
    public EntityType getType() {
        return EntityType.HORSE;
    }
}
