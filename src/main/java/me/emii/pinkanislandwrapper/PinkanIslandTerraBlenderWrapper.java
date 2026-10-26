package me.emii.pinkanislandwrapper;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import terrablender.api.Regions;

@Mod(PinkanIslandTerraBlenderWrapper.MODID)
public class PinkanIslandTerraBlenderWrapper {

    public static final String MODID = "pinkanislandwrapper";

    public PinkanIslandTerraBlenderWrapper(IEventBus eventBus) {
        eventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Regions.register(new PinkanIslandRegion(ResourceLocation.fromNamespaceAndPath(MODID, "pinkan_island"), 1));
        });
    }
}
