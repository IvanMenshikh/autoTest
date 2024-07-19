package Helper;

import Page.CategoryDocPage;
import Page.CreationDocPage;
import io.qameta.allure.Step;

public class CategoryDocHelper {

    CategoryDocPage categoryDocPage = new CategoryDocPage();
    CreationDocPage creationDocPage = new CreationDocPage();

    @Step("Операция выбора категории документа.")
    public void docCategory(String category){
        categoryDocPage.getCategoryDoc().click();
        categoryDocPage.getCategoryDoc_SelectCategory(category).click();
        categoryDocPage.getBtnOkCategory().click();
    }

    @Step("Операция удаления выбранной категории.")
    public void deletedCategory(){
        categoryDocPage.getCategoryDoc().click();
        categoryDocPage.getDeleteSelectedEl().click();
        categoryDocPage.getBtnOkCategory().click();
    }
}
