package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TopMenuTest extends BaseTest
{
    String baseUrl="https://demo.nopcommerce.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToComputersPageSuccessfully()
    {
        driver.findElement(By.xpath("//a[text() = 'Computers ']")).click();
        //Verify the text 'Computers'
        String pageTitle = driver.findElement(By.xpath("//h1[text()='Computers']")).getText();
        Assert.assertEquals("Computers",pageTitle);
    }
    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully()
    {
        String expectedMessage="Electronics";
        // Click on the 'Electronics' Tab
        driver.findElement(By.xpath("//a[text()='Electronics ']")).click();
        // Verify the text 'Electronics'
        String pageTitle = driver.findElement(By.xpath("//h1[text()='Electronics']")).getText();
        Assert.assertEquals("Electronics", pageTitle);
    }
    @Test
    public void userShouldNavigateToApparelPageSuccessfully()
    {
        String expectedMessage="Apparel";
        // Click on the 'Apparel' Tab
        driver.findElement(By.xpath("//a[text()='Apparel ']")).click();
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//h1"));
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to click on Apparel tab",expectedMessage,actualMessage);
   }
   @Test
   public void verifyUserShouldNavigateToDigitalDownloadsPageSuccessfully()
   {
       String expectedMessage = "Digital downloads";
       //Element to click on Digital downloads tab
       driver.findElement(By.xpath("//a[text()='Digital downloads ']")).click();
       // Element to get message
       WebElement getMessage = driver.findElement(By.xpath("//h1"));
       String actualMessage = getMessage.getText();
       // verification of actual message and excepted message
       Assert.assertEquals("Fail to click on Digital Downloads tab",expectedMessage,actualMessage);
   }
   @Test
   public void verifyUserShouldNavigateToBooksPageSuccessfully()
   {
       String expectedMessage = "Books";
       //Element to click on Books tab
       driver.findElement(By.xpath("//a[text()='Books ']")).click();
       // Element to get message
       WebElement getMessage = driver.findElement(By.xpath("//h1"));
       String actualMessage = getMessage.getText();
       // verification of actual message and excepted message
       Assert.assertEquals("Fails to click on books tab",expectedMessage,actualMessage);
   }
   @Test
   public void verifyuserShouldNavigateToJewelryPageSuccessfully()
   {
       String expectedMessage = "Jewelry";
       //Element to click on Jewelry tab
       driver.findElement(By.xpath("//a[text()='Jewelry ']")).click();
       // Element to get message
       WebElement getMessage = driver.findElement(By.xpath("//h1"));
       String actualMessage = getMessage.getText();
       // verification of actual message and excepted message
       Assert.assertEquals("Fails to click on Jewelry tab",expectedMessage,actualMessage);
   }
   @Test
   public void verifyUserShouldNavigateToGiftCardsPageSuccessfully()
   {
       String expectedMessage = "Gift Cards";
       //Click to Gift Cards tab
       driver.findElement(By.xpath("//a[text()='Gift Cards ']")).click();
       //element to get message
       WebElement getMessage = driver.findElement(By.xpath("//h1"));
       String actualMessage = getMessage.getText();
       //Verification of actual and expected message
       Assert.assertEquals("Fail to get the Message",expectedMessage,actualMessage);
   }

    @After
    public void tearDown()
    {
        closeBrowser();
        driver.quit();
    }
}
