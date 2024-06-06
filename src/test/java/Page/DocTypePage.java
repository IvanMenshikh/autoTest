package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class DocTypePage {

    // Вид документа.
    @Getter
    public final SelenideElement docTypeKs = $x("//button[contains(@id, 'document-kind-assoc-cntrl-tree')]");

    // Кнопка "ОК" в модалке "Вид документа".
    @Getter
    public final SelenideElement btnOk = $x("//button[contains(@id, 'document-kind-assoc-cntrl-ok')]");

    // Вид документа -> Каталог, выбрать вид из "Прочие", "ЛНД", и тд...
    public SelenideElement getTypeKs_SelectType(String typeKs) {
        return $x("//span[text()='" + typeKs + "']");
    }

    // Вид документа -> Каталог -> Выбрать элемент справочника.
    public SelenideElement getTypeKs_SelectTypeElement(String elTypeKs) {
        return $x("//span[text()='" + elTypeKs + "']//ancestor::tr//child::span[contains(@class, 'addIcon')]");
    }

}
