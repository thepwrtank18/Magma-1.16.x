package org.bukkit.craftbukkit.tag;

import net.minecraft.tags.ITag;
import net.minecraft.tags.NetworkTagCollection;
import net.minecraft.util.ResourceLocation;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.bukkit.craftbukkit.util.CraftNamespacedKey;

public abstract class CraftTag<N, B extends Keyed> implements Tag<B> {

    private final net.minecraft.tags.NetworkTagCollection<N> registry;
    private final ResourceLocation tag;
    //
    private int version = -1;
    private ITag<N> handle;

    public CraftTag(NetworkTagCollection<N> registry, ResourceLocation tag) {
        this.registry = registry;
        this.tag = tag;
    }

    protected ITag<N> getHandle() {
        if (version != registry.version) {
            handle = registry.get(tag);
            version = registry.version;
        }

        return handle;
    }

    @Override
    public NamespacedKey getKey() {
        return CraftNamespacedKey.fromMinecraft(tag);
    }
}
