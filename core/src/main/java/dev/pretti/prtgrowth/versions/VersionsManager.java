package dev.pretti.prtgrowth.versions;

import dev.pretti.prtgrowth.storage.GrowthPlantStorage;
import dev.pretti.prtgrowth.versions.loaders.PlantsProviders;

public class VersionsManager
{
  public VersionsManager(GrowthPlantStorage growthPlantStorage)
  {
    new PlantsProviders(growthPlantStorage).load();
  }
}
