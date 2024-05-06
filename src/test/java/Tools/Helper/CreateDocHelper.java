package Tools.Helper;

import Page.CreationFormPage;
import Page.MainPage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class CreateDocHelper {

    // Метод для выбора типа документа по имени.
    public static SelenideElement typeDoc(String type) {
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
    public static void createDoc(String type){
        MainPage.getButtonCreate().click();
        typeDoc(type).click();
    }

    // Создаем документ, вид "Карточка согласования".
    public static void createApprovalCard(){
        $x("//legend[text() = 'Документы для информации']").shouldBe(visible);
        CreationFormPage.getDocumentType().click();
        AtributeDocHelper.docType_catalog("Прочие", "Акт");
        CreationFormPage.getButtonOkDocType().click();
        CreationFormPage.getTitleApprovalCard().setValue("Тестовый документ");
        AtributeDocHelper.docCategory("Открытый");
        sleep(2000);
    }
}
