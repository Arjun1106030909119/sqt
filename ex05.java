import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;
public class ex05 extends SeleneseTestCase { @Before
public void setUp() throws Exception {
selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://demo.opensourcecms.com/");
selenium.start();
}
@Test
public void testExp5() throws Exception { selenium.open("/wordpress/wp-login.php"); selenium.type("id=user_login", "admin"); selenium.type("id=user_pass", "demo123"); selenium.click("id=wp-submit"); selenium.waitForPageToLoad("30000");
}
@After
public void tearDown() throws Exception { selenium.stop();
}
}