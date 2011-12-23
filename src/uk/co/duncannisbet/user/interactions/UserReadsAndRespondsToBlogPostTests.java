
package uk.co.duncannisbet.user.interactions;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import uk.co.duncannisbet.navigation.IdentifyUserLocationInWebsite;
import uk.co.duncannisbet.navigation.NavigationElements;

public class UserReadsAndRespondsToBlogPostTests {

    private static WebDriver driver = new FirefoxDriver();
    private IdentifyUserLocationInWebsite IdentifyUserLocationInWebsite = new IdentifyUserLocationInWebsite(driver);
    private NavigationElements navigationElements = new NavigationElements(driver);

    @Test
    public void userFindsPostToReadOnPage2() {
        IdentifyUserLocationInWebsite.givenUserIsOnPage("http://www.duncannisbet.co.uk/blog/");
        navigationElements.whenUserClicksOnOlderEntriesLink("Older Entries");
        IdentifyUserLocationInWebsite.thenPageIsDisplayed("Blog | Duncan Nisbet - Part 2");

    }

    @Test
    public void userReadsPostByClickingOnPostTitle() {
        IdentifyUserLocationInWebsite.givenUserIsOnPage("http://www.duncannisbet.co.uk/blog/page/2");
        navigationElements.andCanSeeBogPost("What is my testing ideology?");
        navigationElements.whenUserClicksOnPostTitle("What is my testing ideology?");
        IdentifyUserLocationInWebsite.thenPageIsDisplayed("What is my testing ideology? | Duncan Nisbet");

    }

    @Test
    //Trying to make Xpath more dynamic by passing parameters to it
    public void userReadsPostByClickingOnReadFullPostLink() {
        IdentifyUserLocationInWebsite.givenUserIsOnPage("http://www.duncannisbet.co.uk/blog/page/2");
        navigationElements.andCanSeeBogPost("Liverpool STC Meetup");
        navigationElements.whenUserClicksOnReadFullPostLinkFor("liverpool-stc-meetup", "535");
        IdentifyUserLocationInWebsite.thenPageIsDisplayed("Liverpool STC Meetup | Duncan Nisbet");
    }

    @AfterClass
    public static void closeBrowser() {
        driver.close();
    }

}
