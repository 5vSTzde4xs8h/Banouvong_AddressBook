package address.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * AddressEntry class unit tests
 *
 * @author Poleon Banouvong
 * @since 2024-02-13
 */
class AddressEntryTest {
  /**
   * Tests that {@link AddressEntry#setFirstName setFirstName} and {@link AddressEntry#getFirstName
   * getFirstName} work as expected
   */
  @Test
  public void testFirstName() {
    AddressEntry entry = new AddressEntry();
    entry.setFirstName("John");

    assertEquals("John", entry.getFirstName());
  }

  /**
   * Tests that {@link AddressEntry#setLastName setLastName} and {@link AddressEntry#getLastName
   * getLastName} work as expected
   */
  @Test
  public void testLastName() {
    AddressEntry entry = new AddressEntry();
    entry.setLastName("Doe");

    assertEquals("Doe", entry.getLastName());
  }

  /**
   * Test that {@link AddressEntry#setStreet setStreet} and {@link AddressEntry#getStreet getStreet}
   * work as expected
   */
  @Test
  public void testStreet() {
    AddressEntry entry = new AddressEntry();
    entry.setStreet("1234 Main Street");

    assertEquals("1234 Main Street", entry.getStreet());
  }

  /**
   * Test that {@link AddressEntry#setCity setCity} and {@link AddressEntry#getCity getCity} work as
   * expected
   */
  @Test
  public void testCity() {
    AddressEntry entry = new AddressEntry();
    entry.setCity("Maintown");

    assertEquals("Maintown", entry.getCity());
  }

  @Test
  public void testState() {
    AddressEntry entry = new AddressEntry();
    entry.setState("Mainstate");

    assertEquals("Mainstate", entry.getState());
  }

  /**
   * Test that {@link AddressEntry#setZip setZip} and {@link AddressEntry#getZip getZip} work as
   * expected
   */
  @Test
  public void testZip() {
    AddressEntry entry = new AddressEntry();
    entry.setZip(12345);

    assertEquals(12345, entry.getZip());
  }

  /**
   * Test that {@link AddressEntry#setPhone setPhone} and {@link AddressEntry#getPhone getPhone}
   * work as expected
   */
  @Test
  public void testPhone() {
    AddressEntry entry = new AddressEntry();
    entry.setPhone("1234567890");

    assertEquals("1234567890", entry.getPhone());
  }

  /**
   * Test that {@link AddressEntry#setEmail setEmail} and {@link AddressEntry#getEmail getEmail}
   * work as expected
   */
  @Test
  public void testEmail() {
    AddressEntry entry = new AddressEntry();
    entry.setEmail("johndoe@example.com");

    assertEquals("johndoe@example.com", entry.getEmail());
  }

  /** Tests that the {@link AddressEntry} constructors work as expected */
  @Test
  public void testConstructor() {
    AddressEntry entry =
        new AddressEntry(
            "John",
            "Doe",
            "1234 Main Street",
            "Maintown",
            "Mainstate",
            12345,
            "1234567890",
            "johndoe@example.com");

    AddressEntry entry2 =
        new AddressEntry(
            "Jane",
            "Doe",
            "5678 Main Street",
            "Maintown",
            "Mainstate",
            12345,
            "0987654321",
            "janedoe@example.com");

    AddressEntry entry3 = new AddressEntry();

    assertEquals("John", entry.getFirstName());
    assertEquals("Doe", entry.getLastName());
    assertEquals("1234 Main Street", entry.getStreet());
    assertEquals("Maintown", entry.getCity());
    assertEquals("Mainstate", entry.getState());
    assertEquals(12345, entry.getZip());
    assertEquals("1234567890", entry.getPhone());
    assertEquals("johndoe@example.com", entry.getEmail());

    assertEquals("Jane", entry2.getFirstName());
    assertEquals("Doe", entry2.getLastName());
    assertEquals("5678 Main Street", entry2.getStreet());
    assertEquals("Maintown", entry2.getCity());
    assertEquals("Mainstate", entry2.getState());
    assertEquals(12345, entry2.getZip());
    assertEquals("0987654321", entry2.getPhone());
    assertEquals("janedoe@example.com", entry2.getEmail());

    assertEquals("", entry3.getFirstName());
    assertEquals("", entry3.getLastName());
    assertEquals("", entry3.getStreet());
    assertEquals("", entry3.getCity());
    assertEquals("", entry3.getState());
    assertEquals(0, entry3.getZip());
    assertEquals("", entry3.getPhone());
    assertEquals("", entry3.getEmail());
  }

  /**
   * Tests that {@link AddressEntry#toString toString} contains all the address entry's information
   */
  @Test
  public void testToString() {
    String entryString =
        new AddressEntry(
                "John",
                "Doe",
                "1234 Main Street",
                "Maintown",
                "Mainstate",
                12345,
                "1234567890",
                "johndoe@example.com")
            .toString();

    String entry2String =
        new AddressEntry(
                "Jane",
                "Doe",
                "5678 Main Street",
                "Maintown",
                "Mainstate",
                12345,
                "0987654321",
                "janedoe@example.com")
            .toString();

    assertTrue(entryString.contains("John Doe")); // first and last name should be on one line
    assertTrue(entryString.contains("1234 Main Street"));
    assertTrue(entryString.contains("Maintown"));
    assertTrue(entryString.contains("Mainstate"));
    assertTrue(entryString.contains("12345"));
    assertTrue(entryString.contains("1234567890"));
    assertTrue(entryString.contains("johndoe@example.com"));

    assertTrue(entry2String.contains("Jane Doe")); // first and last name should be on one line
    assertTrue(entry2String.contains("5678 Main Street"));
    assertTrue(entry2String.contains("Maintown"));
    assertTrue(entry2String.contains("Mainstate"));
    assertTrue(entry2String.contains("12345"));
    assertTrue(entry2String.contains("0987654321"));
    assertTrue(entry2String.contains("janedoe@example.com"));
  }

  /** Tests the hash codes of address entries */
  @Test
  public void testHashCode() {
    AddressEntry entry =
        new AddressEntry(
            "John",
            "Doe",
            "1234 Main Street",
            "Maintown",
            "Mainstate",
            12345,
            "1234567890",
            "johndoe@example.com");

    assertEquals("johndoe".hashCode(), entry.hashCode());
  }

  /** Tests that hash code calculation uses case-normalised names */
  @Test
  public void testHashCodeCaseInsensitive() {
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

    AddressEntry johnDoe2 =
        new AddressEntry(
            "jOhN",
            "dOE",
            "1234 Main Street",
            "Maintown",
            "Mainstate",
            12345,
            "1234567890",
            "johndoe@example.com");

    assertEquals(johnDoe.hashCode(), johnDoe2.hashCode());
  }

  /** Tests that two address entries are equal */
  @Test
  public void testEquals() {
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

    AddressEntry johnDoe2 =
        new AddressEntry(
            "jOhN",
            "dOE",
            "1234 Main Street",
            "Maintown",
            "Mainstate",
            12345,
            "1234567890",
            "johndoe@example.com");

    assertTrue(johnDoe.equals(johnDoe2));
  }

  /** Tests that comparing an address entry to null will not be true */
  @Test
  public void testEqualsNull() {
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

    assertFalse(johnDoe.equals(null));
  }

  /** Tests the comparison of 2 address entries that should be equal (0) */
  @Test
  public void testCompareEquals() {
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

    AddressEntry johnDoe2 =
        new AddressEntry(
            "jOhN",
            "dOE",
            "1234 Main Street",
            "Maintown",
            "Mainstate",
            12345,
            "1234567890",
            "johndoe2@example.com");

    assertEquals(0, johnDoe.compareTo(johnDoe2));
  }

  /** Tests the comparison of 2 address entries where entry1 comes before entry2 (&lt;0) */
  @Test
  public void testCompareLessThan() {
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

    AddressEntry janeSmith =
        new AddressEntry(
            "Jane",
            "Smith",
            "9012 Main Street",
            "Maintown",
            "Mainstate",
            12345,
            "2468013579",
            "janesmith@example.com");

    assertTrue(johnDoe.compareTo(janeSmith) < 0);
  }

  /** Tests the comparison of 2 address entries where entry2 comes before entry1 (&gt;0) */
  @Test
  public void testCompareGreaterThan() {
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

    AddressEntry janeSmith =
        new AddressEntry(
            "Jane",
            "Smith",
            "9012 Main Street",
            "Maintown",
            "Mainstate",
            12345,
            "2468013579",
            "janesmith@example.com");

    assertTrue(janeSmith.compareTo(johnDoe) > 0);
  }
}
