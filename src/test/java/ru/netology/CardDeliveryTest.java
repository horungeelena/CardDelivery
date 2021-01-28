package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

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
        $("[data-test-id=date] input").setValue("11.02.2021");
        $("[data-test-id=name] input").setValue("Анна Петрова");
        $("[data-test-id=phone] input").setValue("+79111234567");
        $("[data-test-id=agreement]").click();
        $(byText("Забронировать")).click();
        $(withText("Успешно")).waitUntil(Condition.visible, 15000);
        $(withText("Встреча успешно забронирована на 29.01.2021"));
    }
}

