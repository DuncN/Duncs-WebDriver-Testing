
package uk.co.duncannisbet.navigation;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.WebDriver;

public class IdentifyUserLocationInWebsite {

    private final WebDriver driver;

    public IdentifyUserLocationInWebsite(WebDriver driver) {
        this.driver = driver;
    }

    public void givenUserIsOnPage(String page) {
        driver.get(page);

    }

    public void thenPageIsDisplayed(String page) {
        assertThat("Page Title is wrong", driver.getTitle(), is(page));
    }

}
