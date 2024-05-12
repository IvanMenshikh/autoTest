package Helper;

import Page.CreationFormPage;

public class AtributeDocHelper extends CreationFormPage {

    // Вид документа, выбираем вид и элемент вида. (Вид "Прочие", элемент вида "Акт")
    public void docType_catalog(String typeApprovalCard, String elTypeApprovalCard){
        getTypeApprovalCard_SelectType(typeApprovalCard).click();
        getTypeApprovalCard_SelectCatalogElement(elTypeApprovalCard).click();
    }

    // Категория документа "Открытый", "ДВП", "СКХ".
    public void docCategory(String category){
        getDoc_CategoryDoc().click();
        getCategoryDoc_SelectCategory(category).click();
        getDoc_ButtonOkCategory().click();
    }
}
