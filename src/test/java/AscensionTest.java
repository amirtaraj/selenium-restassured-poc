import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.ascension.pages.AscensionPage;

import java.io.IOException;

public class AscensionTest {

    private WebDriver driver;
    private AscensionPage ascensionPage;
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        try {
            ascensionPage = new AscensionPage(driver); // Instantiate the AscensionPage class
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testNavigateToGoogle() {
        ascensionPage.navigateToAscension(); // Use the ascensionPage instance to navigate
    }
}
