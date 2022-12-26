package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeAfterClasses {
    //3 ayri test methodu olusturun
    //1.Method amazon a gidip amazona gittigimizi test edin
    //2.method da amazonda nutella aratip sonuclarin nutella icerdiginin test edin
    //3.method da nutella arama sonuc sayisinin 50 den fazla oldugunun test edin
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void amazonTest() {
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void nutellaTest() throws InterruptedException {

        driver.navigate().refresh();
        Thread.sleep(2000);
        //driver.get("https://www.amazon.com/");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        String expectedWort = "Nutella";
        String actuel = driver.findElement(By.xpath("//span[@class=\"a-color-state a-text-bold\"]")).getText();
        Assert.assertTrue(actuel.contains(expectedWort));
    }

    @Test
    public void nutellaSonuc() throws InterruptedException {
        Thread.sleep(2000);
        String resultsforNutella=driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]")).getText();
        System.out.println(resultsforNutella);
        String[] resultArr=resultsforNutella.split(" ");
        String lastResult=resultArr[2];
        int lastresultInt;
        lastresultInt=Integer.parseInt(lastResult);
        Assert.assertTrue(lastresultInt>50);
        System.out.println(lastresultInt);

    }
}