package lightslabs.items;

import lightslabs.LightSlabs;
import lightslabs.blocks.LightSlabsBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.BiFunction;

public class LightSlabsItems {
    public static BlockItem GLOWSTONE_SLAB;
    public static BlockItem SEA_LANTERN_SLAB;

    public static void registerItems() {
        GLOWSTONE_SLAB = registerItem(
                "glowstone_slab",
                BlockItem::new,
                LightSlabsBlocks.GLOWSTONE_SLAB,
                new Item.Properties());
        SEA_LANTERN_SLAB = registerItem(
                "sea_lantern_slab",
                BlockItem::new,
                LightSlabsBlocks.SEA_LANTERN_SLAB,
                new Item.Properties());
    }

    private static BlockItem registerItem(final String identifier, final BiFunction<Block, Item.Properties, Item> factory, final Block block, final Item.Properties properties) {
        var key = ResourceKey.create(Registries.ITEM, LightSlabs.id(identifier));
        var item = factory.apply(block, properties.useBlockDescriptionPrefix().requiredFeatures(block.requiredFeatures()).setId(key));
        return (BlockItem)Registry.register(BuiltInRegistries.ITEM, key, item);
    }
}
