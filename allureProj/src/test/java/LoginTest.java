import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class LoginTest{
    //-------------------Global Variables-----------------------------------
//Declare a Webdriver variable
    public WebDriver driver;
    //Declare a test URL variable
    public String testURL = "https://www.saucedemo.com";

    //----------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        driver = new ChromeDriver();

        driver.navigate().to(testURL);
    }
    @Test
    public void loginTest1() throws InterruptedException {
        driver.manage().window().maximize();

        WebDriverWait myWaitVar = new WebDriverWait(driver,20);

        WebElement loginButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("login-button")));
        loginButton.click();

        WebElement errorMsg = myWaitVar.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")));

        Assert.assertEquals(errorMsg.getText(),
                "Epic sadface: Username is required");
    }

    @Test
    public void loginTest2() throws InterruptedException {
        driver.manage().window().maximize();

        WebDriverWait myWaitVar = new WebDriverWait(driver,20);

        WebElement loginButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("login-button")));
        loginButton.click();

        WebElement errorMsg = myWaitVar.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")));

        Assert.assertEquals(errorMsg.getText(),
                "Epic sadface: Username is required");
    }

    @Test
    public void loginTest3() throws InterruptedException {
        driver.manage().window().maximize();

        WebDriverWait myWaitVar = new WebDriverWait(driver,20);

        WebElement userText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("user-name")));
        userText.sendKeys("username");

        WebElement loginButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("login-button")));
        loginButton.click();

        WebElement errorMsg = myWaitVar.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")));

        Assert.assertEquals(errorMsg.getText(),
                "Epic sadface: Password is required");
    }

    @Test
    public void loginTest4() throws InterruptedException {
        driver.manage().window().maximize();

        WebDriverWait myWaitVar = new WebDriverWait(driver,20);

        WebElement userText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("user-name")));
        userText.sendKeys("username");

        WebElement passText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("password")));
        passText.sendKeys("password");

        WebElement loginButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("login-button")));
        loginButton.click();

        WebElement errorMsg = myWaitVar.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")));

        Assert.assertEquals(errorMsg.getText(),
                "Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void loginTest5() throws InterruptedException {
        driver.manage().window().maximize();

        WebDriverWait myWaitVar = new WebDriverWait(driver,20);

        WebElement userText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("user-name")));
        userText.sendKeys("standard_user");

        WebElement passText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("password")));
        passText.sendKeys("secret_sauce");

        WebElement loginButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("login-button")));
        loginButton.click();

        WebElement addToCart = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("add-to-cart-sauce-labs-backpack")));

        String loginSuccess = driver.getCurrentUrl();

        Assert.assertEquals(loginSuccess, "https://www.saucedemo.com/inventory.html");

    }
    //---------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
//Close browser and end the session
        driver.quit();
    }
}
