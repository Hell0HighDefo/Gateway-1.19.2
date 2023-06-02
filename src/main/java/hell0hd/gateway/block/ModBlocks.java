package hell0hd.gateway.block;

import hell0hd.gateway.Gateway;
import hell0hd.gateway.block.custom.EyeCageBlock;
import hell0hd.gateway.block.custom.TheGatewayBlockX;
import hell0hd.gateway.block.custom.TheGatewayBlockZ;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.minecraft.block.Material.GLASS;
import static net.minecraft.block.Material.STONE;

public class ModBlocks {
    public static final Block THE_GATEWAYX = registerBlock("the_gatewayx",
            new TheGatewayBlockX(AbstractBlock.Settings.of(Material.PORTAL).noCollision().resistance(-1.0f).ticksRandomly().strength(50.0f, 1200.0f).sounds(BlockSoundGroup.GLASS).luminance(state -> 11).nonOpaque()), ItemGroup.MISC);

    public static final Block THE_GATEWAYZ = registerBlock("the_gatewayz",
            new TheGatewayBlockZ(AbstractBlock.Settings.of(Material.PORTAL).noCollision().resistance(-1.0f).ticksRandomly().strength(50.0f, 1200.0f).sounds(BlockSoundGroup.GLASS).luminance(state -> 11).nonOpaque()), ItemGroup.MISC);

    public static final Block REINFORCED_STONE = registerBlock("reinforced_stone",
            new Block(FabricBlockSettings.of(STONE).resistance(-1.0f).strength(55.0f, 1200.0f)), ItemGroup.BUILDING_BLOCKS);

    public static final Block EYE_CAGE = registerBlock("eye_cage",
            new EyeCageBlock(FabricBlockSettings.of(GLASS).sounds(BlockSoundGroup.GLASS).strength(0.3f, 0f)), ItemGroup.MISC);

    public static final Block STONE_PILLAR = registerBlock("stone_pillar",
    new Block(FabricBlockSettings.of(STONE).requiresTool().strength(1.5f, 6.0f)), ItemGroup.BUILDING_BLOCKS);


    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);

        return Registry.register(Registry.BLOCK, new Identifier(Gateway.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(Gateway.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }
    public static void registerModBlocks() {
        Gateway.LOGGER.debug("Registering ModBlocks for "+ Gateway.MOD_ID);
    }
}