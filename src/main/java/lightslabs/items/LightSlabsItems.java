package lightslabs.items;

import lightslabs.LightSlabs;
import lightslabs.blocks.LightSlabsBlocks;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.BiFunction;

public class LightSlabsItems {
    public static BlockItem GLOWSTONE_SLAB;
    public static BlockItem SEA_LANTERN_SLAB;
    public static BlockItem OCHRE_FROGLIGHT_SLAB;
    public static BlockItem VERDANT_FROGLIGHT_SLAB;
    public static BlockItem PEARLESCENT_FROGLIGHT_SLAB;
    public static BlockItem SHROOMLIGHT_SLAB;
    public static BlockItem REDSTONE_LAMP_SLAB;

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
        OCHRE_FROGLIGHT_SLAB = registerItem(
                "ochre_froglight_slab",
                BlockItem::new,
                LightSlabsBlocks.OCHRE_FROGLIGHT_SLAB,
                new Item.Properties());
        VERDANT_FROGLIGHT_SLAB = registerItem(
                "verdant_froglight_slab",
                BlockItem::new,
                LightSlabsBlocks.VERDANT_FROGLIGHT_SLAB,
                new Item.Properties());
        PEARLESCENT_FROGLIGHT_SLAB = registerItem(
                "pearlescent_froglight_slab",
                BlockItem::new,
                LightSlabsBlocks.PEARLESCENT_FROGLIGHT_SLAB,
                new Item.Properties());
        SHROOMLIGHT_SLAB = registerItem(
                "shroomlight_slab",
                BlockItem::new,
                LightSlabsBlocks.SHROOMLIGHT_SLAB,
                new Item.Properties());
        REDSTONE_LAMP_SLAB = registerItem(
                "redstone_lamp_slab",
                BlockItem::new,
                LightSlabsBlocks.REDSTONE_LAMP_SLAB,
                new Item.Properties());
    }

    public static void registerCreativeTabs() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(content -> {
            content.accept(SEA_LANTERN_SLAB);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(content -> {
            content.accept(GLOWSTONE_SLAB);
            content.accept(OCHRE_FROGLIGHT_SLAB);
            content.accept(VERDANT_FROGLIGHT_SLAB);
            content.accept(PEARLESCENT_FROGLIGHT_SLAB);
            content.accept(SHROOMLIGHT_SLAB);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.REDSTONE_BLOCKS).register(content -> {
            content.accept(REDSTONE_LAMP_SLAB);
        });
    }
    private static BlockItem registerItem(final String identifier, final BiFunction<Block, Item.Properties, Item> factory, final Block block, final Item.Properties properties) {
        var key = ResourceKey.create(Registries.ITEM, LightSlabs.id(identifier));
        var item = factory.apply(block, properties.useBlockDescriptionPrefix().requiredFeatures(block.requiredFeatures()).setId(key));
        return (BlockItem)Registry.register(BuiltInRegistries.ITEM, key, item);
    }
}
