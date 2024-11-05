import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAppianSteps {

    WebDriver driver;

    @Given("I setup with {string} browser")
    public void iSetupWithBrowser(String browser) {
        if (browser.equalsIgnoreCase("CHROME")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\DaisyLoraineIsip\\Documents\\AppianProject\\driver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

    @When("I set Appian URL to {string}")
    public void iSetAppianURL(String url) {
        driver.get(url);
    }

    @And("I set Appian version to {string}")
    public void iSetAppianVersion(String version) {
        // This step may be informational; no WebDriver action is required
        System.out.println("Appian version set to " + version);
    }

    @And("I set Appian locale to {string}")
    public void iSetAppianLocale(String locale) {
        // This step may be informational; no WebDriver action is required
        System.out.println("Appian locale set to " + locale);
    }

    @And("I login with username {string}")
    public void iLoginWithUsername(String username) {
        WebElement usernameField = driver.findElement(By.id("usernameFieldId"));
        WebElement passwordField = driver.findElement(By.id("passwordFieldId"));
        WebElement loginButton = driver.findElement(By.id("loginButtonId"));

        usernameField.sendKeys(username);
        passwordField.sendKeys("password");  // Replace with your password
        loginButton.click();
    }

    @Then("I navigate to site {string}")
    public void iNavigateToSite(String siteName) {
        driver.findElement(By.xpath("//a[contains(text(), '" + siteName + "')]")).click();
    }

    @And("I click on button {string}")
    public void iClickOnButton(String buttonName) {
        driver.findElement(By.xpath("//button[contains(text(), '" + buttonName + "')]")).click();
    }

    @And("I populate field {string} with {string}")
    public void iPopulateFieldWith(String fieldName, String value) {
        WebElement field = driver.findElement(By.xpath("//input[@placeholder='" + fieldName + "']"));
        field.sendKeys(value);
    }

    @And("I populate field type {string} named {string} with {string}")
    public void iPopulateFieldTypeNamedWith(String fieldType, String fieldName, String filePath) {
        if (fieldType.equals("FILE_UPLOAD")) {
            WebElement uploadField = driver.findElement(By.xpath("//input[@name='" + fieldName + "']"));
            uploadField.sendKeys(filePath);
        }
    }

    @And("I wait for {string} seconds")
    public void iWaitForSeconds(String seconds) throws InterruptedException {
        Thread.sleep(Integer.parseInt(seconds) * 1000);
    }

    @And("I tear down")
    public void iTearDown() {
        driver.quit();
    }
}
