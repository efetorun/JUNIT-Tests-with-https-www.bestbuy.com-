package day05_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //  1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        //  2- arama kutusunu locate edelim
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        // //  3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones" + Keys.ENTER);
        //  4- Bulunan sonuc sayisini yazdiralim
        System.out.println(driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]/span[1]")).getText());
        //  5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("//img[@alt=\"Sponsored Ad - SAMSUNG Galaxy Buds Pro True Wireless Bluetooth Earbuds w/ Noise Cancelling, Charging Case, Quality Sound, ...\"][1]")).click();
        //  6- Sayfadaki tum basliklari yazdiralim
        List<WebElement>ogeler=driver.findElements(By.xpath("//span[@class=\"a-size-base a-color-base\"]"));
        for (WebElement each:ogeler) {
            System.out.println(each.getText());

        }

        driver.quit();
    }
}
