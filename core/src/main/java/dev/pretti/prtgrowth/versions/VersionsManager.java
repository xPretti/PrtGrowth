package dev.pretti.prtgrowth.versions;

import dev.pretti.prtgrowth.providers.IGrowthManager;
import dev.pretti.prtgrowth.versions.loaders.PlantsProviders;
import org.jetbrains.annotations.Nullable;

public class VersionsManager
{
  private final IGrowthManager growthManager;

  /**
  * Contrutor da classe
  */
  public VersionsManager()
  {
    growthManager = new PlantsProviders().load();
  }

  /**
   * Retornos
   */
  @Nullable
  public IGrowthManager getGrowthManager()
  {
    return growthManager;
  }
}
