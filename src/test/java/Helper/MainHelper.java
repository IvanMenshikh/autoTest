package Helper;

import Page.MainPage;
import io.qameta.allure.Step;

public class MainHelper {

    MainPage mainPage = new MainPage();

    @Step("Операция по созданию документа.")
    public void createDoc(String doc){
        mainPage.createDoc(doc);
    }
}
