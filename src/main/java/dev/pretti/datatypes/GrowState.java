package dev.pretti.datatypes;

import org.bukkit.Material;

public class GrowState
{
  private Material _material;
  private byte     _ripe;
  private boolean  _useSide;

  public GrowState(Material material, byte ripe)
  {
    _material = material;
    _ripe     = ripe;
    _useSide  = false;
  }

  public GrowState(Material material, byte ripe, boolean useSide)
  {
    _material = material;
    _ripe     = ripe;
    _useSide  = useSide;
  }

  /**
   * Definições e retornos
   */
  public Material getMaterial()
  {
    return _material;
  }

  public void setMaterial(Material material)
  {
    this._material = material;
  }

  public byte getRipe()
  {
    return _ripe;
  }

  public void setRipe(byte ripe)
  {
    this._ripe = ripe;
  }

  public boolean isUseSide()
  {
    return _useSide;
  }

  public void setUseSide(boolean useSide)
  {
    this._useSide = useSide;
  }
}
