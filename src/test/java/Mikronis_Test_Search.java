import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Mikronis_Test_Search {
    //-----------------------------------Global Variables-----------------------------------
    //Declare a Webdriver variable
    public WebDriver driver;
    //Declare a test URL variable
    public String testURL = "https://www.mikronis.hr/";
    //-----------------------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        //Create a new ChromeDriver
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }
    @Test
    public void mikronisSearchTest() throws InterruptedException {
        WebElement searchTextBox = driver.findElement(By.xpath("//form[@id='katalogSearch']/ul//input[@name='query']"));
        searchTextBox.sendKeys("gtx1080");
        searchTextBox.submit();
        Thread.sleep(5000);
        WebElement testLink = driver.findElement(By.xpath("//div[@id='category-container']//h1[.='Rezultati pretrage za gtx1080']"));
        Assert.assertEquals(testLink.getText(), "Rezultati pretrage za gtx1080");

    }


    @Test

    public void mikronisSortTest() throws InterruptedException {
        WebElement searchTextBox = driver.findElement(By.xpath("//form[@id='katalogSearch']/ul//input[@name='query']"));
        searchTextBox.sendKeys("gtx1080");
        searchTextBox.submit();
        driver.findElement(By.xpath("//div[@id='category-container']/div[@class='page-main']/div[4]/div[1]//button[@title='Poredaj po relevantnosti']")).click();
        driver.findElement(By.xpath("//div[@id='category-container']/div[@class='page-main']//div[@class='sort-results']/div/div/ul[@role='menu']/li[2]/a/span[@class='text']")).click();
        Thread.sleep(5000);

    }

    @Test

    public void mikronisChartTest() throws InterruptedException {
        WebElement searchTextBox = driver.findElement(By.xpath("//form[@id='katalogSearch']/ul//input[@name='query']"));
        searchTextBox.sendKeys("gtx1080");
        searchTextBox.submit();
        driver.findElement(By.xpath("//div[@id='category-container']/div[@class='page-main']/div[4]/div[2]/div[1]/div[4]/div[@class='item-pic']/a[@href='/Proizvod/hp-pavilion-gaming-17-cd0015nm-intel-core-i7-9750h-2-60ghz-8gb-256gb-ssd-freedos-17-3-full-hd-nvidia-geforce-gtx1050-3gb-p-n-7ry20ea/5208']/img")).click();
        driver.findElement(By.xpath("//section[@id='app-cont']/div[@class='page-content']/div[@class='container']//a[@class='btn btn-action']")).click();
        driver.findElement(By.xpath("//header[@id='header']//ul[@class='header-menu']//a[@href='/Kosarica']/span[@class='icon-bag']")).click();
        driver.findElement(By.xpath("//section[@id='app-cont']/div[@class='container']/div/div[@class='basket-products basket-products-sidro']/div[@class='item']/div[@class='basket-row']/div[3]/a[@href='javascript:;']")).click();

        Thread.sleep(5000);

    }

    @Test

    public void mikronisLoginPageOpeningTest() throws InterruptedException {
        driver.findElement(By.xpath("//header[@id='header']//ul[@class='header-menu']//a[@href='/Prijava']")).click();
        WebElement testLink = driver.findElement(By.xpath("//ul[@id='bread']/li[.='Prijava / Registracija']"));
        Assert.assertEquals(testLink.getText(), "Prijava / Registracija");
        Thread.sleep(5000);

    }

    @Test

    public void mikronisContactUsPageOpeningTest() throws InterruptedException {
        driver.findElement(By.xpath("//body[@id='page_top']/footer/div[@class='container']/div[1]/ul[@class='link-list']//a[@href='/web/kontaktirajte-nas/52']")).click();
        WebElement testLink = driver.findElement(By.xpath("//ul[@id='bread']/li[.='Kontaktirajte nas']"));
        Assert.assertEquals(testLink.getText(), "Kontaktirajte nas");
        Thread.sleep(5000);

    }

    //-----------------------------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        driver.quit();
    }
}
