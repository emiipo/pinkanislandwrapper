package me.emii.pinkanislandwrapper;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils.*;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class PinkanIslandRegion extends Region {

    private static final ResourceKey<Biome> PINKAN_ISLAND = ResourceKey.create(
            Registries.BIOME,
            ResourceLocation.fromNamespaceAndPath("cobbletwo", "pinkan_island")
    );

    public PinkanIslandRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

        // Ocean continentalness, one erosion tier, one weirdness slot = rare
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(Temperature.COOL, Temperature.NEUTRAL, Temperature.WARM)
                .continentalness(Continentalness.OCEAN)
                .erosion(Erosion.EROSION_2)
                .weirdness(Weirdness.PEAK_NORMAL)
                .depth(Depth.SURFACE, Depth.FLOOR)
                .build().forEach(point -> builder.add(point, PINKAN_ISLAND));

        builder.build().forEach(mapper);
    }
}
