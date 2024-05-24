package Helper;

import Page.CreationFormPage;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;

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
        getDoc_BtnOkCategory().click();
    }

    // Загружаем вложение для рассмотрения. Дополнительно проверяем что вложение появилось.
    public void downloadAttachmen() {
        getDoc_FieldDocForConsiderations().click();
        getAttachmen_BtnSelectFiles().uploadFile(new File("src/test/java/Attachmens/TestAttachmens.docx"));
        getAttachmen_BtnPrint().shouldBe(visible);
        getAttachmen_content().shouldBe(visible);
    }
}
