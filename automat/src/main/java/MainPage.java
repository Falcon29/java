import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @FindBy(id = "q")
    WebElement searchInputField;

    @FindBy(css = "input[type='submit']")
    WebElement searchButton;

    public MainPage(WebDriver driver) {
        webDriver = driver;
        webDriverWait = new WebDriverWait(webDriver, 30);

        PageFactory.initElements(webDriver, this);
    }

    public void enterSearchableText(String text) {
        searchInputField.clear();
        searchInputField.sendKeys(text);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
