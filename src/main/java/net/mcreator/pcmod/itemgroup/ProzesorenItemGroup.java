
package net.mcreator.pcmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.pcmod.block.MMD1050Block;
import net.mcreator.pcmod.PcmodModElements;

@PcmodModElements.ModElement.Tag
public class ProzesorenItemGroup extends PcmodModElements.ModElement {
	public ProzesorenItemGroup(PcmodModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabprozesoren") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MMD1050Block.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
