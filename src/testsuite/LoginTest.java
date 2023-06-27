package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sun.security.util.Password;

public class LoginTest extends BaseTest

{
    String baseUrl="https://demo.nopcommerce.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        // FInd the login link and click on login Link
        WebElement loginLink= driver.findElement(By.xpath("//a[text()='Log in']"));
        loginLink.click();
        // Verify the text 'Welcome,Please sign in!'
        String expectedMessage="Welcome, Please Sign In!";
        String actualMessage=driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']")).getText();
        Assert.assertEquals("Not redirected to Login Page",expectedMessage,actualMessage);
    }

    @Test
    public void verifyUserShouldLoginSuccessFullyWithValidCredentials(){
        // Click on the 'Login' Link
        WebElement loginLink=driver.findElement(By.xpath("//a[text()='Log in']"));
        loginLink.click();
        // Click on the Login Link
        driver.findElement(By.xpath("//a[text()='Log in']"));
        //Enter valid username in the Email Field
        driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("prime123@gmail.com");
        //Enter the password in Password Field
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Prime123");
        //Click on Login Button
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        // Verify the 'Log out' text is display
        String expectedMessage="Log out";
        driver.findElement(By.xpath("//button[@class='button-1 search-box-button ']")).click();
        String actualMessage = driver.findElement(By.xpath("//a[text()='Log out ']")).getText();
       Assert.assertEquals("Not redirected to Login Page",expectedMessage,actualMessage);

    }
    @Test
    public void verifyTheErrorMessage(){
        // Click on the 'Log in'Link
        WebElement loginLink=driver.findElement(By.xpath("//a[text()='Log in']"));
        loginLink.click();
        // Enter invalid Username
        driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("prime1234@gmail.com");
        // Enter invalid password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Prime1234");
        //Click on Login Button
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        // Verify the Error message 'Login was unsuccessful. Please correct the errors and try again.
        // No customer account found'.
        String expectedMessage="Login was unsuccessful. Please correct the errors and try again.\n" +
                                "No customer account found";
        String actualMessage=driver.findElement(By.xpath("//div[contains(@class, 'message-error')]")).getText();
        Assert.assertEquals("Error message is Not Displayed",expectedMessage,actualMessage);

    }
    @After
    public void tearDown()
    {
        closeBrowser();
    }

}
