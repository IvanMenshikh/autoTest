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

    // Создаем документ, вид "Карточка согласования".
    public void createApprovalCard(){
        getDoc_FieldDocForInformation().shouldBe(visible);
        Asserts.checkDocTitle("Карточка согласования", "Карточка согласования");
        getDoc_TypeApprovalCard().click();
        atributeDocHelper.docType_catalog("Прочие", "Акт");
        getDoc_ButtonOkDocType().click();
        getDoc_FieldTitleApprovalCard().setValue("Тестовый документ");
        atributeDocHelper.docCategory("Открытый");
        getDoc_FieldDocForConsiderations().click();
        getAttachmen_ButtonSelectFiles().uploadFile(new File("src/test/java/Attachmens/TestAttachmens.docx"));
        getAttachmen_ButtonPrint().shouldBe(visible);
        getAttachmen_content().shouldBe(visible);
        approvalDocHelper.createApprovalRoute("Индивидуальный маршрут", "Согласование КС");

        sleep(5000);
    }
}
