package Helper;

import Page.AttachmenPage;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;

public class AttachmenHelper {

    AttachmenPage attachmenPage = new AttachmenPage();

    @Step("Операция по загрузке вложения в категорию для рассмотрения на форме создания документа")
    public void downloadAttachmen() {
        attachmenPage.getDoc_FieldDocForConsiderations().click();
        attachmenPage.getAttachmen_BtnSelectFiles().uploadFile(new File("src/test/java/Attachmens/TestAttachmens.docx"));
        attachmenPage.getAttachmen_BtnPrint().shouldBe(visible);
        attachmenPage.getAttachmen_content().shouldBe(visible);
        attachmenPage.getAttachmen_ErrorMessage().shouldNotBe(visible);
    }
}
