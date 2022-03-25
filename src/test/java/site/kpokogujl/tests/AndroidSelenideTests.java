package site.kpokogujl.tests;

import com.codeborne.selenide.Selenide;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("selenide")
public class AndroidSelenideTests extends TestBase {
    @Test
    void addLanguageOnFirstScreen() {

        step("Кликаю добавить язык", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/addLangContainer")).click();
        });

        step("Кликаю добавить язык в меню языков", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/wiki_language_title")).last().click();
        });

        step("Выбираю Русский", () -> {
            $(AppiumBy.xpath("//android.widget.TextView[@text='Русский']")).click();
        });

        step("Проверяю, что в списке есть Русский", () -> {
            $(AppiumBy.xpath("//android.widget.TextView[@text='Русский']")).shouldHave(attribute("text", "Русский"));
        });

        step("Возвращаюсь назад", () -> {
            $(AppiumBy.className("android.widget.ImageButton")).click();
        });

        step("Проверяю, что в списке есть Русский", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/languagesList"))
                    .$$(AppiumBy.id("org.wikipedia.alpha:id/option_label")).shouldHave(size(2));
        });

    }

    @Test
    void searchTest(){

        step("Закрываю экран настроек", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        });
        step("Кликаю по элементу поиска", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
        });
        step("Ввожу текст в поле поиска", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .setValue("BrowserStack");
        });

        step("Проверяю, что результатов поиска больше 0", () ->
                $$(AppiumBy.className("android.widget.TextView"))
                        .shouldHave(sizeGreaterThan(0)));
    }
}
