package dev.pretti.prtgrowth.providers;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.jetbrains.annotations.NotNull;

public interface IGrowthPlant
{
  boolean grow(@NotNull Block plantBlock);

  Material getMaterial();

  int getRipeMax();
}
