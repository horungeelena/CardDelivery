package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

class CardDeliveryTest {

    @Test
    void shouldRegisterByDelivery() {
        open("http://localhost:9999");
        SelenideElement form = $("form");
        $("[data-test-id=city] input").setValue("Калининград");
        $("[data-test-id=date] input").setValue("31.01.2021");
        $("[data-test-id=name] input").setValue("Анна Петрова");
        $("[data-test-id=phone] input").setValue("+79111234567");
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).waitUntil(visible, 14000);
        $(byText("Успешно! Встреча успешно забронирована на 29.01.2021")).waitUntil(visible, 5000);
    }
}

