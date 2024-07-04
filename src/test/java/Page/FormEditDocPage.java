package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class FormEditDocPage {

    // Шапка формы редактирования документа без номера и даты.
    @Getter
    public SelenideElement titleFormEdit = $x("//span[contains(text(), 'Редактирование атрибутов')]");

    // Поле Номер.
    @Getter
    public SelenideElement number = $x("//label[text() = 'Номер:']");

    // Атрибуты в форме редактирования. Номер, дата создания, инициатор и тд.
    public SelenideElement getAtributeFormEdit(String atributeFormEdit){
        return $x("//label[text() = '" + atributeFormEdit + "']");
    }

    // Вид документа на форме редактирования.
    public SelenideElement getCategory(String docType){
        return $x("//div[contains(@id, 'document-kind-assoc-cntrl-edt')]//child::span[text() = '" + docType + "']");
    }
}
