package lab;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {
  WebDriver driver;

  @BeforeAll
  static void setupAll() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeEach
  void setup() {
    driver = new ChromeDriver();
  }

  @AfterEach
  void teardown() {
    driver.quit();
  }

  @Test
  void testGroupsDistributionPage() {
    driver.get("http://fmi-plovdiv.org");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.findElement(By.linkText("Учебен график")).click();
    driver.findElement(By.linkText("Учебни разписания")).click();
    driver.findElement(By.linkText("Бакалавърски програми")).click();
    driver.findElement(By.linkText("Информатика")).click();

    // TODO1: Click on "Разпределение на групи" for "Редовно обучение"

    // TODO2: Assert using the title that you're on "Факултет по математика и информатика -
    // Информатика Разпределение на групи - редовно обучение" page

    // TODO3: Assert the page is about "УЧЕБНА 2022-2023"

  }
}
