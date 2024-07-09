package Helper;

import Page.CategoryDocPage;
import Page.CreationDocPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public class CategoryDocHelper {

    CategoryDocPage categoryDocPage = new CategoryDocPage();
    CreationDocPage creationDocPage = new CreationDocPage();

    @Step("Операция выбора категории документа.")
    public void docCategory(String category){
        categoryDocPage.getCategoryDoc().click();
        categoryDocPage.getCategoryDoc_SelectCategory(category).click();
        categoryDocPage.getBtnOkCategory().click();
    }

    @Step("Операция удаления выбранной категории и добавление другой.")
    public void deletedCategoryAndSelectedNew(String category){
        categoryDocPage.getCategoryDoc().click();
        categoryDocPage.getDeleteSelectedEl().click();
        categoryDocPage.getCategoryDoc_SelectCategory(category).click();
        categoryDocPage.getBtnOkCategory().click();
        creationDocPage.getFieldDocCategory("ДВП").shouldBe(visible);
    }
}
