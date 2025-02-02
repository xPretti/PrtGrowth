package dev.pretti.prtgrowth;

import dev.pretti.prtgrowth.commands.GrowthCommand;
import dev.pretti.prtgrowth.configs.ConfigManager;
import dev.pretti.prtgrowth.listeners.GrowListener;
import dev.pretti.prtgrowth.utils.LogUtils;
import dev.pretti.prtgrowth.versions.VersionsManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PrtGrowth extends JavaPlugin
{
  private static PrtGrowth          instance;
  private final  ConfigManager      configManager      = new ConfigManager(getDataFolder().getPath());
  private final  VersionsManager    versionsManager    = new VersionsManager();

  private boolean isInitialized;

  /**
   * Implementações
   */
  @Override
  public void onLoad()
  {
    instance = this;
  }

  @Override
  public void onEnable()
  {
    registerEvents();
    registerCommands();

    load();
  }

  @Override
  public void onDisable()
  {
    LogUtils.log("");
    LogUtils.logNormal("Finishing...");
    LogUtils.log("");
  }

  /**
   * Inicializadores
   */
  public boolean reload()
  {
    return load();
  }

  protected boolean load()
  {
    String initMessage = isInitialized ? "Re-Initializing..." : "Initializing...";
    LogUtils.log("");
    LogUtils.logNormal(initMessage);

    int     errors  = configManager.load() ? 0 : 1;
    boolean success = errors == 0;

    if(errors == 0)
      {
        LogUtils.logNormal("");
        LogUtils.logNormal("Everything initialized correctly.");
      }
    else
      {
        LogUtils.logNormal("");
        LogUtils.logError("&4Something went wrong during the initialization process.");
      }
    LogUtils.log("");

    isInitialized = true;

    return success;
  }

  /**
   * Métodos de registros de eventos
   */
  protected void registerEvents()
  {
    getServer().getPluginManager().registerEvents(new GrowListener(this), this);
  }

  /**
   * Métodos de registros de comandos
   */
  protected void registerCommands()
  {
    getCommand("PrtGrowth").setExecutor(new GrowthCommand(this));
  }

  /**
   * Métodos de retornos
   */
  public static PrtGrowth getInstance()
  {
    return instance;
  }

  public ConfigManager getConfigManager()
  {
    return configManager;
  }

  public VersionsManager getVersionsManager()
  {
    return versionsManager;
  }
}
