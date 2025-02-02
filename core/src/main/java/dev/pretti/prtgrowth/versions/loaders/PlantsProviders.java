package dev.pretti.prtgrowth.versions.loaders;

import dev.pretti.prtgrowth.providers.IGrowthManager;
import dev.pretti.prtgrowth.utils.SystemUtils;
import dev.pretti.prtgrowth.utils.VersionsProviderUtils;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.Nullable;

public class PlantsProviders
{
  /**
   * Método de carregamento
   */
  public IGrowthManager load()
  {
    return getManager();
  }

  /**
   * Retornos
   */
  @Nullable
  private IGrowthManager getManager()
  {
    int version = SystemUtils.getServerVersionInt();
    if(version == 108)
      {
        return VersionsProviderUtils.getGrowthManager("v1_8");
      }
    else if(version >= 109 && version < 113)
      {
        return VersionsProviderUtils.getGrowthManager("v1_9");
      }
    else if(version >= 113)
      {
        return VersionsProviderUtils.getGrowthManager("v1_13");
      }
    return null;
  }
}
