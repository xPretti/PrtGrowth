package dev.pretti.prtgrowth.configs.loaders.interfaces;


import dev.pretti.prtgrowth.configs.interfaces.IConfig;

public interface IConfigLoader
{
  /**
   * Método de carregamento
   */
  boolean load(IConfig outputConfig);
}
