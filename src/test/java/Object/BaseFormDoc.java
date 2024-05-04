package Object;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BaseFormDoc {
    public static SelenideElement documentCategory;// Категория документа.
    public static SelenideElement selectCategory;// Категория документа -> выбрать категорию.
    public static SelenideElement buttonOk;// Кнопка "ОК".

    public static SelenideElement getDocumentCategory(){
        return documentCategory = $x("//button[contains(@id, 'category') and text() = '...']");
    }

    public static SelenideElement getSelectCategory(String type){
        return selectCategory = $x("//span[text()='\"+ type +\"']//ancestor::tr//child::span[contains(@class, 'addIcon')]");
    }

    public static SelenideElement getButtonOk(){
        return buttonOk = $x("//button[contains(@id, 'category') and text() = 'OK']");
    }

    public static void setBaseFormDoc(){
        getDocumentCategory().click();
        getSelectCategory("ДВП").click();
        getButtonOk().click();
    }
}
