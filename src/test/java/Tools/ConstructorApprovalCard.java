package Tools;

import Page.CreationFormPage;
import Helper.ApprovalDocHelper;
import Helper.AtributeDocHelper;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

public class ConstructorApprovalCard extends CreationFormPage{

    AtributeDocHelper atributeDocHelper = new AtributeDocHelper();
    ApprovalDocHelper approvalDocHelper = new ApprovalDocHelper();

    // Создаем документ "Карточка согласования".
    public void createApprovalCard(){

        // Ожидаем появления поля "Документы для информации".
        getDoc_FieldDocForInformation().shouldBe(visible);

        // Проверяем титул созданного документа.
        Asserts.checkDocTitle("Карточка согласования", "Карточка согласования");

        // Выбираем вид документа КС.
        getDoc_TypeApprovalCard().click();
        atributeDocHelper.docType_catalog("Прочие", "Акт");
        getDoc_ButtonOkDocType().click();

        // Заполняем поле "Содержание".
        getDoc_FieldTitleApprovalCard().setValue("Тестовый документ");

        // Выбираем категорию документа.
        atributeDocHelper.docCategory("Открытый");

        // Загружаем вложение для рассмотрения.
        getDoc_FieldDocForConsiderations().click();
        getAttachmen_ButtonSelectFiles().uploadFile(new File("src/test/java/Attachmens/TestAttachmens.docx"));

        // Ожидаем появления кнопки "Печать" и текста внутри вложения.
        getAttachmen_ButtonPrint().shouldBe(visible);
        getAttachmen_content().shouldBe(visible);

        // Создаем маршрут согласования.
        approvalDocHelper.createApprovalRoute("Индивидуальный маршрут", "Согласование КС");

        // Создаем проект документа
        //getDoc_ButtonSaveProject().click();

        sleep(5000);
    }
}
