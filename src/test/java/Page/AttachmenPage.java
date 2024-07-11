package Page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class AttachmenPage {

    // Кнопка "Выберите файлы". Появляется при добавлении вложений. //button[text() = 'Выберите файлы']
    @Getter
    public final SelenideElement btnSelectFiles = $x("//input[@name = 'files[]']");

    // Кнопка "Печать". Появляется после загрузки вложения.
    @Getter
    public final SelenideElement btnPrint = $x("//button[@title = 'Печать']");

    // Контент вложения. Появится после загрузки вложения (текст в предпросмотре).
    @Getter
    public final SelenideElement content = $x("//div[text() = '000000000000000000000000000000000']");

    // Ошибка. Не удалось просмотреть вложение.
    @Getter
    public final SelenideElement errorMessage = $x("//span[text() = 'Не удалось предварительно просмотреть данный документ']");

    // Поле документы "Для рассмотрения". Использую для загрузки вложения.
    @Getter
    public final SelenideElement fieldDocForConsiderations = $x("//img[contains(@id, 'attachments-temp-assoc-uploader-button-category_id-0')]");

}
