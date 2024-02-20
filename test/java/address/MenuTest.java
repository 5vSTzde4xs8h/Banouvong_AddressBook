package address;

import address.data.AddressBook;
import address.data.AddressEntry;
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
  /** Output stream to replace {@link System#out} */
  private ByteArrayOutputStream outputStream;

  /** Address entry for John Doe */
  private final AddressEntry johnDoe =
      new AddressEntry(
          "John",
          "Doe",
          "1234 Main Street",
          "Maintown",
          "Mainstate",
          12345,
          "1234567890",
          "johndoe@example.com");

  /** Address entry for Jane Doe */
  private final AddressEntry janeDoe =
      new AddressEntry(
          "Jane",
          "Doe",
          "5678 Main Street",
          "Maintown",
          "Mainstate",
          12345,
          "0987654321",
          "janedoe@example.com");

  /** Address entry for John Smith */
  private final AddressEntry johnSmith =
      new AddressEntry(
          "John",
          "Smith",
          "9012 Main Street",
          "Maintown",
          "Mainstate",
          12345,
          "2468013579",
          "johnsmith@example.com");

  /** Address entry for Jane Smith */
  private final AddressEntry janeSmith =
      new AddressEntry(
          "Jane",
          "Smith",
          "1025 Inner Ring",
          "Strasas",
          "Melona",
          76102,
          "5849301812",
          "janesmith@example.com");

  /** Address entry for Aaron Baron */
  private final AddressEntry aaronBaron =
      new AddressEntry(
          "Aaron",
          "Baron",
          "1029 Side Street",
          "Sidetown",
          "Mainstate",
          12356,
          "1029384756",
          "abaron@example.com");

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
    simulateInput(
        "abcde" + System.lineSeparator() + "12345" + System.lineSeparator()); // abcde↵12345↵
    int input = Menu.promptInteger("Input");

    assertEquals(12345, input);
    assertTrue(outputStream.toString().contains("Input: "));
    assertTrue(outputStream.toString().contains("Invalid input"));
  }

  /** Tests that {@link Menu#prompt_FirstName} works as intended */
  @Test
  public void testPromptFirstName() {
    simulateInput("John" + System.lineSeparator()); // John↵
    String firstNameJohn = Menu.prompt_FirstName();

    simulateInput(System.lineSeparator() + "Jane" + System.lineSeparator()); // ↵Jane↵
    String firstNameJane = Menu.prompt_FirstName();

    assertEquals("John", firstNameJohn);
    assertEquals("Jane", firstNameJane);
    assertTrue(outputStream.toString().contains("First name: "));
    assertTrue(outputStream.toString().contains("Invalid input"));
  }

  /** Tests that {@link Menu#prompt_LastName} works as intended */
  @Test
  public void testPromptLastName() {
    simulateInput("Doe" + System.lineSeparator()); // Doe↵
    String lastNameDoe = Menu.prompt_LastName();

    simulateInput(System.lineSeparator() + "Smith" + System.lineSeparator()); // ↵Smith↵
    String lastNameSmith = Menu.prompt_LastName();

    assertEquals("Doe", lastNameDoe);
    assertEquals("Smith", lastNameSmith);
    assertTrue(outputStream.toString().contains("Last name: "));
    assertTrue(outputStream.toString().contains("Invalid input"));
  }

  /** Tests that {@link Menu#prompt_Street} works as intended */
  @Test
  public void testPromptStreet() {
    simulateInput("Mainstreet" + System.lineSeparator()); // Mainstreet↵
    String streetMainstreet = Menu.prompt_Street();

    simulateInput(System.lineSeparator() + "Sidestreet" + System.lineSeparator()); // ↵Sidestreet↵
    String streetSidestreet = Menu.prompt_Street();

    assertEquals("Mainstreet", streetMainstreet);
    assertEquals("Sidestreet", streetSidestreet);
    assertTrue(outputStream.toString().contains("Street: "));
    assertTrue(outputStream.toString().contains("Invalid input"));
  }

  /** Tests that {@link Menu#prompt_City} works as intended */
  @Test
  public void testPromptCity() {
    simulateInput("Maintown" + System.lineSeparator()); // Maintown↵
    String cityMaintown = Menu.prompt_City();

    simulateInput(System.lineSeparator() + "Sidetown" + System.lineSeparator()); // ↵Sidetown↵
    String citySidetown = Menu.prompt_City();

    assertEquals("Maintown", cityMaintown);
    assertEquals("Sidetown", citySidetown);
    assertTrue(outputStream.toString().contains("City: "));
    assertTrue(outputStream.toString().contains("Invalid input"));
  }

  /** Tests that {@link Menu#prompt_State} works as intended */
  @Test
  public void testPromptState() {
    simulateInput("Mainstate" + System.lineSeparator()); // Mainstate↵
    String stateMainstate = Menu.prompt_State();

    simulateInput(System.lineSeparator() + "Sidestate" + System.lineSeparator()); // ↵Sidestate↵
    String stateSidestate = Menu.prompt_State();

    assertEquals("Mainstate", stateMainstate);
    assertEquals("Sidestate", stateSidestate);
    assertTrue(outputStream.toString().contains("State: "));
    assertTrue(outputStream.toString().contains("Invalid input"));
  }

  /** Tests that {@link Menu#prompt_Zip} works as intended */
  @Test
  public void testPromptZip() {
    simulateInput("12345" + System.lineSeparator()); // 12345↵
    int zip12345 = Menu.prompt_Zip();

    simulateInput(System.lineSeparator() + "67890" + System.lineSeparator()); // ↵67890↵
    int zip67890 = Menu.prompt_Zip();

    simulateInput(
        "abcde" + System.lineSeparator() + "10293" + System.lineSeparator()); // abcde↵10293↵
    int zip10293 = Menu.prompt_Zip();

    assertEquals(12345, zip12345);
    assertEquals(67890, zip67890);
    assertEquals(10293, zip10293);

    assertTrue(outputStream.toString().contains("ZIP code: "));
    assertTrue(outputStream.toString().contains("Invalid input"));
  }

  /** Tests that {@link Menu#prompt_Phone} works as intended */
  @Test
  public void testPromptPhone() {
    simulateInput("1234567890" + System.lineSeparator()); // 1234567890↵
    String phone1234567890 = Menu.prompt_Phone();

    simulateInput(System.lineSeparator() + "0987654321" + System.lineSeparator()); // ↵0987654321↵
    String phone0987654321 = Menu.prompt_State();

    assertEquals("1234567890", phone1234567890);
    assertEquals("0987654321", phone0987654321);
    assertTrue(outputStream.toString().contains("Phone number: "));
    assertTrue(outputStream.toString().contains("Invalid input"));
  }

  /** Tests that {@link Menu#prompt_Email} works as intended */
  @Test
  public void testPromptEmail() {
    simulateInput("johndoe@example.com" + System.lineSeparator()); // johndoe@example.com↵
    String emailJohnDoe = Menu.prompt_Email();

    simulateInput(
        System.lineSeparator()
            + "janesmith@example.com"
            + System.lineSeparator()); // ↵janesmith@example.com↵
    String emailJaneSmith = Menu.prompt_Email();

    assertEquals("johndoe@example.com", emailJohnDoe);
    assertEquals("janesmith@example.com", emailJaneSmith);
    assertTrue(outputStream.toString().contains("Email: "));
    assertTrue(outputStream.toString().contains("Invalid input"));
  }

  /** Tests that {@link Menu#promptAddEntriesFromFile} works as intended */
  @Test
  public void testPromptAddEntriesFromFile() {
    simulateInput("test/resources/addressBook.txt" + System.lineSeparator());

    AddressBook addressBook = new AddressBook();
    Menu.promptAddEntriesFromFile(addressBook);

    String output = outputStream.toString();
    assertTrue(output.contains("Added 5 entries"));
    assertTrue(addressBook.contains(johnDoe));
    assertTrue(addressBook.contains(janeDoe));
    assertTrue(addressBook.contains(johnSmith));
    assertTrue(addressBook.contains(janeSmith));
    assertTrue(addressBook.contains(aaronBaron));
  }

  /** Tests that {@link Menu#promptAddEntry} works as intended */
  @Test
  public void testPromptAddEntry() {
    simulateInput(
        "John"
            + System.lineSeparator()
            + "Doe"
            + System.lineSeparator()
            + "1234 Main Street"
            + System.lineSeparator()
            + "Maintown"
            + System.lineSeparator()
            + "Mainstate"
            + System.lineSeparator()
            + "12345"
            + System.lineSeparator()
            + "1234567890"
            + System.lineSeparator()
            + "johndoe@example.com");

    AddressBook addressBook = new AddressBook();
    Menu.promptAddEntry(addressBook);

    String output = outputStream.toString();
    assertTrue(output.contains("First name: "));
    assertTrue(output.contains("Last name: "));
    assertTrue(output.contains("Street: "));
    assertTrue(output.contains("City: "));
    assertTrue(output.contains("State: "));
    assertTrue(output.contains("ZIP code: "));
    assertTrue(output.contains("Phone: "));
    assertTrue(output.contains("Email: "));
    assertTrue(addressBook.contains(johnDoe));
  }

  /** Tests that {@link Menu#promptRemoveEntry} works as intended */
  @Test
  public void testPromptRemoveEntry() {
    simulateInput("doe" + System.lineSeparator() + "1" + System.lineSeparator());

    AddressBook addressBook = new AddressBook();
    addressBook.add(johnDoe);
    addressBook.add(janeDoe);

    Menu.promptRemoveEntry(addressBook);
    String output = outputStream.toString();

    assertTrue(output.contains("Found 2 entries"));
    assertTrue(addressBook.contains(johnDoe));
    assertFalse(addressBook.contains(janeDoe));
  }

  /** Tests that {@link Menu#promptFindEntries} works as intended */
  @Test
  public void testPromptFindEntries() {
    simulateInput("doe" + System.lineSeparator() + "1" + System.lineSeparator());

    AddressBook addressBook = new AddressBook();
    addressBook.add(johnDoe);
    addressBook.add(janeDoe);

    Menu.promptFindEntries(addressBook);

    String output = outputStream.toString();
    assertTrue(output.contains(johnDoe.toString()));
    assertTrue(output.contains(janeDoe.toString()));
  }
}
