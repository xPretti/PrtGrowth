package dev.pretti.prtgrowth.utils;

import dev.pretti.prtgrowth.PrtGrowth;
import dev.pretti.prtgrowth.enums.EnumLoggerType;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

public class LogUtils
{
  private static ConsoleCommandSender console;
  private static String               prefix;
  private static String               logFormatNormal;
  private static String               logFormatError;
  private static String               logFormatWarn;
  private static String               logFormatSuccess;

  /**
   * Construtor estático
   */
  static
    {
      console          = Bukkit.getConsoleSender();
      prefix           = PrtGrowth.class.getSimpleName();
      logFormatNormal  = "§7[%s] - §8%s";
      logFormatError   = "§7[%s] §7- §c<Error> §8%s";
      logFormatWarn    = "§7[%s] §7- §e<Warn> §8%s";
      logFormatSuccess = "§7[%s] §7- §a<Success> §8%s";
    }

  /**
   * Métodos de envio de logs
   */
  public static void log(String message)
  {
    console.sendMessage(ReplaceUtils.toColorMessage(message));
  }

  public static void log(EnumLoggerType type, String message)
  {
    switch(type)
      {
        case ERROR:
          logError(message);
          break;
        case SUCCESS:
          logSuccess(message);
          break;
        case WARN:
          logWarn(message);
          break;
        default:
          logNormal(message);
          break;
      }
  }

  public static void logNormal(String message)
  {
    message = String.format(logFormatNormal, prefix, message);
    log(message);
  }

  public static void logWarn(String message)
  {
    message = String.format(logFormatWarn, prefix, message);
    log(message);
  }

  public static void logError(String message)
  {
    message = String.format(logFormatError, prefix, message);
    log(message);
  }

  public static void logSuccess(String message)
  {
    message = String.format(logFormatSuccess, prefix, message);
    log(message);
  }
}
