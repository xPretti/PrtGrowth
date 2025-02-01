package dev.pretti.prtgrowth.enums;

import java.util.HashMap;

public enum EnumAccessType
{
  BLACKLIST,
  WHITELIST;

  private static final EnumAccessType[] VALUES = values();

  private static final HashMap<String, EnumAccessType>  VALUES_NAMES    = new HashMap<>();
  private static final HashMap<Integer, EnumAccessType> VALUES_ORDINALS = new HashMap<>();

  /**
   * Inicialização
   */
  static
    {
      for(EnumAccessType type : VALUES)
        {
          VALUES_NAMES.put(type.name(), type);
          VALUES_ORDINALS.put(type.ordinal(), type);
        }
    }

  /**
   * Métodos de retornos
   */
  public static EnumAccessType getFromString(String text)
  {
    return VALUES_NAMES.get(text);
  }

  public static EnumAccessType getFromInt(int number)
  {
    return VALUES_ORDINALS.get(number);
  }
}
