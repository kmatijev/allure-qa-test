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
public class CartTest{
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
    public void cartTest1() throws InterruptedException {
        driver.manage().window().maximize();

        WebDriverWait myWaitVar = new WebDriverWait(driver,20);

        // LOGIN TO ACCESS CARTS

        WebElement userText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("user-name")));
        userText.sendKeys("standard_user");

        WebElement passText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("password")));
        passText.sendKeys("secret_sauce");

        WebElement loginButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("login-button")));
        loginButton.click();

        // ADD STUFF TO CART

        WebElement cartLight = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("add-to-cart-sauce-labs-bike-light")));
        cartLight.click();

        WebElement cartBackpack = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("add-to-cart-sauce-labs-backpack")));
        cartBackpack.click();

        WebElement cartButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_container")));
        cartButton.click();

        WebElement checkoutButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("checkout")));
        checkoutButton.click();

        // CHECKOUT - empty data form

        WebElement continueButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("continue")));
        continueButton.click();

        WebElement errorMsg = myWaitVar.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[4]/h3")));

        Assert.assertEquals(errorMsg.getText(), "Error: First Name is required");

    }

    @Test
    public void cartTest2() throws InterruptedException {
        driver.manage().window().maximize();

        WebDriverWait myWaitVar = new WebDriverWait(driver,20);

        // LOGIN TO ACCESS CARTS

        WebElement userText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("user-name")));
        userText.sendKeys("standard_user");

        WebElement passText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("password")));
        passText.sendKeys("secret_sauce");

        WebElement loginButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("login-button")));
        loginButton.click();

        // ADD STUFF TO CART

        WebElement cartLight = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("add-to-cart-sauce-labs-bike-light")));
        cartLight.click();

        WebElement cartBackpack = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("add-to-cart-sauce-labs-backpack")));
        cartBackpack.click();

        WebElement cartButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_container")));
        cartButton.click();

        WebElement checkoutButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("checkout")));
        checkoutButton.click();

        // CHECKOUT - first and last name only

        WebElement firstNameText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("firstName")));
        firstNameText.sendKeys("first");

        WebElement lastNameText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("lastName")));
        lastNameText.sendKeys("last");

        WebElement continueButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("continue")));
        continueButton.click();

        WebElement errorMsg = myWaitVar.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[4]/h3")));

        Assert.assertEquals(errorMsg.getText(), "Error: Postal Code is required");

    }

    @Test
    public void cartTest3() throws InterruptedException {
        driver.manage().window().maximize();

        WebDriverWait myWaitVar = new WebDriverWait(driver,20);

        // LOGIN TO ACCESS CARTS

        WebElement userText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("user-name")));
        userText.sendKeys("standard_user");

        WebElement passText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("password")));
        passText.sendKeys("secret_sauce");

        WebElement loginButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("login-button")));
        loginButton.click();

        // ADD STUFF TO CART

        WebElement cartLight = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("add-to-cart-sauce-labs-bike-light")));
        cartLight.click();

        WebElement cartBackpack = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("add-to-cart-sauce-labs-backpack")));
        cartBackpack.click();

        WebElement cartButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_container")));
        cartButton.click();

        WebElement checkoutButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("checkout")));
        checkoutButton.click();

        // CHECKOUT - first name and zip code only

        WebElement firstNameText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("firstName")));
        firstNameText.sendKeys("first");

        WebElement zipCodeText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("postalCode")));
        zipCodeText.sendKeys("zipcode");

        WebElement continueButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("continue")));
        continueButton.click();

        WebElement errorMsg = myWaitVar.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[4]/h3")));

        Assert.assertEquals(errorMsg.getText(), "Error: Last Name is required");

    }

    @Test
    public void cartTest4() throws InterruptedException {
        driver.manage().window().maximize();

        WebDriverWait myWaitVar = new WebDriverWait(driver,20);

        // LOGIN TO ACCESS CARTS

        WebElement userText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("user-name")));
        userText.sendKeys("standard_user");

        WebElement passText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("password")));
        passText.sendKeys("secret_sauce");

        WebElement loginButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("login-button")));
        loginButton.click();

        // ADD STUFF TO CART

        WebElement cartLight = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("add-to-cart-sauce-labs-bike-light")));
        cartLight.click();

        WebElement cartBackpack = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("add-to-cart-sauce-labs-backpack")));
        cartBackpack.click();

        WebElement cartButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_container")));
        cartButton.click();

        WebElement checkoutButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("checkout")));
        checkoutButton.click();

        // CHECKOUT - last name and zip code only

        WebElement lastNameText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("lastName")));
        lastNameText.sendKeys("last");

        WebElement zipCodeText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("postalCode")));
        zipCodeText.sendKeys("zipcode");

        WebElement continueButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("continue")));
        continueButton.click();

        WebElement errorMsg = myWaitVar.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[4]/h3")));

        Assert.assertEquals(errorMsg.getText(), "Error: First Name is required");

    }

    @Test
    public void cartTest5() throws InterruptedException {
        driver.manage().window().maximize();

        WebDriverWait myWaitVar = new WebDriverWait(driver,20);

        // LOGIN TO ACCESS CARTS

        WebElement userText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("user-name")));
        userText.sendKeys("standard_user");

        WebElement passText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("password")));
        passText.sendKeys("secret_sauce");

        WebElement loginButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("login-button")));
        loginButton.click();

        // ADD STUFF TO CART

        WebElement cartLight = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("add-to-cart-sauce-labs-bike-light")));
        cartLight.click();

        WebElement cartBackpack = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("add-to-cart-sauce-labs-backpack")));
        cartBackpack.click();

        WebElement cartButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_container")));
        cartButton.click();

        WebElement checkoutButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("checkout")));
        checkoutButton.click();

        // CHECKOUT

        WebElement firstNameText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("firstName")));
        firstNameText.sendKeys("first");

        WebElement lastNameText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("lastName")));
        lastNameText.sendKeys("last");

        WebElement zipCodeText = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("postalCode")));
        zipCodeText.sendKeys("zipcode");

        WebElement continueButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("continue")));
        continueButton.click();

        WebElement finishButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("finish")));
        finishButton.click();

        WebElement backButton = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("back-to-products")));

        String checkoutSuccess = driver.getCurrentUrl();

        Assert.assertEquals(checkoutSuccess, "https://www.saucedemo.com/checkout-complete.html");

    }
    //---------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
//Close browser and end the session
        driver.quit();
    }
}
