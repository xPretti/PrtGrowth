package dev.pretti.prtgrowth.utils;

import dev.pretti.prtgrowth.datatypes.GrowState;
import dev.pretti.prtgrowth.enums.EnumGrowSideType;
import dev.pretti.prtgrowth.storage.GrowMaterialStorage;
import org.bukkit.Material;

public class GrowUtils
{
  /**
   * Métodos de retornos do estado
   */
  public static GrowState getState(Material material)
  {
    return GrowMaterialStorage.getGrowStates().get(material);
  }

  public static byte getStateByte(Material material)
  {
    GrowState state = GrowMaterialStorage.getGrowStates().get(material);
    if(state != null)
      {
        return state.getRipe();
      }
    return 0;
  }

  public static byte getStateByte(Material material, EnumGrowSideType side)
  {
    GrowState state = GrowMaterialStorage.getGrowStates().get(material);
    if(state != null)
      {
        if(state.isUseSide())
          {
            int ripeInt   = (int) state.getRipe();
            int firtValue = EnumGrowSideType.getTotal() * ripeInt;
            return (byte) (firtValue + side.ordinal());
          }
        return state.getRipe();
      }
    return 0;
  }
}
