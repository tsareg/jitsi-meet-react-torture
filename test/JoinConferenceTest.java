import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class JoinConferenceTest {
    private String appPath = "/Users/Defender/Work/Atlassian/jitsi-meet-react/ios/build/Build/Products/Debug-iphonesimulator/JitsiMeetApp.app";

    @Test
    public void shouldBeAbleToJoinConference() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("platformVersion", "9.3");
        desiredCapabilities.setCapability("deviceName", "iPhone 6");
        desiredCapabilities.setCapability("app", appPath);
        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        WebElement roomNameTextField = driver.findElement(By.xpath("//UIATextField[1]"));
        roomNameTextField.click();
        roomNameTextField.sendKeys("test\n");

        driver.findElement(By.xpath("//*[@name=\"  JOIN \"]")).click();

        (new WebDriverWait(driver, 10)).until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@name=\"Conference screen\"]")));

        driver.quit();
    }
}
