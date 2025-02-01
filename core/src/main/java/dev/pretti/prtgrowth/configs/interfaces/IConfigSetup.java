package dev.pretti.prtgrowth.configs.interfaces;

import org.bukkit.configuration.file.FileConfiguration;

public interface IConfigSetup
{
  FileConfiguration getConfig();
  String getConfigPath();
}
