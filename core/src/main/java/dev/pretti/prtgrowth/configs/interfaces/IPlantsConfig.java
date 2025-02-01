package dev.pretti.prtgrowth.configs.interfaces;

import dev.pretti.prtgrowth.enums.EnumAccessType;
import org.bukkit.Material;

import java.util.HashSet;

public interface IPlantsConfig extends IConfig
{
  EnumAccessType getAccess();

  void setAccess(EnumAccessType access);

  HashSet<Material> getPlants();

  void setPlants(HashSet<Material> plants);

  boolean isPass(Material material);
}
