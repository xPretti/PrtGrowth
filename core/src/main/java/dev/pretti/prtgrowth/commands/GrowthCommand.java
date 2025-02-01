package dev.pretti.prtgrowth.commands;

import dev.pretti.prtgrowth.PrtGrowth;
import dev.pretti.prtgrowth.commands.base.BaseCommands;
import dev.pretti.prtgrowth.commands.subcommands.GrowthReload;
import dev.pretti.prtgrowth.configs.types.MessagesConfig;
import dev.pretti.prtgrowth.constants.PermissionsConstants;
import dev.pretti.prtgrowth.utils.ReplaceUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class GrowthCommand extends BaseCommands implements CommandExecutor, TabCompleter
{
  private final MessagesConfig messagesConfig;

  /**
   * Construtor da classe
   */
  public GrowthCommand(PrtGrowth plugin)
  {
    super("Growth", PermissionsConstants.COMMAND_GROWTH_PERM);
    this.messagesConfig = plugin.getConfigManager().getMessagesConfig();

    // Registros
    register(new GrowthReload("reload", PermissionsConstants.COMMAND_GROWTH_RELOAD_PERM, plugin));
  }

  /**
   * Implementação
   */
  @Override
  public boolean onCommand(CommandSender sender, Command command, String s, String[] strings)
  {
    if(hasPermission(sender))
      {
        if(!run(sender, s, strings))
          {
            messagesConfig.getHelpMessages().forEach(message -> sender.sendMessage(ReplaceUtils.toColorMessage(message)));
          }
      }
    else
      {
        String message = ReplaceUtils.toColorMessage(messagesConfig.getNoPermissionMessage());
        sender.sendMessage(message);
      }
    return true;
  }

  @Override
  public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args)
  {
    if(args.length == 1)
      {
        return getCommandsNames(args[0]);
      }
    else if(args.length > 1)
      {
        return runAutoComplete(sender, args[args.length - 2]);
      }
    return null;
  }
}
