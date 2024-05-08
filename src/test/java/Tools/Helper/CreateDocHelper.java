package Tools.Helper;

import Page.CreationFormPage;
import Page.MainPage;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

public class CreateDocHelper {

    // Метод для выбора типа документа по имени.
    public SelenideElement typeDoc(String type) {
        switch (type) {
            case "Карточка согласования":
                return MainPage.getButtonDocTypeApprovalCard();
            case "Поручение":
                return MainPage.getButtonDocTypeErrand();
            default:
                throw new IllegalArgumentException("Неверный тип документа: " + type);
        }
    }

    // Создаем документ по выбранному типу.
    public void createDoc(String type){
        MainPage.getButtonCreate().click();
        typeDoc(type).click();
    }

    AtributeDocHelper atributeDocHelper = new AtributeDocHelper();

    // Создаем документ, вид "Карточка согласования".
    public void createApprovalCard(){

        CreationFormPage.getDoc_FieldDocForInformation().shouldBe(visible);
        CreationFormPage.getDoc_TypeDoc().click();
        atributeDocHelper.docType_catalog("Прочие", "Акт");
        CreationFormPage.getDoc_ButtonOkDocType().click();
        CreationFormPage.getDoc_FieldTitleApprovalCard().setValue("Тестовый документ");
        atributeDocHelper.docCategory("Открытый");
        CreationFormPage.getDoc_FieldDocForConsiderations().click();
        CreationFormPage.getAttachmen_ButtonSelectFiles().uploadFile(new File("src/test/java/Attachmens/TestAttachmens.docx"));
        CreationFormPage.getAttachmen_ButtonPrint().shouldBe(visible);
        atributeDocHelper.createApprovalRoute("Индивидуальный маршрут", "Согласование КС");


        sleep(5000);
    }

    // Создаем документ, вид "Поручение".
    public void createErrand(){

        CreationFormPage.getDoc_FieldDocForInformation().shouldBe(visible);
    }
}
