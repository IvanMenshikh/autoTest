package Tools;

import Page.CreationFormPage;
import org.testng.Assert;

public class Asserts {

    CreationFormPage creationFormPage = new CreationFormPage();

    // Проверка титула созданного документа в форме создания.
    public void checkDocTitle(String docType, String docType_Expected) {
        String title_Actual = creationFormPage.getDoc_CheckDocTitle(docType).getText();
        String title_Expected = "Создать документ \"" + docType_Expected + "\"";
        if (title_Actual.equals(title_Expected)) {
            System.out.println("Вид документа создан корректно. Актуальный титул - " + title_Actual);
        } else {
            System.out.println("Ошибка: Текст в заголовке не совпадает. Ожидаемый титул - " + title_Expected + ", актуальный титул - " + title_Actual);
            Assert.fail("Текст в заголовке не совпадает.");
        }
    }
}
