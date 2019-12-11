package pages;

import org.openqa.selenium.By;
import util.WebDriverFacade;

public abstract class AbstractPage {

    private final String url;

    protected final WebDriverFacade facade;

    public AbstractPage(String url, WebDriverFacade facade) {
        this.url = url;
        this.facade = facade;

    }

    public void loadPage() {
        facade.loadPage(url);
    }

    public void takePageScreenshot(){
        System.out.println("TODO: implement scrn");
    }

    public boolean isLoaded(){
        return false;
    }
}
