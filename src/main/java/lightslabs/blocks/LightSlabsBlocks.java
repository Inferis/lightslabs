package lightslabs.blocks;

import lightslabs.LightSlabs;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;

public class LightSlabsBlocks {
    public static Block GLOWSTONE_SLAB;
    public static Block SEA_LANTERN_SLAB;

    public static void registerBlocks() {
        GLOWSTONE_SLAB = registerBlock(
                "glowstone_slab",
                GlowstoneSlabBlock::new,
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
                GlowstoneSlabBlock::new,
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.QUARTZ)
                        .instrument(NoteBlockInstrument.HAT)
                        .strength(0.3f)
                        .sound(SoundType.GLASS)
                        .lightLevel(statex -> 15)
                        .isRedstoneConductor(Blocks::never)
        );
    }

    private static Block registerBlock(final String identifier, final Function<BlockBehaviour.Properties, Block> factory, final BlockBehaviour.Properties properties) {
        var key = ResourceKey.create(Registries.BLOCK, LightSlabs.id(identifier));
        var block = factory.apply(properties.setId(key));
        return Registry.register(BuiltInRegistries.BLOCK, key, block);
    }
}
