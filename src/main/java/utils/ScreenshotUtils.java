package utils;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Allure;

public class ScreenshotUtils {

    public static void attachScreenshot(WebDriver driver) {

        byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment(
                "Captura del fallo",
                "image/png",
                new ByteArrayInputStream(screenshot),
                ".png");
    }
}