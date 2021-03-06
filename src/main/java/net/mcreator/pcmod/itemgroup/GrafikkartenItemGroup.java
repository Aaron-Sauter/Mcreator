
package net.mcreator.pcmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.pcmod.block.MRX5500Block;
import net.mcreator.pcmod.PcmodModElements;

@PcmodModElements.ModElement.Tag
public class GrafikkartenItemGroup extends PcmodModElements.ModElement {
	public GrafikkartenItemGroup(PcmodModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabgrafikkarten") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MRX5500Block.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
