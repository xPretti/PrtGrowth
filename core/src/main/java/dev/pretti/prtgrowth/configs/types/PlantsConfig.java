package dev.pretti.prtgrowth.configs.types;


import dev.pretti.prtgrowth.configs.interfaces.IConfigSetup;
import dev.pretti.prtgrowth.configs.interfaces.IPlantsConfig;
import dev.pretti.prtgrowth.configs.loaders.PlantsLoader;
import dev.pretti.prtgrowth.configs.setups.DefaultConfigSetup;
import dev.pretti.prtgrowth.enums.EnumAccessType;
import org.bukkit.Material;

import java.util.HashSet;

public class PlantsConfig implements IPlantsConfig
{
  private EnumAccessType    access;
  private HashSet<Material> plants = new HashSet<>();

  /**
   * Método de carregamento das mensagens
   */
  @Override
  public boolean load(IConfigSetup configSetup)
  {
    if(configSetup instanceof DefaultConfigSetup)
      {
        DefaultConfigSetup defaultConfigSetup = (DefaultConfigSetup) configSetup;
        return (new PlantsLoader(defaultConfigSetup).load(this));
      }
    return false;
  }

  /**
   * Retornos das mensagens
   */
  public EnumAccessType getAccess()
  {
    return access;
  }

  public void setAccess(EnumAccessType access)
  {
    this.access = access;
  }

  @Override
  public HashSet<Material> getPlants()
  {
    return plants;
  }

  @Override
  public void setPlants(HashSet<Material> plants)
  {
    this.plants = plants;
  }

  @Override
  public boolean isPass(Material material)
  {
    if(!plants.isEmpty())
      {
        boolean contains = plants.contains(material);
        switch(getAccess())
          {
            case BLACKLIST:
              return !contains;
            case WHITELIST:
              return contains;
            default:
              return false;
          }
      }
    return getAccess() == EnumAccessType.BLACKLIST;
  }
}
