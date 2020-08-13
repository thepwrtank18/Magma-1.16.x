package org.bukkit.craftbukkit.generator;

import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;

// Do not implement functions to this class, add to NormalChunkGenerator
public abstract class InternalChunkGenerator extends net.minecraft.world.chunk.Chunk {

    public InternalChunkGenerator(World worldchunkmanager, ChunkPrimer structuresettings) {
        super(worldchunkmanager, structuresettings);
    }
}
