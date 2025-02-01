package dev.pretti.prtgrowth.versions.v1_8.types;

import dev.pretti.prtgrowth.providers.IGrowthPlant;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.material.CocoaPlant;
import org.bukkit.material.MaterialData;
import org.jetbrains.annotations.NotNull;

public class CocoaGrowthPlant implements IGrowthPlant
{
  /**
   * Implementação
   */
  @Override
  public boolean grow(@NotNull Block plantBlock)
  {
    BlockState   state        = plantBlock.getState();
    MaterialData materialData = state.getData();
    if(materialData instanceof CocoaPlant)
      {
        CocoaPlant cocoaPlant = (CocoaPlant) materialData;
        cocoaPlant.setSize(CocoaPlant.CocoaPlantSize.LARGE);
        state.setData(materialData);
        state.update();
        return true;
      }
    return false;
  }

  /**
   * Retornos
   */
  @Override
  public Material getMaterial()
  {
    return Material.COCOA;
  }

  @Override
  public int getRipeMax()
  {
    return 2;
  }
}
