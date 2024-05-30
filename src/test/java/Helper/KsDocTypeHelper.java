package Helper;

import Page.KsDocTypePage;
import io.qameta.allure.Step;

public class KsDocTypeHelper {

    KsDocTypePage ksDocTypePage = new KsDocTypePage();

    @Step("Операция выбора вида документа в КС.")
    public void docType(String typeApprovalCard, String elTypeApprovalCard){
        ksDocTypePage.getDocTypeKs().click();
        ksDocTypePage.getTypeKs_SelectType(typeApprovalCard).click();
        ksDocTypePage.getTypeKs_SelectTypeElement(elTypeApprovalCard).click();
        ksDocTypePage.getBtnOk();
    }
}
