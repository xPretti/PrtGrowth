package dev.pretti.prtgrowth.versions.legacy.plants;

import dev.pretti.prtgrowth.versions.legacy.interfaces.IGrowthPlant;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import org.jetbrains.annotations.NotNull;

public class GrowthPlant implements IGrowthPlant
{
  private final Material material;
  private final int      ripeMax;

  /**
   * Contrutor da classe
   */
  public GrowthPlant(Material material, int ripeMax)
  {
    this.material = material;
    this.ripeMax  = ripeMax;
  }

  /**
   * Implementação
   */
  @Override
  public boolean grow(@NotNull Block plantBlock)
  {
    if(plantBlock.getType() != material)
      {
        return false;
      }
    BlockState   state        = plantBlock.getState();
    MaterialData materialData = state.getData();
    materialData.setData((byte) ripeMax);
    state.setData(materialData);
    state.update();
    return true;
  }

  /**
   * Retornos
   */
  @Override
  public Material getMaterial()
  {
    return material;
  }

  @Override
  public int getRipeMax()
  {
    return ripeMax;
  }
}
