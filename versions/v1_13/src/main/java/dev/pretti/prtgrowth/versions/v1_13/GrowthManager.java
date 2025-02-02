package dev.pretti.prtgrowth.versions.v1_13;

import dev.pretti.prtgrowth.providers.IGrowthManager;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;

public class GrowthManager implements IGrowthManager
{
  @Override
  public boolean grow(Block plantBlock)
  {
    BlockData blockData = plantBlock.getBlockData();
    if(blockData instanceof Ageable)
      {
        Ageable ageable = (Ageable) blockData;
        ageable.setAge(ageable.getMaximumAge());
        plantBlock.setBlockData(ageable);
        return true;
      }
    return false;
  }
}
