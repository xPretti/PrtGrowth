package dev.pretti.prtgrowth.listeners;

import dev.pretti.prtgrowth.PrtGrowth;
import dev.pretti.prtgrowth.configs.interfaces.IPlantsConfig;
import dev.pretti.prtgrowth.providers.IGrowthPlant;
import dev.pretti.prtgrowth.storage.GrowthPlantStorage;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;

public class GrowListener implements Listener
{
  private final IPlantsConfig      plantsConfig;
  private final GrowthPlantStorage growthPlantStorage;

  /**
   * Contrutor da classe
   */
  public GrowListener(PrtGrowth plugin)
  {
    this.growthPlantStorage = plugin.getGrowthPlantStorage();
    this.plantsConfig       = plugin.getConfigManager().getPlantsConfig();
  }

  /**
   * Evento de crescimento
   */
  @EventHandler
  public void onGrow(BlockGrowEvent event)
  {
    Block        block = event.getBlock();
    IGrowthPlant plant = growthPlantStorage.getGrowthPlant(block.getType());
    if(plant != null)
      {
        if(plantsConfig.isPass(block.getType()))
          {
            if(plant.grow(block))
              {
                event.setCancelled(true);
              }
          }
      }
  }
}
