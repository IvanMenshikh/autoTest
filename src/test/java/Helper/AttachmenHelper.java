package Helper;

import Page.AttachmenPage;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;

public class AttachmenHelper {

    AttachmenPage attachmenPage = new AttachmenPage();

    @Step("Операция по загрузке вложения в категорию для рассмотрения на форме создания документа")
    public void downloadAttachmen() {
        attachmenPage.getFieldDocForConsiderations().click();
        attachmenPage.getBtnSelectFiles().uploadFile(new File("src/test/java/Attachmens/TestAttachmens.docx"));
        attachmenPage.getBtnPrint().shouldBe(visible);
        attachmenPage.getContent().shouldBe(visible);
        attachmenPage.getErrorMessage().shouldNotBe(visible);
    }
}
