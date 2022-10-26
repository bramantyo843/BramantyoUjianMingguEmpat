package bramantyo.test.calculator;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.example.pages.CalculatorPengurangan;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestPengurangan {

    private static AndroidDriver<MobileElement> driver;
    private CalculatorPengurangan calculatorpengurangan;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel_2_API_25");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.1.1");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @BeforeMethod
    public void pageObject() {
        calculatorpengurangan = new CalculatorPengurangan(driver);
    }

    @Test
    public void testAdd() {
        calculatorpengurangan.calcMinus();
        System.out.println("Hasil = "+calculatorpengurangan.getTxtResultMin());
        Assert.assertEquals(calculatorpengurangan.getTxtResultMin(), "-1");
    }

    @AfterClass
    public void closeApp() {
        driver.quit();
    }

}
