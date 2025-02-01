package dev.pretti.prtgrowth.utils;

import dev.pretti.prtgrowth.PrtGrowth;
import dev.pretti.prtgrowth.providers.IGrowthPlantLoader;
import org.bukkit.Bukkit;

import java.lang.reflect.InvocationTargetException;

public class VersionsProviderUtils
{
  /**
   * Métodos de retornos de pacotes
   */
  public static String getVersionsPackage()
  {
    String packageName = PrtGrowth.class.getPackage().getName();
    return packageName + ".versions";
  }

  public static String getVersionsPackage(String version)
  {
    return getVersionsPackage() + "." + version;
  }


  /**
   * Método de retornos de classes
   */
  public static IGrowthPlantLoader getGrowthPlantLoader(String version)
  {
    try
      {
        return (IGrowthPlantLoader) Class.forName(getVersionsPackage(version) + ".GrowthPlantLoader").getDeclaredConstructor().newInstance();
      } catch(ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e)
      {
        Bukkit.getLogger().severe("§cInvalid GrowthPlantLoader provider in version " + version + ": " + e.getMessage());
        return null;
      }
  }
}
