
package uk.co.duncannisbet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UserBrowsesPagesOfWebsite {

    private static WebDriver driver;
    private WebElement navBarMenu;

    @BeforeClass
    public static void beforeClass() {
        driver = new FirefoxDriver();
    }

    @Test
    public void homepageTitleIsCorrect() {

        givenUserIsOnPage("http://www.duncannisbet.co.uk/");
        assertThat("Page Title is wrong", driver.getTitle(), is("Duncan Nisbet Bespoke Testing"));

    }

    @Test
    public void userNavigatesFromHomePageToWhoIAmPage() {
        givenUserIsOnPage("http://www.duncannisbet.co.uk/");
        whenUserClicksOnNavLink("menu-item-93");
        thenPageIsDisplayed("Duncan Nisbet Software Testing Services | Duncan Nisbet");

    }

    @Test
    public void userNavigatesFromWhoIAmPageToHowITest() {
        givenUserIsOnPage("http://www.duncannisbet.co.uk/who-is-duncan-nisbet");
        whenUserClicksOnNavLink("menu-item-91");
        thenPageIsDisplayed("How I will test your software | Duncan Nisbet");
    }

    private void givenUserIsOnPage(String page) {
        driver.get(page);

    }

    private void whenUserClicksOnNavLink(String navlink) {
        navBarMenu = driver.findElement(By.id(navlink));
        navBarMenu.click();
    }

    private void thenPageIsDisplayed(String page) {
        assertThat("Page Title is wrong", driver.getTitle(), is(page));
    }

    @AfterClass
    public static void afterClass() {
        driver.close();
    }

}
