package dev.pretti.prtgrowth.commands.subcommands;

import dev.pretti.prtgrowth.PrtGrowth;
import dev.pretti.prtgrowth.commands.base.BaseCommand;
import dev.pretti.prtgrowth.configs.types.MessagesConfig;
import dev.pretti.prtgrowth.utils.ReplaceUtils;
import org.bukkit.command.CommandSender;

public class GrowthReload extends BaseCommand
{
  private final PrtGrowth      plugin;
  private final MessagesConfig messagesConfig;

  /**
   * Construtor da classe
   */
  public GrowthReload(String command, String permission, PrtGrowth plugin)
  {
    super(command, permission);
    this.plugin         = plugin;
    this.messagesConfig = plugin.getConfigManager().getMessagesConfig();
  }

  /**
   * Implementação do comando
   */
  @Override
  public boolean run(CommandSender sender, String command, String[] args)
  {
    if(isCommand(command))
      {
        if(hasPermission(sender))
          {
            boolean success = plugin.reload();
            String  message = ReplaceUtils.toColorMessage(success ? messagesConfig.getReloadMessage() : messagesConfig.getReloadErrorMessage());
            sender.sendMessage(message);
          }
        else
          {
            String message = ReplaceUtils.toColorMessage(messagesConfig.getNoPermissionMessage());
            sender.sendMessage(message);
          }
        return true;
      }
    return false;
  }
}
