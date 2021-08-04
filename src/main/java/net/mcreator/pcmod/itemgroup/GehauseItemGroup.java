
package net.mcreator.pcmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.pcmod.block.CaseLeerBlock;
import net.mcreator.pcmod.PcmodModElements;

@PcmodModElements.ModElement.Tag
public class GehauseItemGroup extends PcmodModElements.ModElement {
	public GehauseItemGroup(PcmodModElements instance) {
		super(instance, 20);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabgehause") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CaseLeerBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
