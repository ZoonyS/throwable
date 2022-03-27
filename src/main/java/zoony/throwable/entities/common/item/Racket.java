package zoony.throwable.entities.common.item;

import net.minecraft.item.Item;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.BlockTags;

public class Racket extends MiningToolItem {

    public Racket(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(attackDamage, attackSpeed, material, BlockTags.HOE_MINEABLE, settings);
    }
    
}
