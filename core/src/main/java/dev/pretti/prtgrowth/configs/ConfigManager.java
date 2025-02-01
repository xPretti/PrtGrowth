package dev.pretti.prtgrowth.configs;

import dev.pretti.prtgrowth.configs.interfaces.IConfig;
import dev.pretti.prtgrowth.configs.interfaces.IConfigManager;
import dev.pretti.prtgrowth.configs.setups.ConfigSetup;
import dev.pretti.prtgrowth.configs.setups.DefaultConfigSetup;
import dev.pretti.prtgrowth.configs.types.MessagesConfig;
import dev.pretti.prtgrowth.configs.types.PlantsConfig;
import dev.pretti.prtgrowth.utils.LogUtils;
import dev.pretti.prtgrowth.utils.ResourceUtils;

public class ConfigManager implements IConfigManager
{
  private final String pluginDataFolder;

  private final String configName   = "config.yml";
  private final String messagesName = "messages.yml";

  private final PlantsConfig   plantsConfig   = new PlantsConfig();
  private final MessagesConfig messagesConfig = new MessagesConfig();


  public ConfigManager(String dataFolder)
  {
    this.pluginDataFolder = dataFolder;
  }

  /**
   * Métodos de carregamentos
   */
  @Override
  public boolean load()
  {
    _createConfigs();
    return _loaderConfigs();
  }

  @Override
  public boolean reload()
  {
    return this.load();
  }

  /**
   * Retornos das configurações
   */
  public PlantsConfig getPlantsConfig()
  {
    return plantsConfig;
  }

  public MessagesConfig getMessagesConfig()
  {
    return messagesConfig;
  }

  /**
   * Métodos de carregamentos privados
   */
  private void _createConfigs()
  {
    ResourceUtils.CreateConfig(configName);
    ResourceUtils.CreateConfig(messagesName);
  }

  private boolean _loaderConfigs()
  {
    LogUtils.logNormal("");

    int errors = 0;

    errors += loadConfig("config..", this.plantsConfig, new DefaultConfigSetup(ResourceUtils.getConfig(configName), ResourceUtils.getResource(configName), configName));
    errors += loadConfig("messages..", this.messagesConfig, new DefaultConfigSetup(ResourceUtils.getConfig(messagesName), ResourceUtils.getResource(messagesName), messagesName));
    return (errors <= 0);
  }

  private int loadConfig(String category, IConfig config, ConfigSetup setup)
  {
    if(category != null)
      {
        LogUtils.logNormal("§8Loading " + category);
      }
    return config.load(setup) ? 0 : 1;
  }

}
