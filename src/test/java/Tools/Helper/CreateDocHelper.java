package Tools.Helper;

import Page.CreationFormPage;
import Page.MainPage;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

public class CreateDocHelper {

    // Создаем документ по выбранному типу.
    public void createDoc(String type){
        MainPage.getButtonCreate().click();
        MainPage.getDoc_Type(type).click();
    }

    AtributeDocHelper atributeDocHelper = new AtributeDocHelper();

    // Создаем документ, вид "Карточка согласования".
    public void createApprovalCard(){
        CreationFormPage.getDoc_FieldDocForInformation().shouldBe(visible);
        CreationFormPage.getDoc_TypeApprovalCard().click();
        atributeDocHelper.docType_catalog("Прочие", "Акт");
        CreationFormPage.getDoc_ButtonOkDocType().click();
        CreationFormPage.getDoc_FieldTitleApprovalCard().setValue("Тестовый документ");
        atributeDocHelper.docCategory("Открытый");
        CreationFormPage.getDoc_FieldDocForConsiderations().click();
        CreationFormPage.getAttachmen_ButtonSelectFiles().uploadFile(new File("src/test/java/Attachmens/TestAttachmens.docx"));
        CreationFormPage.getAttachmen_ButtonPrint().shouldBe(visible);
        CreationFormPage.getAttachmen_content().shouldBe(visible);
        atributeDocHelper.createApprovalRoute("Индивидуальный маршрут", "Согласование КС");


        sleep(5000);
    }

    // Создаем документ, вид "Поручение".
    public void createErrand(){

        CreationFormPage.getDoc_FieldDocForInformation().shouldBe(visible);
    }
}
