package dev.pretti.prtgrowth.versions.legacy.interfaces;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.jetbrains.annotations.NotNull;

public interface IGrowthPlant
{
  boolean grow(@NotNull Block plantBlock);

  Material getMaterial();

  int getRipeMax();
}
