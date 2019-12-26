package ee.taltech.team7.calculator.uiTests.learncpp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By heading = By.className("divClick");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
}
