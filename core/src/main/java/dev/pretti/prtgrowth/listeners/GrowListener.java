package dev.pretti.prtgrowth.listeners;

import dev.pretti.prtgrowth.PrtGrowth;
import dev.pretti.prtgrowth.configs.interfaces.IPlantsConfig;
import dev.pretti.prtgrowth.providers.IGrowthManager;
import dev.pretti.prtgrowth.versions.VersionsManager;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;

public class GrowListener implements Listener
{
  private final IPlantsConfig   plantsConfig;
  private final VersionsManager versionsManager;

  /**
   * Contrutor da classe
   */
  public GrowListener(PrtGrowth plugin)
  {
    this.plantsConfig    = plugin.getConfigManager().getPlantsConfig();
    this.versionsManager = plugin.getVersionsManager();
  }

  /**
   * Evento de crescimento
   */
  @EventHandler(priority = EventPriority.HIGHEST)
  public void onGrow(BlockGrowEvent event)
  {
    Block block = event.getBlock();
    if(plantsConfig.isPass(block.getType()))
      {
        IGrowthManager growthManager = versionsManager.getGrowthManager();
        if(growthManager != null && versionsManager.getGrowthManager().grow(block))
          {
            event.setCancelled(true);
          }
      }
  }
}
