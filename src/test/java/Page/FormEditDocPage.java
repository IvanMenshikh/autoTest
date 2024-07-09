package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class FormEditDocPage {

    // Шапка формы редактирования документа без номера и даты.
    @Getter
    public final SelenideElement titleFormEdit = $x("//span[contains(text(), 'Редактирование атрибутов')]");

    // Поле Номер.
    @Getter
    public final SelenideElement number = $x("//label[text() = 'Номер:']");

    // Атрибуты в форме редактирования. Номер, дата создания, инициатор и тд.
    public SelenideElement getAtributeFormEdit(String atributeFormEdit){
        return $x("//label[text() = '" + atributeFormEdit + "']");
    }
}
