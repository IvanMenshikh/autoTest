package Tools.Helper;

import Page.CreationFormPage;
import Page.MainPage;
import Tools.Asserts;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

public class CreateDocHelper {

    AtributeDocHelper atributeDocHelper = new AtributeDocHelper();
    CreationFormPage creationFormPage = new CreationFormPage();
    MainPage mainPage = new MainPage();

    // Создаем документ по выбранному типу.
    public void createDoc(String type){
        mainPage.getButtonCreate().click();
        mainPage.getDoc_Type(type).click();
    }

    // Создаем документ, вид "Карточка согласования".
    public void createApprovalCard(){
        creationFormPage.getDoc_FieldDocForInformation().shouldBe(visible);
        Asserts.checkDocTitle("Карточка согласования", "Карточка согласования");
        creationFormPage.getDoc_TypeApprovalCard().click();
        atributeDocHelper.docType_catalog("Прочие", "Акт");
        creationFormPage.getDoc_ButtonOkDocType().click();
        creationFormPage.getDoc_FieldTitleApprovalCard().setValue("Тестовый документ");
        atributeDocHelper.docCategory("Открытый");
        creationFormPage.getDoc_FieldDocForConsiderations().click();
        creationFormPage.getAttachmen_ButtonSelectFiles().uploadFile(new File("src/test/java/Attachmens/TestAttachmens.docx"));
        creationFormPage.getAttachmen_ButtonPrint().shouldBe(visible);
        creationFormPage.getAttachmen_content().shouldBe(visible);
        atributeDocHelper.createApprovalRoute("Индивидуальный маршрут", "Согласование КС");


        sleep(5000);
    }

    // Создаем документ, вид "Поручение".
    public void createErrand(){

        creationFormPage.getDoc_FieldDocForInformation().shouldBe(visible);
    }
}
