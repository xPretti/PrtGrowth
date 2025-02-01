package dev.pretti.prtgrowth.configs.loaders;

import dev.pretti.prtgrowth.configs.interfaces.IConfig;
import dev.pretti.prtgrowth.configs.interfaces.IPlantsConfig;
import dev.pretti.prtgrowth.configs.loaders.interfaces.IConfigLoader;
import dev.pretti.prtgrowth.configs.setups.DefaultConfigSetup;
import dev.pretti.prtgrowth.enums.EnumAccessType;
import dev.pretti.prtgrowth.utils.FileConfigurationUtils;
import dev.pretti.prtgrowth.utils.LogUtils;
import org.bukkit.Material;

import java.util.List;

public class PlantsLoader implements IConfigLoader
{
  private final DefaultConfigSetup config;

  /**
   * Construtor da classe
   */
  public PlantsLoader(DefaultConfigSetup config)
  {
    this.config = config;
  }

  /**
   * Método de carregamento
   * - Retorna a estrutura contendo as mensagens.
   */
  @Override
  public boolean load(IConfig outputConfig)
  {
    if(outputConfig != null)
      {
        if(outputConfig instanceof IPlantsConfig)
          {
            boolean isSucess = true;

            IPlantsConfig output = (IPlantsConfig) outputConfig;

            output.getPlants().clear();
            output.setAccess(EnumAccessType.BLACKLIST);

            String         acessText  = FileConfigurationUtils.getString(config.getConfig(), config.getDefaultConfig(), "plants.method");
            EnumAccessType accessType = EnumAccessType.getFromString(acessText);
            if(accessType == null)
              {
                LogUtils.logError("Invalid access method: &e" + acessText);
                isSucess = false;
              }
            else
              {
                output.setAccess(accessType);
              }

            List<String> plants = FileConfigurationUtils.getStringList(config.getConfig(), config.getDefaultConfig(), "plants.values");
            if(plants != null && !plants.isEmpty())
              {
                for(String plant : plants)
                  {
                    Material plantMat = Material.getMaterial(plant);
                    if(plantMat == null)
                      {
                        LogUtils.logError("Invalid material: &e" + plant);
                        isSucess = false;
                        continue;
                      }
                    output.getPlants().add(plantMat);
                  }
                return isSucess;
              }
            return true;
          }
      }
    return false;
  }
}
