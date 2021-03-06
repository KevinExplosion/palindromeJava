import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.*;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;


public class PalindromeTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();


  @Test
  public void palindromeChecker_catShouldReturn_false() {
    assertEquals(false, Palindrome.palindromeChecker("cat"));
  }

  @Test
  public void palindromeChecker_annaShouldReturn_true() {
    assertEquals(true, Palindrome.palindromeChecker("anna"));
  }

  @Test
  public void palindromeChecker_rotatorShouldReturn_true() {
    assertEquals(true, Palindrome.palindromeChecker("rotator"));
  }

  @Test
  public void palindromeChecker_amoreRomaShouldReturn_true() {
    assertEquals(true, Palindrome.palindromeChecker("Amore, roma"));
  }
}
