package dev.pretti.prtgrowth.versions.v1_9;

import dev.pretti.prtgrowth.providers.IGrowthManager;
import dev.pretti.prtgrowth.versions.legacy.interfaces.IGrowthPlant;
import dev.pretti.prtgrowth.versions.legacy.storage.GrowthPlantStorage;
import org.bukkit.block.Block;

public class GrowthManager implements IGrowthManager
{
  private final GrowthPlantStorage growths = new GrowthPlantStorage();

  public GrowthManager()
  {
    for(IGrowthPlant name : new GrowthPlantLoader().load())
      {
        growths.getGrowths().put(name.getMaterial(), name);
      }
  }

  @Override
  public boolean grow(Block plantBlock)
  {
    IGrowthPlant plant = growths.getGrowths().get(plantBlock.getType());
    return plant != null && plant.grow(plantBlock);
  }
}
