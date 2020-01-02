package ee.taltech.team7.calculator.uiTests.stackOverFlow;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StackOverFlowUITest {
    private WebDriver driver;

    @BeforeClass
    public void init_driver() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("https://stackoverflow.com/");
        remove_consent_banner();
    }

    public void remove_consent_banner() {
        driver.findElement(new By.ByCssSelector("#js-gdpr-consent-banner a.js-notice-close"))
                .click();
    }

    public void go_to_landing() throws InterruptedException {
        driver.findElement(new By.ByCssSelector("a.-logo"))
                .click();
        Thread.sleep(500);
    }

    public void visit_qa() throws InterruptedException {
        go_to_landing();
        //scroll down to start loading
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,700)");
        // wait some time (300ms minimum) to make sure script is loaded
        Thread.sleep(1000);

        driver.findElement(new By.ByPartialLinkText("Browse questions"))
                .click();
        System.out.println(driver.getTitle());

    }

    public void view_bounty_qa() throws InterruptedException{
        visit_qa();
        Thread.sleep(500);
        driver
                .findElement(new By.ByPartialLinkText("Bountied"))
                .click();
    }

    @Test
    public void view_bountied_ques() throws InterruptedException {
        view_bounty_qa();
        driver
                .findElement(new By.ByCssSelector("a.question-hyperlink"))
                .click();
    }


    public void ask_some_question() throws InterruptedException {
        go_to_landing();
        driver.findElement(new By.ByName("q"))
                .sendKeys("Test" + Keys.RETURN);

    }

    public void drop_down_menu() throws InterruptedException {
        ask_some_question();
        driver.findElement(new By.ByPartialLinkText("More"))
                .click();
        Thread.sleep(500);
    }

    public void click_on_votes() throws InterruptedException {
        drop_down_menu();
        driver.findElement(new By.ByPartialLinkText("Votes"))
                .click();
        Thread.sleep(1500);
    }

    @Test
    public void click_on_most_voted_ques() throws InterruptedException {
        click_on_votes();
        driver.findElement(new By.ByPartialLinkText("A: Why is processing a sorted array faster than processing an unsorted array?"))
                .click();
        Thread.sleep(2000);
    }

    public void go_to_business_section() throws InterruptedException{
        go_to_landing();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1600)");
        // wait some time to make sure script is loaded
        Thread.sleep(1000);
    }

    public void go_to_talent_solution() throws InterruptedException{
        go_to_business_section();
        driver.findElement(new By.ByPartialLinkText("Talent solutions"))
                .click();
        Thread.sleep(500);
    }

    @Test
    public void go_back_to_landing_from_talent() throws InterruptedException {
        go_to_talent_solution();
        driver.findElement(new By.ByCssSelector("a.grid--cell"))
                .click();
        Thread.sleep(500);
    }


    @AfterClass
    public void close_driver() {
        if (driver != null) {
            driver.quit();
        }
    }


}
