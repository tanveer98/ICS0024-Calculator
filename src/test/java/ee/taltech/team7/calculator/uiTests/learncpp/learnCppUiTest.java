package ee.taltech.team7.calculator.uiTests.learncpp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class learnCppUiTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void init_driver() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void open_driver() {
        this.driver.get("https://www.learncpp.com/");
    }

    @Test
    public void can_go_to_home_page() {
        driver.get("https://www.learncpp.com/about");
        WebElement elem = driver.findElement(new By.ByClassName("divclick"));
        elem.click();
        System.out.println(driver.getTitle());

    }


    @Test
    public void can_go_to_another_pages() {
        By something = new By.ByXPath("/html/body/div[2]/div/table/tbody/tr/td[2]/div/div[2]/table[1]/tbody/tr[3]/td[3]/a");
        WebElement elem;

        elem = driver.findElement(something);
        elem.click();
        System.out.println(driver.getTitle());

        elem = driver.findElement(new By.ByXPath("/html/body/div[2]/div/table/tbody/tr/td[2]/div[2]/div[3]/table/tbody/tr[3]/td/a"));
        elem.click();
        System.out.println(driver.getTitle());

        elem = driver.findElement(new By.ByXPath("/html/body/div[2]/div/table/tbody/tr/td[2]/div[2]/div[4]/a[1]"));
        elem.click();
        System.out.println(driver.getTitle());

        elem = driver.findElement(new By.ByCssSelector(".post-9038 .comments-link"));
        elem.click();

    }

    @Test
    public void can_click_on_google_search() {
        WebElement searchBox = driver.findElement(new By.ByName("q"));
        searchBox.sendKeys("Hello World");
        WebElement submit = driver.findElement(new By.ById("sbb"));
        submit.click();
        System.out.println(driver.getTitle());
    }

    @Test
    public void go_to_feedback_page() {
        WebElement elem = driver.findElement(new By.ByXPath("/html/body/div[2]/div/table/tbody/tr/td[1]/div[1]/div/ul[2]/li[1]/a"));
        elem.click();
        System.out.println(driver.getTitle());
    }

    @Test
    public void leave_comment() {
        go_to_feedback_page();
        WebElement textArea = driver.findElement(new By.ById("comment"));
        WebElement author = driver.findElement(new By.ById("author"));
        WebElement email = driver.findElement(new By.ById("email"));

        WebElement submit = driver.findElement(new By.ById("submit"));
        submit.click();
        System.out.println(driver.getTitle());
    }

    @Test
    public void go_back_from_error_page() {
        leave_comment();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement back = driver.findElement(new By.ByTagName("a"));
        back.click();
        System.out.println(driver.getTitle());
    }

    @Test
    public void why_we_cant_have_good_things() {
        go_to_feedback_page();

        WebElement elem = driver.findElement(new By.ByCssSelector(".post-footer .site-news"));
        elem.click();
        elem = driver.findElement(new By.ByCssSelector("#post-579 a"));
        elem.click();
    }

    @AfterClass
    public void close_driver() {
        if (driver != null) {
            driver.quit();
        }
    }

}