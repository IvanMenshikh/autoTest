package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;
@Getter
public class CreationFormPage {

    // Поле "Заголовок" в форме создания КС.
    @Getter
    public final SelenideElement fieldTitleApprovalCard = $x("//input[@name = 'prop_lecm-document_title']");

    // Поле документы "Для информации". Использую для ожидания прорисовки страницы.
    @Getter
    public final SelenideElement fieldDocForInformation = $x("//legend[text() = 'Документы для информации']");

    // Кнопка "Сохранить проект".
    @Getter
    public final SelenideElement btnSaveProject = $x("//button[text() = 'Сохранить проект']");

    // Титульник "Создать документ " + Тип документа + ". Локатор заголовка для проверки соответствия.
    public SelenideElement getDoc_CheckDocTitle(String docType){
        return $x("//span[text() = 'Создать документ \"" + docType + "\"']");
    }
}