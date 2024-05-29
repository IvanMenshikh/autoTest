package Helper;

import Page.BlackBarPage;
import Page.MainPage;
import io.qameta.allure.Step;


public class BlackBarHelper {

    BlackBarPage blackBarPage = new BlackBarPage();
    MainPage mainPage = new MainPage();

    @Step("Операция по переходу на основную страницу АРМ СЭД.")
    public void clickOnKsed(){
        blackBarPage.getBtnKsed().click();
    }

    @Step("Деавторизация под текущим пользователем.")
    public boolean logOut(){
        blackBarPage.getUserMenu().click();
        blackBarPage.getBtnExit().click();
        return true;
    }

}
