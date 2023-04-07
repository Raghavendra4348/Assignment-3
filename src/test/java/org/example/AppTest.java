package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AppTest {

    WebDriver gitTester;

    @BeforeClass
    @Parameters({"browser","url"})
    public void gitTest(String browser,String link) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            gitTester = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            gitTester = new EdgeDriver();
        }

        gitTester.get(link);
        gitTester.manage().window().maximize();
    }


    @Test
    public void Successfully_login() throws InterruptedException {

        gitTester.findElement(By.cssSelector("input#login_field")).sendKeys("raghavnani777@gmail.com");
        Thread.sleep(3000);
        gitTester.findElement(By.cssSelector("input#password")).sendKeys("Lalithanani2@");
        Thread.sleep(3000);
        gitTester.findElement(By.cssSelector("input[value='Sign in']")).click();
        Thread.sleep(3000);


    }


   @Test
    public void testcase2_login() {
       App a = new App();
       Assert.assertEquals(true,a.login_Git("raghavnani777@gmail.com","Lalithanani2@"));

  }


    @Test
    public void testcase3_login() {
        App a = new App();
        Assert.assertEquals(false,a.login_Git("raghavnani777@gmail.com","Nani2@"));
    }


    @Test
    public void testcase4_login() {
        App a = new App();
        Assert.assertEquals(false,a.login_Git("user@gmail.com","Lalithanani2@"));

    }
    @AfterClass
    void closeDriver(){
        gitTester.close();
    }


}

