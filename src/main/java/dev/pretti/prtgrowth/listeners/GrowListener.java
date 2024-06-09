package dev.pretti.prtgrowth.listeners;

import dev.pretti.prtgrowth.enums.EnumGrowSideType;
import dev.pretti.prtgrowth.utils.GrowUtils;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.material.MaterialData;

public class GrowListener implements Listener
{
  /**
   * Evento de crescimento
   */
  @EventHandler
  public void onGrow(BlockGrowEvent event)
  {
    Block            block    = event.getBlock();
    EnumGrowSideType growSide = EnumGrowSideType.toEnum(block.getData());
    byte             newState = GrowUtils.getStateByte(block.getType(), growSide);
    if(newState > 0)
      {
        BlockState   state        = block.getState();
        MaterialData materialData = state.getData();
        materialData.setData(newState);
        state.setData(materialData);
        state.update();
        event.setCancelled(true);
      }
  }
}
