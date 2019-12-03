package main.java.helperinstrument;

import main.java.pages.header.CertainLanguage;
import main.java.pages.header.HeaderFull;

public class ChangeLanguageHelper {

  public HeaderFull changeLanguageForUkrainina(){
      return new CertainLanguage().openListOfLanguages().chooseUkrainianInDropDown();
  }

  public String checkTranslatingOfTheElementToUkrainian(){
     return new CertainLanguage().openListOfLanguages().chooseUkrainianInDropDown().getLogCont().getContactUS().getText();
  }
}
