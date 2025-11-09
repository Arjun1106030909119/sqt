import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import com.thoughtworks.selenium.*;
import org.openqa.selenium.server.*;
import org.testng.annotations.*;
public class ex07 {
public Selenium selenium;
public SeleniumServer seleniumserver;
@BeforeClass
public void setUp() throws Exception {
RemoteControlConfiguration rc = new RemoteControlConfiguration();
seleniumserver = new SeleniumServer(rc);
selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://");
seleniumserver.start();
selenium.start();
}
@Test
public void testDropdowngoogle()throws Exception { selenium.open("http://www.schools9.com/kdiploma11022011.htm"); selenium.waitForPageToLoad("3000");
String[] option = selenium.getSelectOptions("name=course"); File file = new File("C:/Dropdownvalues.xls");//excel
File file1 = new File("C:/Dropdownvalues.txt");//notepad BufferedWriter out = new BufferedWriter(new FileWriter(file));//excel BufferedWriter out1 = new BufferedWriter(new FileWriter(file1));//notepad out.write("Options in drop down\n");//Excel
out1.write("Options in drop down\n");//notepad for (int i = 0; i < option.length; i++) {
System.out.println("Option: " + i + " is" + option[i]); out.write(""+option[i]);
out.newLine();
out1.write(""+option[i]);
out1.newLine();
}
out.close();//excel
out1.close();//notepad
}
@AfterClass
public void tearDown()throws Exception {
selenium.stop();
seleniumserver.stop();
}
}