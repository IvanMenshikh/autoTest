package Helper;

import Page.CreationFormPage;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;

public class AtributeDocHelper {

    CreationFormPage creationFormPage = new CreationFormPage();

    @Step("Операция выбора в КС вида документа.")
    public void docType_catalog(String typeApprovalCard, String elTypeApprovalCard){
        creationFormPage.getTypeApprovalCard_SelectType(typeApprovalCard).click();
        creationFormPage.getTypeApprovalCard_SelectCatalogElement(elTypeApprovalCard).click();
    }

    @Step("Операция выбора категории документа.")
    public void docCategory(String category){
        creationFormPage.getDoc_CategoryDoc().click();
        creationFormPage.getCategoryDoc_SelectCategory(category).click();
        creationFormPage.getDoc_BtnOkCategory().click();
    }

    @Step("Операция по загрузке вложения в категорию для рассмотрения на форме создания документа")
    public void downloadAttachmen() {
        creationFormPage.getDoc_FieldDocForConsiderations().click();
        creationFormPage.getAttachmen_BtnSelectFiles().uploadFile(new File("src/test/java/Attachmens/TestAttachmens.docx"));
        creationFormPage.getAttachmen_BtnPrint().shouldBe(visible);
        //creationFormPage.getAttachmen_content().shouldBe(visible);
        creationFormPage.getAttachmen_ErrorMessage().shouldNotBe(visible);
    }

    @Step("Операция 'Сохранить проект'")
    public void createProjectDoc(){
        creationFormPage.getDoc_BtnSaveProject().click();
    }
}
