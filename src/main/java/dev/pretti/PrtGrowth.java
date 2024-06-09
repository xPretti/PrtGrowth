package dev.pretti;

import dev.pretti.listeners.GrowListener;
import dev.pretti.utils.LogUtils;
import org.bukkit.plugin.java.JavaPlugin;

public class PrtGrowth extends JavaPlugin
{
  private boolean _isInitialized;

  /**
   * Implementações
   */
  @Override
  public void onEnable()
  {
    registerEvents();

    loader();
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
  protected void loader()
  {
    String initMessage = _isInitialized ? "Re-Initializing..." : "Initializing...";
    LogUtils.log("");
    LogUtils.logNormal(initMessage);

    LogUtils.logNormal("");
    LogUtils.logNormal("Everything initialized correctly.");
    LogUtils.log("");
    _isInitialized = true;
  }

  /**
   * Métodos de registros de eventos
   */
  protected boolean registerEvents()
  {
    getServer().getPluginManager().registerEvents(new GrowListener(), this);
    return (true);
  }
}
