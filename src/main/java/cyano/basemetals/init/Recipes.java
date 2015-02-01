package cyano.basemetals.init;

import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cyano.basemetals.material.MetalMaterial;
import cyano.basemetals.registry.CrusherRecipeRegistry;

public abstract class Recipes {
	
	private static boolean initDone = false;
	public static void init(){
		if(initDone)return;

		cyano.basemetals.init.Materials.init();
		cyano.basemetals.init.Blocks.init();
		cyano.basemetals.init.Items.init();
		
		initPureVanillaCrusherRecipes();
		initVanillaRecipes();
		initMetalRecipes();
		// TODO
		initDone = true;
	}
	
	
	private static void initPureVanillaCrusherRecipes(){
		// see net.minecraftforge.oredict.OreDictionary.initVanillaEntries() for vanilla oreDict names
		CrusherRecipeRegistry.addNewCrusherRecipe("stone", new ItemStack(Blocks.cobblestone,1));
		CrusherRecipeRegistry.addNewCrusherRecipe("cobblestone", new ItemStack(Blocks.gravel,1));
		CrusherRecipeRegistry.addNewCrusherRecipe(Blocks.gravel, new ItemStack(Blocks.sand,1));
		CrusherRecipeRegistry.addNewCrusherRecipe("sandstone", new ItemStack(Blocks.sand,4));
		CrusherRecipeRegistry.addNewCrusherRecipe(Blocks.glowstone, new ItemStack(Items.glowstone_dust,4));
		CrusherRecipeRegistry.addNewCrusherRecipe("oreLapis", new ItemStack(Items.dye,8,4));
		CrusherRecipeRegistry.addNewCrusherRecipe(Blocks.redstone_ore, new ItemStack(Items.redstone,6));
		CrusherRecipeRegistry.addNewCrusherRecipe(Blocks.redstone_block, new ItemStack(Items.redstone,9));
		CrusherRecipeRegistry.addNewCrusherRecipe(Blocks.reeds, new ItemStack(Items.sugar,2));
		CrusherRecipeRegistry.addNewCrusherRecipe(Items.bone, new ItemStack(Items.dye,3,15));
		CrusherRecipeRegistry.addNewCrusherRecipe(Items.blaze_rod, new ItemStack(Items.blaze_powder,2));
		CrusherRecipeRegistry.addNewCrusherRecipe("oreQuartz", new ItemStack(Items.quartz,2));
		CrusherRecipeRegistry.addNewCrusherRecipe("blockQuartz", new ItemStack(Items.quartz,4));
	}
	
	private static void initVanillaRecipes(){
		CrusherRecipeRegistry.addNewCrusherRecipe("oreIron", new ItemStack(cyano.basemetals.init.Items.iron_powder,2));
		CrusherRecipeRegistry.addNewCrusherRecipe("blockIron", new ItemStack(cyano.basemetals.init.Items.iron_powder,9));
		CrusherRecipeRegistry.addNewCrusherRecipe("ingotIron", new ItemStack(cyano.basemetals.init.Items.iron_powder,1));
		CrusherRecipeRegistry.addNewCrusherRecipe("oreGold", new ItemStack(cyano.basemetals.init.Items.gold_powder,2));
		CrusherRecipeRegistry.addNewCrusherRecipe("blockGold", new ItemStack(cyano.basemetals.init.Items.gold_powder,9));
		CrusherRecipeRegistry.addNewCrusherRecipe("ingotGold", new ItemStack(cyano.basemetals.init.Items.gold_powder,1));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(cyano.basemetals.init.Items.iron_nugget,9), new ItemStack(Items.iron_ingot)));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.iron_ingot), "xxx","xxx","xxx",'x',cyano.basemetals.init.Items.iron_nugget));
		GameRegistry.addSmelting(cyano.basemetals.init.Items.iron_powder, new ItemStack(Items.iron_ingot), 0f);
		GameRegistry.addSmelting(cyano.basemetals.init.Items.gold_powder, new ItemStack(Items.gold_ingot), 0f);
		CrusherRecipeRegistry.addNewCrusherRecipe("oreCoal", new ItemStack(cyano.basemetals.init.Items.carbon_powder,2));
		CrusherRecipeRegistry.addNewCrusherRecipe("blockCoal", new ItemStack(cyano.basemetals.init.Items.carbon_powder,9));
		CrusherRecipeRegistry.addNewCrusherRecipe(new ItemStack(Items.coal,1,0), new ItemStack(cyano.basemetals.init.Items.carbon_powder,1));
		CrusherRecipeRegistry.addNewCrusherRecipe(new ItemStack(Items.coal,1,1), new ItemStack(cyano.basemetals.init.Items.carbon_powder,1));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.coal_block), "xxx","xxx","xxx",'x',cyano.basemetals.init.Items.carbon_powder));
		
	}
	
	private static void initMetalRecipes(){
		List<MetalMaterial> exceptions = Arrays.asList(Materials.vanilla_iron,Materials.vanilla_gold); 

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(cyano.basemetals.init.Items.iron_crackhammer), " x "," / "," / ",'x',"blockIron",'/',"stickWood"));
		
		for(MetalMaterial metal : Materials.getAllMetals()){
			if(exceptions.contains(metal))continue;
			String baseName = metal.getName()+"_";
			Item axe = cyano.basemetals.init.Items.getItemByName(baseName+"axe");
			Item blend = cyano.basemetals.init.Items.getItemByName(baseName+"blend");
			Item boots = cyano.basemetals.init.Items.getItemByName(baseName+"boots");
			Item chestplate = cyano.basemetals.init.Items.getItemByName(baseName+"chestplate");
			Item crackhammer = cyano.basemetals.init.Items.getItemByName(baseName+"crackhammer");
			Item door = cyano.basemetals.init.Items.getItemByName(baseName+"door_item");
			Item helmet = cyano.basemetals.init.Items.getItemByName(baseName+"helmet");
			Item hoe = cyano.basemetals.init.Items.getItemByName(baseName+"hoe");
			Item ingot = cyano.basemetals.init.Items.getItemByName(baseName+"ingot");
			Item leggings = cyano.basemetals.init.Items.getItemByName(baseName+"leggings");
			Item nugget = cyano.basemetals.init.Items.getItemByName(baseName+"nugget");
			Item pickaxe = cyano.basemetals.init.Items.getItemByName(baseName+"pickaxe");
			Item powder = cyano.basemetals.init.Items.getItemByName(baseName+"powder");
			Item shovel = cyano.basemetals.init.Items.getItemByName(baseName+"shovel");
			Item sword = cyano.basemetals.init.Items.getItemByName(baseName+"sword");
			Block bars = cyano.basemetals.init.Blocks.getBlockByName(baseName+"bars");
			Block block = cyano.basemetals.init.Blocks.getBlockByName(baseName+"block");
			Block ore = cyano.basemetals.init.Blocks.getBlockByName(baseName+"ore");
			Block trapdoor = cyano.basemetals.init.Blocks.getBlockByName(baseName+"trapdoor");
			
			// ingot-related recipes 
			if(ore != null && powder != null){
				CrusherRecipeRegistry.addNewCrusherRecipe(ore,new ItemStack(powder,2));
			}
			if(ore != null && ingot != null){
				GameRegistry.addSmelting(ore, new ItemStack(ingot,1), 0.75f);
			}
			if(ingot != null && powder != null){
				CrusherRecipeRegistry.addNewCrusherRecipe(ingot,new ItemStack(powder,1));
				GameRegistry.addSmelting(powder, new ItemStack(ingot,1), 0);
			}
			if(ingot != null && blend != null){
				GameRegistry.addSmelting(blend, new ItemStack(ingot,1), 0);
			}
			if(ingot != null && nugget != null){
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(nugget,9), new ItemStack(ingot)));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ingot), "xxx","xxx","xxx",'x',nugget));
			}
			if(ingot != null && block != null){
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ingot,9), new ItemStack(block)));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(block), "xxx","xxx","xxx",'x',ingot));
			}
			if(ingot != null && bars != null){
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bars,16), "xxx","xxx",'x',ingot));
			}
			if(ingot != null && door != null){
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(door,3), "xx ","xx ","xx ",'x',ingot));
			}
			if(ingot != null && trapdoor != null){
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(trapdoor), "xx","xx",'x',ingot));
			}
			
			// armor and tools
			if(ingot != null && boots != null) GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(boots), "x x","x x",'x',ingot));
			if(ingot != null && helmet != null) GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(helmet), "xxx","x x",'x',ingot));
			if(ingot != null && chestplate != null) GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chestplate), "x x","xxx","xxx",'x',ingot));
			if(ingot != null && leggings != null) GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(leggings), "xxx","x x","x x",'x',ingot));
			if(ingot != null && axe != null) GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(axe), "xx ","x/ "," / ",'x',ingot,'/',"stickWood"));
			if(block != null && crackhammer != null) GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(crackhammer), " x "," / "," / ",'x',block,'/',"stickWood"));
			if(ingot != null && hoe != null) GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(hoe), "xx "," / "," / ",'x',ingot,'/',"stickWood"));
			if(ingot != null && pickaxe != null) GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(pickaxe), "xxx"," / "," / ",'x',ingot,'/',"stickWood"));
			if(ingot != null && shovel != null) GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(shovel), " x "," / "," / ",'x',ingot,'/',"stickWood"));
			if(ingot != null && sword != null) GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(sword), " x "," x "," / ",'x',ingot,'/',"stickWood"));
			
			// misc recipes
			if(ingot != null && pickaxe != null) GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.bucket), "x x"," x ",'x',ingot));
		}
		
		// alloy blends
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(cyano.basemetals.init.Items.brass_blend,3), cyano.basemetals.init.Items.copper_powder,cyano.basemetals.init.Items.copper_powder,cyano.basemetals.init.Items.zinc_powder));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(cyano.basemetals.init.Items.bronze_blend,4), cyano.basemetals.init.Items.copper_powder,cyano.basemetals.init.Items.copper_powder,cyano.basemetals.init.Items.copper_powder,cyano.basemetals.init.Items.tin_powder));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(cyano.basemetals.init.Items.steel_blend,9), cyano.basemetals.init.Items.iron_powder, cyano.basemetals.init.Items.iron_powder, cyano.basemetals.init.Items.iron_powder, cyano.basemetals.init.Items.iron_powder, cyano.basemetals.init.Items.iron_powder, cyano.basemetals.init.Items.iron_powder, cyano.basemetals.init.Items.iron_powder, cyano.basemetals.init.Items.iron_powder, cyano.basemetals.init.Items.carbon_powder));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(cyano.basemetals.init.Items.invar_blend,3), cyano.basemetals.init.Items.iron_powder,cyano.basemetals.init.Items.iron_powder,cyano.basemetals.init.Items.nickel_powder));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(cyano.basemetals.init.Items.electrum_blend,2), cyano.basemetals.init.Items.silver_powder,cyano.basemetals.init.Items.gold_powder));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(cyano.basemetals.init.Items.mithril_blend,3), cyano.basemetals.init.Items.silver_powder,cyano.basemetals.init.Items.silver_powder,cyano.basemetals.init.Items.coldiron_powder,cyano.basemetals.init.Items.mercury_ingot));
		
		
		// misc recipes
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.activator_rail,6), "x/x","x*x","x/x",'x',cyano.basemetals.init.Items.steel_ingot,'/',"stickWood",'*',Blocks.redstone_torch));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.detector_rail,6), "x x","x-x","x*x",'x',cyano.basemetals.init.Items.steel_ingot,'/',"stickWood",'-',Blocks.stone_pressure_plate, '*',"dustRedstone"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.rail,16), "x x","x/x","x x",'x',cyano.basemetals.init.Items.steel_ingot,'/',"stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.heavy_weighted_pressure_plate), "xx",'x',cyano.basemetals.init.Items.steel_ingot));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.tripwire_hook), "x  ","/  ","w  ",'x',cyano.basemetals.init.Items.steel_ingot,'/',"stickWood",'w',"plankWood"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.flint_and_steel), cyano.basemetals.init.Items.steel_ingot,Items.flint));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.hopper), "x x","x/x"," x ",'x',cyano.basemetals.init.Items.steel_ingot,'/',"chestWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.minecart), "x x","xxx",'x',cyano.basemetals.init.Items.steel_ingot));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.piston), "www","sxs","s*s",'x',cyano.basemetals.init.Items.steel_ingot,'w',"plankWood",'s',"cobblestone",'*',"dustRedstone"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.shears), "x "," x",'x',cyano.basemetals.init.Items.steel_ingot));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.shears), " x","x ",'x',cyano.basemetals.init.Items.steel_ingot));
		
		CrusherRecipeRegistry.addNewCrusherRecipe(cyano.basemetals.init.Blocks.mercury_ore,new ItemStack(cyano.basemetals.init.Items.mercury_powder,2));
		GameRegistry.addSmelting(cyano.basemetals.init.Items.mercury_powder, new ItemStack(cyano.basemetals.init.Items.mercury_ingot,1), 0);
		GameRegistry.addSmelting(cyano.basemetals.init.Blocks.mercury_ore, new ItemStack(cyano.basemetals.init.Items.mercury_ingot,1), 1);
		
	}

}