package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class CategoryDocPage {

    // Категория документа. Кнопка [...] на форме создания.
    @Getter
    public final SelenideElement categoryDoc = $x("//button[contains(@id, 'category') and text() = '...']");

    // Кнопка "ОК" в модалке "Категория документа".
    @Getter
    public final SelenideElement btnOkCategory = $x("//button[contains(@id, 'category') and text() = 'OK']");

    // Категория документа -> выбрать категорию.
    public SelenideElement getCategoryDoc_SelectCategory(String category) {
        return $x("//span[text()='" + category + "']//ancestor::tr//child::span[contains(@class, 'addIcon')]");
    }



}
