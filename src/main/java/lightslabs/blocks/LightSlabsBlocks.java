package lightslabs.blocks;

import lightslabs.LightSlabs;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;

public class LightSlabsBlocks {
    public static Block GLOWSTONE_SLAB;
    public static Block SEA_LANTERN_SLAB;
    public static Block OCHRE_FROGLIGHT_SLAB;
    public static Block VERDANT_FROGLIGHT_SLAB;
    public static Block PEARLESCENT_FROGLIGHT_SLAB;

    public static void registerBlocks() {
        GLOWSTONE_SLAB = registerBlock(
                "glowstone_slab",
                SlabBlock::new,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.SAND)
                        .instrument(NoteBlockInstrument.PLING)
                        .strength(0.3f)
                        .sound(SoundType.GLASS)
                        .lightLevel(statex -> 15)
                        .isRedstoneConductor(Blocks::never)
        );
        SEA_LANTERN_SLAB = registerBlock(
                "sea_lantern_slab",
                SlabBlock::new,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.QUARTZ)
                        .instrument(NoteBlockInstrument.HAT)
                        .strength(0.3f)
                        .sound(SoundType.GLASS)
                        .lightLevel(statex -> 15)
        );
        OCHRE_FROGLIGHT_SLAB = registerBlock(
                "ochre_froglight_slab",
                SlabBlock::new,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.SAND)
                        .strength(0.3f)
                        .sound(SoundType.FROGLIGHT)
                        .lightLevel(statex -> 15)
        );
        VERDANT_FROGLIGHT_SLAB = registerBlock(
                "verdant_froglight_slab",
                SlabBlock::new,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.GLOW_LICHEN)
                        .strength(0.3f)
                        .sound(SoundType.FROGLIGHT)
                        .lightLevel(statex -> 15)
        );
        PEARLESCENT_FROGLIGHT_SLAB = registerBlock(
                "pearlescent_froglight_slab",
                SlabBlock::new,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.COLOR_PINK)
                        .strength(0.3f)
                        .sound(SoundType.FROGLIGHT)
                        .lightLevel(statex -> 15)
        );
    }

    private static Block registerBlock(final String identifier, final Function<BlockBehaviour.Properties, Block> factory, final BlockBehaviour.Properties properties) {
        var key = ResourceKey.create(Registries.BLOCK, LightSlabs.id(identifier));
        var block = factory.apply(properties.setId(key));
        return Registry.register(BuiltInRegistries.BLOCK, key, block);
    }
}
