package github;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchJUnit5 {

    @BeforeAll
    static void configure() {
        Configuration.browser = "chrome";
    }

    @Test
    void searchJUnit5Test() {

        // открыть страницу github.com
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        // нажать на линк от первого результата поиска
        $$("ul.repo-list li").first().$("a").click();
        // перейти в раздел Wiki проекта
        $("#wiki-tab").click();
        // убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-body").shouldHave(text("Soft assertions"));
        // открыть страницу SoftAssertions
        $("#wiki-body").$(byText("Soft assertions")).click();
        // проверить, что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
