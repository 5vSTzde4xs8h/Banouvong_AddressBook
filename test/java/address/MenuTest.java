package address;

import java.io.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Menu class unit tests
 *
 * @author Poleon Banouvong
 * @since 2024-02-13
 */
class MenuTest {
  /** Output stream to replace {@link System#in} */
  private ByteArrayOutputStream outputStream;

  /** Replaces {@link System#in} with an output stream that the tests can read */
  @BeforeEach
  public void replaceSystemOut() {
    outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
  }

  /**
   * Replaces {@link System#in} with an input stream containing a string, thereby "simulating input"
   *
   * @param input The simulated input string
   */
  private void simulateInput(String input) {
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
  }

  /** Tests that {@link Menu#promptInput} works as intended */
  @Test
  public void testPromptInput() {
    simulateInput("This is some input" + System.lineSeparator()); // This is some input↵
    String input = Menu.promptInput("Input");

    assertEquals("This is some input", input);
    assertTrue(outputStream.toString().contains("Input: "));
  }

  /** Tests that {@link Menu#promptInput} re-prompts for empty lines */
  @Test
  public void testPromptInputEmpty() {
    simulateInput(
        System.lineSeparator()
            + "This is some input"
            + System.lineSeparator()); // ↵This is some input↵
    String input = Menu.promptInput("Input");

    assertEquals("This is some input", input);
    assertTrue(outputStream.toString().contains("Input: "));
    assertTrue(outputStream.toString().contains("Invalid input"));
  }

  /** Tests that {@link Menu#promptInteger} works as intended */
  @Test
  public void testPromptInteger() {
    simulateInput("12345" + System.lineSeparator()); // 12345↵
    int input = Menu.promptInteger("Input");

    assertEquals(12345, input);
    assertTrue(outputStream.toString().contains("Input: "));
  }

  /** Tests that {@link Menu#promptInteger} re-prompts for empty lines */
  @Test
  public void testPromptIntegerEmpty() {
    simulateInput(System.lineSeparator() + "12345" + System.lineSeparator()); // ↵12345↵
    int input = Menu.promptInteger("Input");

    assertEquals(12345, input);
    assertTrue(outputStream.toString().contains("Input: "));
    assertTrue(outputStream.toString().contains("Invalid input"));
  }

  /** Tests that {@link Menu#promptInteger} re-prompts for non-numeric lines */
  @Test
  public void testPromptIntegerNonNumeric() {
    simulateInput("abcde" + System.lineSeparator() + "12345" + System.lineSeparator()); // abcde↵12345↵
    int input = Menu.promptInteger("Input");

    assertEquals(12345, input);
    assertTrue(outputStream.toString().contains("Input: "));
    assertTrue(outputStream.toString().contains("Invalid input"));
  }

  /** Tests that {@link Menu#prompt_FirstName} works as intended */
  @Test
  public void testPromptFirstName() {
    simulateInput("John" + System.lineSeparator()); // John↵
    String firstName = Menu.prompt_FirstName();

    assertEquals("John", firstName);
  }

  /** Tests that {@link Menu#prompt_FirstName} re-prompts for empty lines */
  @Test
  public void testPromptFirstNameEmpty() {
    simulateInput(System.lineSeparator() + "Jane" + System.lineSeparator()); // ↵Jane↵
    String firstName = Menu.prompt_FirstName();

    assertEquals("Jane", firstName);
    assertTrue(outputStream.toString().contains("Invalid input"));
  }

  /** Tests that {@link Menu#prompt_LastName} works as intended */
  @Test
  public void testPromptLastName() {
    simulateInput("Doe" + System.lineSeparator()); // Doe↵
    String lastName = Menu.prompt_LastName();

    assertEquals("Doe", lastName);
  }

  /** Tests that {@link Menu#prompt_LastName} re-prompts for empty lines */
  @Test
  public void testPromptLastNameEmpty() {
    simulateInput(System.lineSeparator() + "Doe" + System.lineSeparator()); // ↵Doe↵
    String lastName = Menu.prompt_LastName();

    assertEquals("Doe", lastName);
    assertTrue(outputStream.toString().contains("Invalid input"));
  }

  /** Tests that {@link Menu#prompt_Street} works as intended */
  @Test
  public void testPromptStreet() {
    simulateInput("Main Street" + System.lineSeparator()); // Main Street↵
    String street = Menu.prompt_Street();

    assertEquals("Main Street", street);
  }

  /** Tests that {@link Menu#prompt_Street} re-prompts for empty input lines */
  @Test
  public void testPromptStreetEmpty() {
    simulateInput(System.lineSeparator() + "Main Street" + System.lineSeparator()); // ↵Main Street↵
    String street = Menu.prompt_Street();

    assertEquals("Main Street", street);
    assertTrue(outputStream.toString().contains("Invalid input"));
  }

  /** Tests that {@link Menu#prompt_State} works as intended */
  @Test
  public void testPromptState() {
    simulateInput("Mainstate" + System.lineSeparator()); // Mainstate↵
    String state = Menu.prompt_State();

    assertEquals("Mainstate", state);
  }

  /** Tests that {@link Menu#prompt_State} re-prompts for empty input lines */
  @Test
  public void testPromptStateEmpty() {
    simulateInput(System.lineSeparator() + "Mainstate" + System.lineSeparator()); // ↵Mainstate↵
    String state = Menu.prompt_State();

    assertEquals("Mainstate", state);
    assertTrue(outputStream.toString().contains("Invalid input"));
  }

  /** Tests that {@link Menu#prompt_City} works as intended */
  @Test
  public void testPromptCity() {
    simulateInput("Maintown" + System.lineSeparator()); // Maintown↵
    String city = Menu.prompt_City();

    assertEquals("Maintown", city);
  }

  /** Tests that {@link Menu#prompt_City} re-prompts for empty input lines */
  @Test
  public void testPromptCityEmpty() {
    simulateInput(System.lineSeparator() + "Maintown" + System.lineSeparator()); // ↵Maintown↵
    String city = Menu.prompt_City();

    assertEquals("Maintown", city);
    assertTrue(outputStream.toString().contains("Invalid input"));
  }

  /** Tests that {@link Menu#prompt_Zip} works as intended */
  @Test
  public void testPromptZip() {
    simulateInput("12345" + System.lineSeparator()); // 12345↵
    int zip = Menu.prompt_Zip();

    assertEquals(12345, zip);
  }

  /** Tests that {@link Menu#prompt_Zip} re-prompts for empty input lines */
  @Test
  public void testPromptZipEmpty() {
    simulateInput(System.lineSeparator() + "12345" + System.lineSeparator()); // ↵12345↵
    int zip = Menu.prompt_Zip();

    assertEquals(12345, zip);
    assertTrue(outputStream.toString().contains("Invalid input"));
  }

  /** Tests that {@link Menu#prompt_Zip} re-prompts for non-numeric input lines */
  @Test
  public void testPromptZipNonNumeric() {
    simulateInput(
        "abcde" + System.lineSeparator() + "98765" + System.lineSeparator()); // abcde↵98765↵
    int zip = Menu.prompt_Zip();

    assertEquals(98765, zip);
    assertTrue(outputStream.toString().contains("Invalid input"));
  }

  /** Tests that {@link Menu#prompt_Phone} works as intended */
  @Test
  public void testPromptPhone() {
    simulateInput("1234567890" + System.lineSeparator()); // 1234567890↵
    String phone = Menu.prompt_Phone();

    assertEquals("1234567890", phone);
  }

  /** Tests that {@link Menu#prompt_Phone} re-prompts for empty input lines */
  @Test
  public void testPromptPhoneEmpty() {
    simulateInput(System.lineSeparator() + "1234567890" + System.lineSeparator()); // ↵1234567890↵
    String phone = Menu.prompt_Phone();

    assertEquals("1234567890", phone);
    assertTrue(outputStream.toString().contains("Invalid input"));
  }

  /** Tests that {@link Menu#prompt_Email} works as intended */
  @Test
  public void testPromptEmail() {
    simulateInput("john@example.com" + System.lineSeparator()); // john@example.com↵
    String email = Menu.prompt_Email();

    assertEquals("john@example.com", email);
  }

  /** Tests that {@link Menu#prompt_Email} re-prompts for empty input lines */
  @Test
  public void testPromptEmailEmpty() {
    simulateInput(
        System.lineSeparator() + "john@example.com" + System.lineSeparator()); // ↵john@example.com↵
    String email = Menu.prompt_Email();

    assertEquals("john@example.com", email);
    assertTrue(outputStream.toString().contains("Invalid input"));
  }
}
