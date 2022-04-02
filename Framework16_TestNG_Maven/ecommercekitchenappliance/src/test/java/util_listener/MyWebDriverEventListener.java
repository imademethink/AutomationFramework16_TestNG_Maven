package util_listener;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class MyWebDriverEventListener implements WebDriverEventListener {
    private static final Logger myLog = Logger.getLogger(MyWebDriverEventListener.class);

    public void beforeAlertAccept(WebDriver var1){}

    public void afterAlertAccept(WebDriver var1){}

    public void afterAlertDismiss(WebDriver var1){}

    public void beforeAlertDismiss(WebDriver var1){}

    public void beforeNavigateTo(String var1, WebDriver var2){}

    public void afterNavigateTo(String var1, WebDriver var2){}

    public void beforeNavigateBack(WebDriver var1){}

    public void afterNavigateBack(WebDriver var1){}

    public void beforeNavigateForward(WebDriver var1){}

    public void afterNavigateForward(WebDriver var1){}

    public void beforeNavigateRefresh(WebDriver var1){}

    public void afterNavigateRefresh(WebDriver var1){}

    public void beforeFindBy(By var1, WebElement var2, WebDriver var3){
        myLog.info("WebDriverEventListener before find by");
    }

    public void afterFindBy(By var1, WebElement var2, WebDriver var3){
        myLog.info("WebDriverEventListener after find by");
    }

    public void beforeClickOn(WebElement var1, WebDriver var2){}

    public void afterClickOn(WebElement var1, WebDriver var2){}

    public void beforeChangeValueOf(WebElement var1, WebDriver var2, CharSequence[] var3){}

    public void afterChangeValueOf(WebElement var1, WebDriver var2, CharSequence[] var3){}

    public void beforeScript(String var1, WebDriver var2){}

    public void afterScript(String var1, WebDriver var2){}

    public void beforeSwitchToWindow(String var1, WebDriver var2){}

    public void afterSwitchToWindow(String var1, WebDriver var2){}

    public void onException(Throwable var1, WebDriver var2){}

    public <X> void beforeGetScreenshotAs(OutputType<X> var1){}

    public <X> void afterGetScreenshotAs(OutputType<X> var1, X var2){}

    public void beforeGetText(WebElement var1, WebDriver var2){}

    public void afterGetText(WebElement var1, WebDriver var2, String var3){}

}
