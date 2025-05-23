package dev.pretti.prtgrowth.utils;

import java.util.List;
import java.util.stream.Collectors;

public class ReplaceUtils
{
  public static String toColorMessage(String text)
  {
    if(text != null)
      {
        return (text.replace("&", "§"));
      }
    return null;
  }

  public static List<String> toColorMessage(List<String> texts)
  {
    if(texts != null && !texts.isEmpty())
      {
        return texts.stream().map(ReplaceUtils::toColorMessage).collect(Collectors.toList());
      }
    return texts;
  }

  public static String toOriginalMessage(String text)
  {
    if(text != null)
      {
        return (text.replace("§", "&"));
      }
    return null;
  }

  public static List<String> toOriginalMessage(List<String> texts)
  {
    if(texts != null && !texts.isEmpty())
      {
        return texts.stream().map(ReplaceUtils::toOriginalMessage).collect(Collectors.toList());
      }
    return texts;
  }
}
