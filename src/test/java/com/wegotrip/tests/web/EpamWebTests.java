package com.wegotrip.tests.web;

import com.wegotrip.tests.TestBase;
import com.wegotrip.tests.pages.MainPage;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class EpamWebTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Owner("Shamsutdinov")
    @DisplayName("Main page should has banner")
    @Test
    void bannerTest() {
        mainPage.openMainPage("");
        step("Check that main page has banner", () -> {
            $(".background-video-ui.background-video--narrow").shouldBe(visible);
        });
    }

    @Owner("Shamsutdinov")
    @DisplayName("Clicking on company logo should return to main page")
    @Test
    void returnToMainPageByClickingOnLogo() {
        mainPage.openMainPage("");
        step("Open page \"Services\"", () -> {
            $("li[class='top-navigation__item continuum'] a[class='top-navigation__item-link']").click();
        });
        step("Click on logo", () -> {
            $(".header__logo").click();
        });
        step("Check that open main page", () -> {
            $(".title-slider__slide-row").shouldHave(text("Engineering the Future"));
        });
    }

    @Owner("Shamsutdinov")
    @DisplayName("Contact page check")
    @Test
    void contactPageTest() {
        mainPage.openMainPage("");
        step("Click on button 'CONTACT US'", () -> {
            $(".cta-button__text").click();
        });
        step("Check that open contact page", () -> {
            $(".title-ui.title--center.title--padding-normal").shouldHave(text("\n" +
                    "        Our Offices\n" +
                    "    "));
        });
    }

    @Owner("Shamsutdinov")
    @DisplayName("Checking the site in Russian")
    @Test
    void mainPageInRussianTest() {
        mainPage.openMainPage("");
        step("Click on button 'Global (en)'", () -> {
            $(".location-selector__button").click();
        });

        step("Click on button 'Global (en)'", () -> {
            $(".location-selector__link[href='https://www.epam.com/cis']").click();
        });
        step("Check that open page in Russian", () -> {
            $("h1").shouldHave(text("\n" +
                    "        Присоединяйтесь к глобальной команде профессионалов\n" +
                    "    "));
        });
    }
}

