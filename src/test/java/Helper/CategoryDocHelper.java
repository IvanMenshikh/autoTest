package Helper;

import Page.CategoryDocPage;
import io.qameta.allure.Step;

public class CategoryDocHelper {

    CategoryDocPage categoryDocPage = new CategoryDocPage();

    @Step("Операция выбора категории документа.")
    public void docCategory(String category){
        categoryDocPage.getCategoryDoc().click();
        categoryDocPage.getCategoryDoc_SelectCategory(category).click();
        categoryDocPage.getBtnOkCategory().click();
    }


}
