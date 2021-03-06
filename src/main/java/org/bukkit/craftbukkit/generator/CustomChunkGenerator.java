package org.bukkit.craftbukkit.generator;

import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;

public class CustomChunkGenerator extends InternalChunkGenerator {

    public CustomChunkGenerator(World worldchunkmanager, ChunkPrimer structuresettings) {
        super(worldchunkmanager, structuresettings);
    }

    /** todo: Magma Come back
     private final net.minecraft.server.ChunkGenerator delegate;
     private final ChunkGenerator generator;
     private final WorldServer world;
     private final Random random = new Random();

     private class CustomBiomeGrid implements BiomeGrid {

     private final BiomeStorage biome; // SPIGOT-5529: stored in 4x4 grid

     public CustomBiomeGrid(BiomeStorage biome) {
     this.biome = biome;
     }

     @Override public Biome getBiome(int x, int z) {
     return getBiome(x, 0, z);
     }

     @Override public void setBiome(int x, int z, Biome bio) {
     for (int y = 0; y < world.getWorld().getMaxHeight(); y += 4) {
     setBiome(x, y, z, bio);
     }
     }

     @Override public Biome getBiome(int x, int y, int z) {
     return CraftBlock.biomeBaseToBiome((IRegistry<BiomeBase>) biome.g, biome.getBiome(x >> 2, y >> 2, z >> 2));
     }

     @Override public void setBiome(int x, int y, int z, Biome bio) {
     biome.setBiome(x >> 2, y >> 2, z >> 2, CraftBlock.biomeToBiomeBase((IRegistry<BiomeBase>) biome.g, bio));
     }
     }

     public CustomChunkGenerator(WorldServer world, net.minecraft.server.ChunkGenerator delegate, ChunkGenerator generator) {
     super(delegate.getWorldChunkManager(), delegate.getSettings());

     this.world = world;
     this.delegate = delegate;
     this.generator = generator;
     }

     @Override public void createBiomes(IRegistry<BiomeBase> iregistry, IChunkAccess ichunkaccess) {
     // Don't allow the server to override any custom biomes that have been set
     }

     @Override public WorldChunkManager getWorldChunkManager() {
     return delegate.getWorldChunkManager();
     }

     @Override public void storeStructures(GeneratorAccessSeed generatoraccessseed, StructureManager structuremanager, IChunkAccess ichunkaccess) {
     delegate.storeStructures(generatoraccessseed, structuremanager, ichunkaccess);
     }

     @Override public int getSeaLevel() {
     return delegate.getSeaLevel();
     }

     @Override public void buildBase(RegionLimitedWorldAccess regionlimitedworldaccess, IChunkAccess ichunkaccess) {
     // Call the bukkit ChunkGenerator before structure generation so correct biome information is available.
     int x = ichunkaccess.getPos().x;
     int z = ichunkaccess.getPos().z;
     random.setSeed((long) x * 341873128712L + (long) z * 132897987541L);

     // Get default biome data for chunk
     CustomBiomeGrid biomegrid = new CustomBiomeGrid(new BiomeStorage(world.r().b(IRegistry.ay), ichunkaccess.getPos(), this.getWorldChunkManager()));

     ChunkData data;
     if (generator.isParallelCapable()) {
     data = generator.generateChunkData(this.world.getWorld(), random, x, z, biomegrid);
     } else {
     synchronized (this) {
     data = generator.generateChunkData(this.world.getWorld(), random, x, z, biomegrid);
     }
     }

     Preconditions.checkArgument(data instanceof CraftChunkData, "Plugins must use createChunkData(World) rather than implementing ChunkData: %s", data);
     CraftChunkData craftData = (CraftChunkData) data;
     ChunkSection[] sections = craftData.getRawChunkData();

     ChunkSection[] csect = ichunkaccess.getSections();
     int scnt = Math.min(csect.length, sections.length);

     // Loop through returned sections
     for (int sec = 0; sec < scnt; sec++) {
     if (sections[sec] == null) {
     continue;
     }
     ChunkSection section = sections[sec];

     csect[sec] = section;
     }

     // Set biome grid
     ((ProtoChunk) ichunkaccess).a(biomegrid.biome);

     if (craftData.getTiles() != null) {
     for (BlockPosition pos : craftData.getTiles()) {
     int tx = pos.getX();
     int ty = pos.getY();
     int tz = pos.getZ();
     Block block = craftData.getTypeId(tx, ty, tz).getBlock();

     if (block.isTileEntity()) {
     TileEntity tile = ((ITileEntity) block).createTile(world);
     ichunkaccess.setTileEntity(new BlockPosition((x << 4) + tx, ty, (z << 4) + tz), tile);
     }
     }
     }
     }

     @Override public void createStructures(IRegistryCustom iregistrycustom, StructureManager structuremanager, IChunkAccess ichunkaccess, DefinedStructureManager definedstructuremanager, long i) {
     if (generator.shouldGenerateStructures()) {
     // Still need a way of getting the biome of this chunk to pass to createStructures
     // Using default biomes for now.
     delegate.createStructures(iregistrycustom, structuremanager, ichunkaccess, definedstructuremanager, i);
     }

     }

     @Override public void doCarving(long i, BiomeManager biomemanager, IChunkAccess ichunkaccess, WorldGenStage.Features worldgenstage_features) {
     if (generator.shouldGenerateCaves()) {
     delegate.doCarving(i, biomemanager, ichunkaccess, worldgenstage_features);
     }
     }

     @Override public void buildNoise(GeneratorAccess generatoraccess, StructureManager structuremanager, IChunkAccess ichunkaccess) {
     // Disable vanilla generation
     }

     @Override public int getBaseHeight(int i, int j, HeightMap.Type heightmap_type) {
     return delegate.getBaseHeight(i, j, heightmap_type);
     }

     @Override public void addDecorations(RegionLimitedWorldAccess regionlimitedworldaccess, StructureManager structuremanager) {
     if (generator.shouldGenerateDecorations()) {
     delegate.addDecorations(regionlimitedworldaccess, structuremanager);
     }
     }

     @Override public void addMobs(RegionLimitedWorldAccess regionlimitedworldaccess) {
     if (generator.shouldGenerateMobs()) {
     delegate.addMobs(regionlimitedworldaccess);
     }
     }

     @Override public int getSpawnHeight() {
     return delegate.getSpawnHeight();
     }

     @Override public int getGenerationDepth() {
     return delegate.getGenerationDepth();
     }

     @Override public IBlockAccess a(int i, int j) {
     return delegate.a(i, j);
     }

     @Override protected Codec<? extends net.minecraft.server.ChunkGenerator> a() {
     throw new UnsupportedOperationException("Cannot serialize CustomChunkGenerator");
     }
     */
}
