package Helper;

import Page.DocTypePage;
import io.qameta.allure.Step;

public class DocTypeHelper {

    DocTypePage ksDocTypePage = new DocTypePage();

    @Step("Операция выбора вида документа в КС.")
    public void docType(String typeApprovalCard, String elTypeApprovalCard){
        ksDocTypePage.getDocTypeKs().click();
        ksDocTypePage.getTypeKs_SelectType(typeApprovalCard).click();
        ksDocTypePage.getTypeKs_SelectTypeElement(elTypeApprovalCard).click();
        ksDocTypePage.getBtnOk().click();
    }
}
