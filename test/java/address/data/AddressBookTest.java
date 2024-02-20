package address.data;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * AddressBook class unit tests
 *
 * @author Poleon Banouvong
 * @since 2024-02-13
 */
class AddressBookTest {
  /** Address entry for John Doe */
  AddressEntry johnDoe =
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
  AddressEntry janeDoe =
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
  AddressEntry johnSmith =
      new AddressEntry(
          "John",
          "Smith",
          "9012 Main Street",
          "Maintown",
          "Mainstate",
          12345,
          "2468013579",
          "johnsmith@example.com");

  /** Address entry for a second John Doe */
  AddressEntry johnDoe2 =
      new AddressEntry(
          "John",
          "Doe",
          "3456 Main Street",
          "Maintown",
          "Mainstate",
          12345,
          "1357924680",
          "johndoe2@example.com");

  /** Address entry for Aaron Baron */
  AddressEntry aaronBaron =
      new AddressEntry(
          "Aaron",
          "Baron",
          "1029 Side Street",
          "Sidetown",
          "Mainstate",
          12356,
          "1029384756",
          "abaron@example.com");

  /** Tests that an {@link AddressEntry} can be added to the address book */
  @Test
  public void testAdd() {
    AddressBook addressBook = new AddressBook();
    assertTrue(addressBook.add(johnDoe));
  }

  /** Tests that adding the same {@link AddressEntry} twice doesn't work */
  @Test
  public void testAddDuplicate() {
    AddressBook addressBook = new AddressBook();
    addressBook.add(johnDoe);

    assertFalse(addressBook.add(johnDoe));
  }

  /** Tests that adding two {@link AddressEntry}s with the same first name works */
  @Test
  public void testAddDuplicateFirstName() {
    AddressBook addressBook = new AddressBook();
    addressBook.add(johnDoe);

    assertTrue(addressBook.add(johnSmith));
  }

  /** Tests that adding two {@link AddressEntry}s with the same last name works */
  @Test
  public void testAddDuplicateLastName() {
    AddressBook addressBook = new AddressBook();
    addressBook.add(johnDoe);

    assertTrue(addressBook.add(janeDoe));
  }

  /**
   * Tests that adding two different {@link AddressEntry}s with the same first and last name doesn't
   * work
   */
  @Test
  public void testAddDuplicateNames() {
    AddressBook addressBook = new AddressBook();
    addressBook.add(johnDoe);

    assertFalse(addressBook.add(johnDoe2));
  }

  /** Tests that address entries can be read from a file */
  @Test
  public void testReadFile() {
    String testFileName = "test/resources/addressBook.txt";
    AddressBook addressBook = new AddressBook();

    AddressEntry janeSmith =
        new AddressEntry(
            "Jane",
            "Smith",
            "1025 Inner Ring",
            "Strasas",
            "Melona",
            76102,
            "5849301812",
            "janesmith@example.com");

    ArrayList<AddressEntry> addedEntries = addressBook.readFromFile(testFileName);
    assertEquals(5, addedEntries.size());
    assertEquals(johnDoe, addedEntries.get(0));
    assertEquals(janeDoe, addedEntries.get(1));
    assertEquals(johnSmith, addedEntries.get(2));
    assertEquals(janeSmith, addedEntries.get(3));
    assertEquals(aaronBaron, addedEntries.get(4));
  }

  /**
   * Tests that reading entries from a malformed file (meaning a file that has an invalid field or
   * missing fields) will add all the entries before the malformed one
   */
  @Test
  public void testReadMalformedFile() {
    String testFile1Name = "test/resources/addressBookMalformed.txt";
    String testFile2Name = "test/resources/addressBookIncomplete.txt";
    AddressBook addressBook = new AddressBook();

    ArrayList<AddressEntry> addedEntries = addressBook.readFromFile(testFile1Name);
    ArrayList<AddressEntry> addedEntries2 = addressBook.readFromFile(testFile2Name);
    String addressBookListing = addressBook.list();

    assertEquals(1, addedEntries.size());
    assertEquals(0, addedEntries2.size());
    assertTrue(addressBookListing.contains("John Doe"));
    assertFalse(addressBookListing.contains("Jane Doe"));
    assertFalse(addressBookListing.contains("John Smith"));
  }

  /**
   * Tests that reading from an empty (meaning actually empty or containing only whitespace) file
   * adds no entries
   */
  @Test
  public void testReadEmptyFile() {
    String fileName = "test/resources/addressBookEmpty.txt";
    AddressBook addressBook = new AddressBook();
    ArrayList<AddressEntry> addedEntries = addressBook.readFromFile(fileName);

    assertEquals(0, addedEntries.size());
  }

  /** Tests that passing an empty filename returns an empty list */
  @Test
  public void testReadEmptyFileName() {
    AddressBook addressBook = new AddressBook();
    ArrayList<AddressEntry> addedEntries = addressBook.readFromFile("");

    assertEquals(0, addedEntries.size());
  }

  /** Tests that reading a non-existent file returns an empty list */
  @Test
  public void testReadMissingFile() {
    String fileName = "test/resources/addressBookNonExistent.txt";
    AddressBook addressBook = new AddressBook();
    ArrayList<AddressEntry> addedEntries = addressBook.readFromFile(fileName);

    assertEquals(0, addedEntries.size());
  }

  /** Tests that reading duplicate entries doesn't add new ones */
  @Test
  public void testReadDuplicateFile() {
    String fileName = "test/resources/addressBook.txt";
    AddressBook addressBook = new AddressBook();

    ArrayList<AddressEntry> addedEntries = addressBook.readFromFile(fileName);
    ArrayList<AddressEntry> duplicateAddedEntries = addressBook.readFromFile(fileName);

    assertEquals(5, addedEntries.size());
    assertEquals(0, duplicateAddedEntries.size());
  }

  /** Tests that an {@link AddressEntry} can be removed from an address book */
  @Test
  public void testRemove() {
    AddressBook addressBook = new AddressBook();
    addressBook.add(johnDoe);

    assertTrue(addressBook.remove(johnDoe));
  }

  /** Tests that removing an {@link AddressEntry} twice from the same address book doesn't work */
  @Test
  public void testRemoveDuplicate() {
    AddressBook addressBook = new AddressBook();
    addressBook.add(johnDoe);
    addressBook.remove(johnDoe);

    assertFalse(addressBook.remove(johnDoe));
  }

  /** Tests that finding {@link AddressEntry}s by last name works as intended */
  @Test
  public void testFind() {
    AddressBook addressBook = new AddressBook();
    addressBook.add(johnDoe);
    addressBook.add(janeDoe);
    addressBook.add(aaronBaron);

    ArrayList<AddressEntry> foundEntriesFullLastName = addressBook.find("Doe");
    ArrayList<AddressEntry> foundEntriesPartialLastName = addressBook.find("D");
    ArrayList<AddressEntry> foundEntriesNonsenseLastName =
        addressBook.find("o"); // none of the last names start with O
    ArrayList<AddressEntry> foundEntriesEmptyLastName =
        addressBook.find(""); // empty string should return empty list

    assertEquals(2, foundEntriesFullLastName.size());
    assertEquals(2, foundEntriesPartialLastName.size());
    assertEquals(0, foundEntriesNonsenseLastName.size());
    assertEquals(0, foundEntriesEmptyLastName.size());
  }

  /** Tests that finding {@link AddressEntry}s is case-insensitive */
  @Test
  public void testFindCaseInsensitive() {
    AddressBook addressBook = new AddressBook();
    addressBook.add(johnDoe);
    addressBook.add(janeDoe);

    ArrayList<AddressEntry> foundEntries = addressBook.find("DOE");
    ArrayList<AddressEntry> foundEntries2 = addressBook.find("DoE");
    ArrayList<AddressEntry> foundEntries3 = addressBook.find("dOe");
    ArrayList<AddressEntry> foundEntries4 = addressBook.find("dOE");

    assertEquals(2, foundEntries.size());
    assertEquals(2, foundEntries2.size());
    assertEquals(2, foundEntries3.size());
    assertEquals(2, foundEntries4.size());
  }

  /** Tests that address listing works and contains the address entry information */
  @Test
  public void testListing() {
    AddressBook addressBook = new AddressBook();
    addressBook.add(johnDoe);
    addressBook.add(janeDoe);

    String addressListing = addressBook.list();
    assertTrue(addressListing.contains(johnDoe.toString()));
    assertTrue(addressListing.contains(janeDoe.toString()));
  }

  /** Tests that address listing an empty address book returns an empty string */
  @Test
  public void testListingEmpty() {
    AddressBook addressBook = new AddressBook();
    assertTrue(addressBook.list().isEmpty());
  }

  /** Tests that {@link AddressBook#contains} works as intended */
  @Test
  public void testContains() {
    AddressBook addressBook = new AddressBook();
    addressBook.add(johnDoe);

    assertTrue(addressBook.contains(johnDoe));
    assertFalse(addressBook.contains(janeDoe));
  }
}
