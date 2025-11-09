package testscripts;
import com.thoughtworks.selenium.*;
import org.openqa.selenium.server.*;
import org.testng.annotations.*;
public class ex06 {
public Selenium selenium;
public SeleniumServer seleniumserver;
@BeforeClass
public void setUp() throws Exception {
RemoteControlConfiguration rc = new RemoteControlConfiguration(); seleniumserver = new SeleniumServer(rc);
selenium = new DefaultSelenium("localhost", 4444, "*firefox","http://");
seleniumserver.start();
selenium.start();
}
@Test
public void testDefaultTNG() throws Exception {
selenium.open("http://www.google.co.in/");
selenium.windowMaximize();
String lc[]=selenium.getAllLinks();
System.out.println("TOTAL NO OF LINKS="+lc.length);
String bc[]=selenium.getAllButtons();
System.out.println("TOTAL NO OF BUTTONS="+bc.length);
String fc[]=selenium.getAllFields();
System.out.println("TOTAL NO OF INPUT FIELDS="+fc.length);
}
@AfterClass
public void tearDown() throws Exception {
selenium.stop();
seleniumserver.stop();
}
}