package Tools;

import Page.CreationFormPage;

import static com.codeborne.selenide.Condition.visible;

public class ConstructorErrand extends CreationFormPage {

    // Создаем документ, вид "Поручение".
    public void createErrand(){

        getDoc_FieldDocForInformation().shouldBe(visible);
        Asserts.checkDocTitle("Поручение", "Поручение");


    }
}
