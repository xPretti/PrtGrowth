package dev.pretti.enums;

public enum EnumGrowSideType
{
  NORTH,
  EAST,
  SOUTH,
  WEST;

  static final EnumGrowSideType[] _values = values();
  static final int                _total  = _values.length;

  /**
   * Métodos de retornos
   */
  public static int getTotal()
  {
    return _total;
  }

  public static EnumGrowSideType toEnum(byte value)
  {
    if(value > 0)
      {
        return value >= getTotal() ? _values[getTotal() - 1] : _values[value];
      }
    return _values[0];
  }
}
