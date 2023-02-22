package com.simplilearn.Phase_4_Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Ajio {

	AndroidDriver<MobileElement> driver;

	@BeforeTest
	public void LaunchApplication() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "RZ8T71D9GZM");
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("appPackage", "com.ril.ajio");
		cap.setCapability("appActivity", "com.ril.ajio.launch.activity.SplashScreenActivity");
		cap.setCapability("noReset", true);
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
	}

	@Test(priority = 1)
	public void SearchHandbagsForWomen() {
		MobileElement Search = driver.findElement(By.id("com.ril.ajio:id/llpsTvSearch"));
		Search.click();
		driver.findElement(By.id("com.ril.ajio:id/searchETV")).sendKeys("Handbags For Women");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Handbags For Women']")).click();
	}

	@Test(priority = 2)
	public void ScrollUp() throws InterruptedException {

		Thread.sleep(5000);
		TouchAction<?> up = new TouchAction<>(driver);
		up.longPress(PointOption.point(529, 1880)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)))
				.moveTo(PointOption.point(529, 572)).release().perform();

	}

	@Test(priority=3)
	public void MoveProductToCart() throws InterruptedException {
		
	driver.findElement(By.xpath("//android.widget.TextView[@text='Panelled Hobo Bag with Hearts Hangtag']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Add To Bag']")).click();
	
	}
		
	@Test(priority=4)
	public void ValidationOfProductInCart() {	
		driver.findElement(By.id("com.ril.ajio:id/menu_cart_iv")).click();
		String expectedResult = "Bag (1 product)";
		String actulResult = driver.findElement(By.id("com.ril.ajio:id/toolbar_title_tv")).getText();
		System.out.println(actulResult);
		Assert.assertEquals(expectedResult, actulResult);
		
		
	}
		
	}