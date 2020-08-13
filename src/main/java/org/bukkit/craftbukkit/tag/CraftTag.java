package org.bukkit.craftbukkit.tag;

import net.minecraft.tags.ITag;
import net.minecraft.tags.TagCollectionReader;
import net.minecraft.util.ResourceLocation;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.bukkit.craftbukkit.util.CraftNamespacedKey;

public abstract class CraftTag<N, B extends Keyed> implements Tag<B> {

    private final TagCollectionReader<N> registry;
    private final ResourceLocation tag;
    //
    private ITag<N> handle;

    public CraftTag(TagCollectionReader<N> registry, ResourceLocation tag) {
        this.registry = registry;
        this.tag = tag;
    }

    protected ITag<N> getHandle() {
        // TODO: 13/08/2020 Magma Comeback
//        if (handle == null) {
//            handle = registry.(tag);
//        }

        return handle;
    }

    @Override
    public NamespacedKey getKey() {
        return CraftNamespacedKey.fromMinecraft(tag);
    }
}
