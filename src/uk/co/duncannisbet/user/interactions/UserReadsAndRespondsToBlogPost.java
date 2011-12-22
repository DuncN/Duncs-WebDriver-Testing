
package uk.co.duncannisbet.user.interactions;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import uk.co.duncannisbet.navigation.NavigationActions;

public class UserReadsAndRespondsToBlogPost {

    private static WebDriver driver = new FirefoxDriver();
    private NavigationActions navigationActions = new NavigationActions(driver);

    @Test
    public void userFindsPostToReadOnPage2() {
        navigationActions.givenUserIsOnPage("http://www.duncannisbet.co.uk/blog/");
        navigationActions.whenUserClicksOnOlderEntriesLink("Older Entries");
        navigationActions.thenPageIsDisplayed("Blog | Duncan Nisbet - Part 2");

    }

    //    @Test
    //    public void userReadsPostByClickingOnPostTitle() {
    //
    //    }
    //
    //    @Test
    //    public void userReadsPostByClickingOnReadFullPostLink() {
    //
    //    }

    @AfterClass
    public static void closeBrowser() {
        driver.close();
    }

}
