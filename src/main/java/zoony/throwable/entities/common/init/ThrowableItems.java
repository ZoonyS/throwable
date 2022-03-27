package zoony.throwable.entities.common.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import zoony.throwable.entities.common.item.Racket;

public class ThrowableItems {
    public static Item RACKET;
    
    public static void init() {
        RACKET = Registry.register(Registry.ITEM, new Identifier("throwable", "racket"), new Racket(ToolMaterials.STONE, 1, 1, new Item.Settings().group(ItemGroup.COMBAT)));
    }
}
