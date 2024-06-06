package Helper;

import Page.ActionPanelPage;
import io.qameta.allure.Step;

public class ActionPanelHelper {
    ActionPanelPage actionPanelPage = new ActionPanelPage();

    @Step("Операция удаления документа с помощью панели действий.")
    public void deleteDoc(){
        actionPanelPage.getDeleteDocAction().click();
        actionPanelPage.getDeleteDocAction_btnOk().click();
    }
}
