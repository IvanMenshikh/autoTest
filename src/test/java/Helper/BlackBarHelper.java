package Helper;

import Page.BlackBarPage;
import io.qameta.allure.Step;


public class BlackBarHelper {

    BlackBarPage blackBarPage = new BlackBarPage();

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
