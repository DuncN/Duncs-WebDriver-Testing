// I've only included comments to help me learn

package uk.co.duncannisbet.navigation;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UserBrowsesPagesOfWebsiteTests {

    private static WebDriver driver = new FirefoxDriver();
    private IdentifyUserLocationInWebsite navigationActions = new IdentifyUserLocationInWebsite(driver);
    private NavigationElements navigationElements = new NavigationElements(driver);

    @Test
    //smoke test to prove site is actually up
    public void homepageTitleIsCorrect() {

        navigationActions.givenUserIsOnPage("http://www.duncannisbet.co.uk/");
        navigationActions.thenPageIsDisplayed("Duncan Nisbet Bespoke Testing");

    }

    @Test
    //finding an element & clicking on it #1
    public void userNavigatesFromHomePageToWhoIAmPage() {
        navigationActions.givenUserIsOnPage("http://www.duncannisbet.co.uk/");
        navigationElements.whenUserClicksOnNavLink("menu-item-93");
        navigationActions.thenPageIsDisplayed("Duncan Nisbet Software Testing Services | Duncan Nisbet");

    }

    @Test
    //finding an element & clicking on it #2
    public void userNavigatesFromWhoIAmPageToHowITest() {
        navigationActions.givenUserIsOnPage("http://www.duncannisbet.co.uk/who-is-duncan-nisbet");
        navigationElements.whenUserClicksOnNavLink("menu-item-91");
        navigationActions.thenPageIsDisplayed("How I will test your software | Duncan Nisbet");
    }

    @Test
    //trying out Xpath #1 - Carousel navigation
    public void userNavigatesFromHomePageToClientPageUsingCarousel() {
        navigationActions.givenUserIsOnPage("http://www.duncannisbet.co.uk/");
        navigationElements.whenUserClicksCarouselLink();
        navigationActions.thenPageIsDisplayed("Autotrader | Duncan Nisbet");

    }

    @Test
    //trying out Xpath #2 - Banner navigation
    public void userClickingOnBannerIsNavigatedToHome() {
        navigationActions.givenUserIsOnPage("http://www.duncannisbet.co.uk/what-i-test");
        navigationElements.whenUserClicksOnBanner();
        navigationActions.thenPageIsDisplayed("Duncan Nisbet Bespoke Testing");
    }

    @Test
    //trying out Xpath #3 - Sidebar navigation
    public void userClickingOnBlogSidebarLinkIsNavigatedToBlog() {
        navigationActions.givenUserIsOnPage("http://www.duncannisbet.co.uk/");
        navigationElements.whenUserClicksOnSidebarLink("page_item page-item-315");
        navigationActions.thenPageIsDisplayed("Blog | Duncan Nisbet");
    }

    @AfterClass
    public static void closeBrowser() {
        driver.close();
    }
}
