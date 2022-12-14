package com.wegotrip.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.wegotrip.config.WebDriverProvider;
import com.wegotrip.helpers.AllureAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void setUp() {
        WebDriverProvider.configure();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addedAttachments() {
        AllureAttachments.screenshotAs("Last screenshot");
        AllureAttachments.addVideo();
    }
}