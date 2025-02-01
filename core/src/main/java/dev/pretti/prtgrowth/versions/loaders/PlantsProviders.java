package dev.pretti.prtgrowth.versions.loaders;

import dev.pretti.prtgrowth.providers.IGrowthPlant;
import dev.pretti.prtgrowth.providers.IGrowthPlantLoader;
import dev.pretti.prtgrowth.storage.GrowthPlantStorage;
import dev.pretti.prtgrowth.utils.SystemUtils;
import dev.pretti.prtgrowth.utils.VersionsProviderUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlantsProviders
{
  private final GrowthPlantStorage plantsStorage;

  /**
   * Contrutor da classe
   */
  public PlantsProviders(@NotNull GrowthPlantStorage plants)
  {
    this.plantsStorage = plants;
  }

  /**
   * Método de carregamento
   */
  public void load()
  {
    plantsStorage.getGrowths().clear();
    IGrowthPlantLoader manager = getManager();
    if(manager != null)
      {
        List<IGrowthPlant> plants = manager.load();
        if(!plants.isEmpty())
          {
            for(IGrowthPlant plant : plants)
              {
                plantsStorage.getGrowths().put(plant.getMaterial(), plant);
              }
          }
      }
  }

  /**
   * Retornos
   */
  @Nullable
  private IGrowthPlantLoader getManager()
  {
    int version = SystemUtils.getServerVersionInt();
    if(version == 108)
      {
        return VersionsProviderUtils.getGrowthPlantLoader("v1_8");
      }
    else if(version >= 109)
      {
        return VersionsProviderUtils.getGrowthPlantLoader("v1_9");
      }
    return null;
  }
}
