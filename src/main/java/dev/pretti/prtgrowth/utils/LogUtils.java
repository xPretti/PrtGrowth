package dev.pretti.prtgrowth.utils;

import dev.pretti.prtgrowth.PrtGrowth;
import dev.pretti.prtgrowth.enums.EnumLoggerType;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

public class LogUtils
{
  private static ConsoleCommandSender _console;
  private static String               _prefix;
  private static String               _logFormatNormal;
  private static String               _logFormatError;
  private static String               _logFormatWarn;
  private static String               _logFormatSuccess;

  /**
   * Construtor estático
   */
  static
    {
      _console          = Bukkit.getConsoleSender();
      _prefix           = PrtGrowth.class.getSimpleName();
      _logFormatNormal  = "§7[%s] - §8%s";
      _logFormatError   = "§7[%s] §7- §c<Error> §8%s";
      _logFormatWarn    = "§7[%s] §7- §e<Warn> §8%s";
      _logFormatSuccess = "§7[%s] §7- §a<Success> §8%s";
    }

  /**
   * Métodos de envio de logs
   */
  public static void log(String message)
  {
    _console.sendMessage(message);
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
    message = String.format(_logFormatNormal, _prefix, message);
    log(message);
  }

  public static void logWarn(String message)
  {
    message = String.format(_logFormatWarn, _prefix, message);
    log(message);
  }

  public static void logError(String message)
  {
    message = String.format(_logFormatError, _prefix, message);
    log(message);
  }

  public static void logSuccess(String message)
  {
    message = String.format(_logFormatSuccess, _prefix, message);
    log(message);
  }
}
