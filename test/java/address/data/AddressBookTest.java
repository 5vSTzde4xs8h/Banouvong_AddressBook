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

  /** Address entry for a second but distinct John Doe */
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
    fail("Not implemented");
  }

  /**
   * Tests that reading entries from a malformed file will add as many entries as possible up to the
   * first malformed entry
   */
  @Test
  public void testReadMalformedFile() {
    fail("Not implemented");
  }

  /** Tests that reading from an empty file adds no entries */
  @Test
  public void testReadEmptyFile() {
    fail("Not implemented");
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

  /** Tests that finding {@link AddressEntry}s by last name works */
  @Test
  public void testFind() {
    AddressBook addressBook = new AddressBook();
    addressBook.add(johnDoe);
    addressBook.add(janeDoe);

    ArrayList<AddressEntry> foundEntriesFullLastName =
        addressBook.findEntriesWithLastNameStartingWith("Doe");
    ArrayList<AddressEntry> foundEntriesPartialLastName =
        addressBook.findEntriesWithLastNameStartingWith("D");

    assertEquals(2, foundEntriesFullLastName.size());
    assertEquals(2, foundEntriesPartialLastName.size());
  }

  /** Tests that finding {@link AddressEntry}s is case-insensitive */
  @Test
  public void testFindCaseInsensitive() {
    AddressBook addressBook = new AddressBook();
    addressBook.add(johnDoe);
    addressBook.add(janeDoe);

    ArrayList<AddressEntry> foundEntries = addressBook.findEntriesWithLastNameStartingWith("DOE");
    ArrayList<AddressEntry> foundEntries2 = addressBook.findEntriesWithLastNameStartingWith("DoE");
    ArrayList<AddressEntry> foundEntries3 = addressBook.findEntriesWithLastNameStartingWith("dOe");
    ArrayList<AddressEntry> foundEntries4 = addressBook.findEntriesWithLastNameStartingWith("dOE");

    assertEquals(2, foundEntries.size());
    assertEquals(2, foundEntries2.size());
    assertEquals(2, foundEntries3.size());
    assertEquals(2, foundEntries4.size());
  }

  /** Tests that address listing works */
  @Test
  public void testListing() {
    AddressBook addressBook = new AddressBook();
    addressBook.add(johnDoe);
    addressBook.add(janeDoe);

    String addressListing = addressBook.getListing();
    assertTrue(addressListing.contains(johnDoe.toString()));
    assertTrue(addressListing.contains(janeDoe.toString()));
  }

  /** Tests that address listing an empty address book returns an empty string */
  @Test
  public void testListingEmpty() {
    AddressBook addressBook = new AddressBook();
    assertEquals("", addressBook.getListing());
  }
}
