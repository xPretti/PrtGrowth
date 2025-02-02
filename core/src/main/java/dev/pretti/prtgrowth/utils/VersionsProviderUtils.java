package dev.pretti.prtgrowth.utils;

import dev.pretti.prtgrowth.PrtGrowth;
import dev.pretti.prtgrowth.providers.IGrowthManager;
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
  public static IGrowthManager getGrowthManager(String version)
  {
    try
      {
        return (IGrowthManager) Class.forName(getVersionsPackage(version) + ".GrowthManager").getDeclaredConstructor().newInstance();
      } catch(ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e)
      {
        Bukkit.getLogger().severe("§cInvalid GrowthManager provider in version " + version + ": " + e.getMessage());
        return null;
      }
  }
}
