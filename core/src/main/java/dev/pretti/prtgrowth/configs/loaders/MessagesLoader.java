package dev.pretti.prtgrowth.configs.loaders;

import dev.pretti.prtgrowth.configs.interfaces.IConfig;
import dev.pretti.prtgrowth.configs.interfaces.IMessagesConfig;
import dev.pretti.prtgrowth.configs.loaders.interfaces.IConfigLoader;
import dev.pretti.prtgrowth.configs.setups.DefaultConfigSetup;
import dev.pretti.prtgrowth.utils.FileConfigurationUtils;
import dev.pretti.prtgrowth.utils.ReplaceUtils;

public class MessagesLoader implements IConfigLoader
{
  private final DefaultConfigSetup config;

  /**
   * Construtor da classe
   */
  public MessagesLoader(DefaultConfigSetup config)
  {
    this.config = config;
  }

  /**
   * Método de carregamento
   * - Retorna a estrutura contendo as mensagens.
   */
  @Override
  public boolean load(IConfig outputConfig)
  {
    if(outputConfig != null)
      {
        if(outputConfig instanceof IMessagesConfig)
          {
            IMessagesConfig output = (IMessagesConfig) outputConfig;
            output.setNoPermissionMessage(ReplaceUtils.toColorMessage(FileConfigurationUtils.getString(config.getConfig(), config.getDefaultConfig(), "messages.no-permission")));
            output.setReloadMessage(ReplaceUtils.toColorMessage(FileConfigurationUtils.getString(config.getConfig(), config.getDefaultConfig(), "messages.reload")));
            output.setReloadErrorMessage(ReplaceUtils.toColorMessage(FileConfigurationUtils.getString(config.getConfig(), config.getDefaultConfig(), "messages.reload-error")));
            output.setHelpMessages(ReplaceUtils.toColorMessage(FileConfigurationUtils.getStringList(config.getConfig(), config.getDefaultConfig(), "messages.help")));
            return true;
          }
      }
    return false;
  }
}
