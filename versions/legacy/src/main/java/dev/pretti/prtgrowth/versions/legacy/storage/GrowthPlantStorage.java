package dev.pretti.prtgrowth.versions.legacy.storage;

import dev.pretti.prtgrowth.versions.legacy.interfaces.IGrowthPlant;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;

public class GrowthPlantStorage
{
  private final EnumMap<Material, IGrowthPlant> growths = new EnumMap<>(Material.class);

  /**
   * Retornos
   */
  @NotNull
  public EnumMap<Material, IGrowthPlant> getGrowths()
  {
    return growths;
  }

  @Nullable
  public IGrowthPlant getGrowthPlant(Material plant)
  {
    return growths.get(plant);
  }
}
