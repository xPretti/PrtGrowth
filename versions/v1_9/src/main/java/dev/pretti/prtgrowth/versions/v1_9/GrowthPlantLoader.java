package dev.pretti.prtgrowth.versions.v1_9;

import dev.pretti.prtgrowth.versions.legacy.interfaces.IGrowthPlant;
import dev.pretti.prtgrowth.versions.legacy.interfaces.IGrowthPlantLoader;
import dev.pretti.prtgrowth.versions.legacy.plants.CocoaGrowthPlant;
import dev.pretti.prtgrowth.versions.legacy.plants.GrowthPlant;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class GrowthPlantLoader implements IGrowthPlantLoader
{
  @Override
  public List<IGrowthPlant> load()
  {
    return Arrays.asList(
            new GrowthPlant(Material.CARROT, 7),
            new GrowthPlant(Material.POTATO, 7),
            new GrowthPlant(Material.CROPS, 7),
            new GrowthPlant(Material.PUMPKIN_STEM, 7),
            new GrowthPlant(Material.MELON_STEM, 7),
            new GrowthPlant(Material.NETHER_WARTS, 3),
            new CocoaGrowthPlant(),
            new GrowthPlant(Material.BEETROOT_BLOCK, 3));
  }
}