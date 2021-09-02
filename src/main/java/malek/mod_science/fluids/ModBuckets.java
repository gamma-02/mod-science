package malek.mod_science.fluids;




import malek.mod_science.items.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;
import org.dimdev.matrix.Matrix;
import org.dimdev.matrix.RegistryEntry;

import static malek.mod_science.fluids.ModFluids.*;


public class ModBuckets {


    //just because its the way Mojang does it doesnt mean its the best way to do it!
    //ESPECALLY IF WERE GOING FOR CODE READABLITY
    //we have tools, you would do good to USE them
    @RegistryEntry("rewater_bucket")
    public static Item REWATER_BUCKET =  new BucketItem(STILL_REWATER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1).group(ModItems.MOD_SCIENCE));

    @RegistryEntry("oil_bucket")
    public static Item OIL_BUCKET =  new BucketItem(STILL_OIL, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1).group(ModItems.MOD_SCIENCE));

    @RegistryEntry("ender_dew_bucket")
    public static Item ENDER_DEW_BUCKET = new BucketItem(STILL_ENDER_DEW, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1).group(ModItems.MOD_SCIENCE));

    @RegistryEntry("glimmer_bucket")
    public static Item GLIMMER_BUCKET =  new BucketItem(STILL_GLIMMER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1).group(ModItems.MOD_SCIENCE));

    @RegistryEntry("wyld_water_bucket")
    public static Item WYLD_WATER_BUCKET =  new BucketItem(STILL_WYLD_WATER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1).group(ModItems.MOD_SCIENCE));

    @RegistryEntry("magneticite_bucket")
    public static Item MAGNETICITE_BUCKET =  new BucketItem(STILL_MAGNETICITE, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1).group(ModItems.MOD_SCIENCE));

    public static void init() {
        //REWATER_BUCKET = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rewater_bucket"), new BucketItem(STILL_REWATER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1).group(ModItems.MOD_SCIENCE)));
        //ENDER_DEW_BUCKET = Registry.register(Registry.ITEM, ModScienceId("ender_dew_bucket"), new BucketItem(STILL_ENDER_DEW, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1).group(ModItems.MOD_SCIENCE)));
        //GLIMMER_BUCKET = Registry.register(Registry.ITEM, ModScienceId("glimmer_bucket"), new BucketItem(STILL_GLIMMER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1).group(ModItems.MOD_SCIENCE)));
        //WYLD_WATER_BUCKET = Registry.register(Registry.ITEM, ModScienceId("wyld_water_bucket"), new BucketItem(STILL_WYLD_WATER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1).group(ModItems.MOD_SCIENCE)));
        //OIL_BUCKET = Registry.register(Registry.ITEM, ModScienceId("oil_bucket"), new BucketItem(STILL_OIL, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1).group(ModItems.MOD_SCIENCE)));
        //MAGNETICITE_BUCKET = Registry.register(Registry.ITEM, ModScienceId("magneticite_bucket"), new BucketItem(STILL_MAGNETICITE, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1).group(ModItems.MOD_SCIENCE)));
        Matrix.register(ModBuckets.class, Registry.ITEM);

    }


}
