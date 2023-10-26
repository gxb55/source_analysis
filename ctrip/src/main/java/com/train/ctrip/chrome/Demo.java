package com.train.ctrip.chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author xbguo
 * @date 2023/10/23 10:00
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Users\\xbguo\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://tracker.tars.release.ctripcorp.com/report/table/");
        String title = driver.getTitle();

        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        WebElement j_username = driver.findElement(By.id("username"));
        WebElement j_password = driver.findElement(By.id("password"));
        WebElement Submit = driver.findElement(By.cssSelector("input[type='submit']"));


        j_username.sendKeys("xbguo");
        j_password.sendKeys("ML*gxb6666");
        Submit.click();
        Thread.sleep(5000);


        System.out.println("-----------------------");
      //  WebElement element = driver.findElement(By.id("captain-7826954"));
        WebElement element = driver.findElement(By.cssSelector("select[form_field='track_1l_class']"));
        Select select = new Select(element);
        select.selectByValue("环境问题");

      //  WebElement element1 = driver.findElement(By.id("captain-7826954"));
        WebElement element1 = driver.findElement(By.cssSelector("select[form_field='track_2l_class']"));
        Select select1 = new Select(element1);
        select1.selectByValue("需要生产环境测试");

        WebElement detail = driver.findElement(By.cssSelector("textarea[class='tracker_field elastic_field']"));
        detail.click();
        Thread.sleep(10);
        detail.sendKeys("堡垒测试");

        WebElement save = driver.findElement(By.id("btn_bulk_save"));
        save.click();

     /*   System.out.println("-----------------------");
        WebElement modelLink = driver.findElement(By.cssSelector("a[class='model-link inside']"));
        modelLink.click();
        System.out.println("-----------------------");
        WebElement cmsapi = driver.findElement(By.cssSelector("a[href='job/cms-api/']"));
        cmsapi.click();
        WebElement Build = driver.findElement(By.cssSelector("a[title='Build with Parameters']"));
        Build.click();*/
    }
}
