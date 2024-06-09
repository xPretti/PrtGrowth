package dev.pretti.storage;

import dev.pretti.datatypes.GrowState;
import org.bukkit.Material;

import java.util.EnumMap;

public class GrowMaterialStorage
{
  private static EnumMap<Material, GrowState> _growStates = new EnumMap<>(Material.class);

  /**
   * Inicializador
   */
  static
    {
      Material material;
      _growStates.put((material = Material.CARROT), new GrowState(material, (byte) 7));
      _growStates.put((material = Material.POTATO), new GrowState(material, (byte) 7));
      _growStates.put((material = Material.CROPS), new GrowState(material, (byte) 7));
      _growStates.put((material = Material.COCOA), new GrowState(material, (byte) 2, true));
      _growStates.put((material = Material.PUMPKIN_STEM), new GrowState(material, (byte) 7));
      _growStates.put((material = Material.MELON_STEM), new GrowState(material, (byte) 7));
      _growStates.put((material = Material.NETHER_WARTS), new GrowState(material, (byte) 3));
    }

  /**
   * Retornos
   */
  public static EnumMap<Material, GrowState> getGrowStates()
  {
    return _growStates;
  }
}
