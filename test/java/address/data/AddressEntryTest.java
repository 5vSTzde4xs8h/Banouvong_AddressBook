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
  void testFirstName() {
    AddressEntry entry = new AddressEntry();
    entry.setFirstName("John");

    assertEquals("John", entry.getFirstName());
  }

  /**
   * Tests that {@link AddressEntry#setLastName setLastName} and {@link AddressEntry#getLastName
   * getLastName} work as expected
   */
  @Test
  void testLastName() {
    AddressEntry entry = new AddressEntry();
    entry.setLastName("Doe");

    assertEquals("Doe", entry.getLastName());
  }

  /**
   * Test that {@link AddressEntry#setStreet setStreet} and {@link AddressEntry#getStreet getStreet}
   * work as expected
   */
  @Test
  void testStreet() {
    AddressEntry entry = new AddressEntry();
    entry.setStreet("1234 Main Street");

    assertEquals("1234 Main Street", entry.getStreet());
  }

  /**
   * Test that {@link AddressEntry#setCity setCity} and {@link AddressEntry#getCity getCity} work as
   * expected
   */
  @Test
  void testCity() {
    AddressEntry entry = new AddressEntry();
    entry.setCity("Maintown");

    assertEquals("Maintown", entry.getCity());
  }

  /**
   * Test that {@link AddressEntry#setZip setZip} and {@link AddressEntry#getZip getZip} work as
   * expected
   */
  @Test
  void testZip() {
    AddressEntry entry = new AddressEntry();
    entry.setZip(12345);

    assertEquals(12345, entry.getZip());
  }

  /**
   * Test that {@link AddressEntry#setPhone setPhone} and {@link AddressEntry#getPhone getPhone}
   * work as expected
   */
  @Test
  void testPhone() {
    AddressEntry entry = new AddressEntry();
    entry.setPhone("1234567890");

    assertEquals("1234567890", entry.getPhone());
  }

  /**
   * Test that {@link AddressEntry#setEmail setEmail} and {@link AddressEntry#getEmail getEmail}
   * work as expected
   */
  @Test
  void testEmail() {
    AddressEntry entry = new AddressEntry();
    entry.setEmail("john@example.com");

    assertEquals("john@example.com", entry.getEmail());
  }

  /**
   * Tests that the {@link AddressEntry#AddressEntry(String, String, String, String, Integer,
   * String, String) qualified constructor} works as expected
   */
  @Test
  void testConstructor() {
    AddressEntry entry =
        new AddressEntry(
            "John", "Doe", "1234 Main Street", "Maintown", 12345, "1234567890", "john@example.com");

    AddressEntry entry2 =
        new AddressEntry(
            "Jane", "Doe", "5678 Main Street", "Maintown", 12345, "0987654321", "jane@example.com");

    assertEquals("John", entry.getFirstName());
    assertEquals("Doe", entry.getLastName());
    assertEquals("1234 Main Street", entry.getStreet());
    assertEquals("Maintown", entry.getCity());
    assertEquals(12345, entry.getZip());
    assertEquals("1234567890", entry.getPhone());
    assertEquals("john@example.com", entry.getEmail());

    assertEquals("Jane", entry2.getFirstName());
    assertEquals("Doe", entry2.getLastName());
    assertEquals("5678 Main Street", entry2.getStreet());
    assertEquals("Maintown", entry2.getCity());
    assertEquals(12345, entry2.getZip());
    assertEquals("0987654321", entry2.getPhone());
    assertEquals("jane@example.com", entry2.getEmail());
  }

  /**
   * Tests that {@link AddressEntry#toString toString} contains all the address entry's information
   */
  @Test
  void testToString() {
    String entryString =
        new AddressEntry(
                "John",
                "Doe",
                "1234 Main Street",
                "Maintown",
                12345,
                "1234567890",
                "john@example.com")
            .toString();

    String entry2String =
        new AddressEntry(
                "Jane",
                "Doe",
                "5678 Main Street",
                "Maintown",
                12345,
                "0987654321",
                "jane@example.com")
            .toString();

    assertTrue(entryString.contains("John Doe")); // first and last name should be on one line
    assertTrue(entryString.contains("1234 Main Street"));
    assertTrue(entryString.contains("Maintown"));
    assertTrue(entryString.contains("12345"));
    assertTrue(entryString.contains("1234567890"));
    assertTrue(entryString.contains("john@example.com"));

    assertTrue(entry2String.contains("Jane Doe")); // first and last name should be on one line
    assertTrue(entry2String.contains("5678 Main Street"));
    assertTrue(entry2String.contains("Maintown"));
    assertTrue(entry2String.contains("12345"));
    assertTrue(entry2String.contains("0987654321"));
    assertTrue(entry2String.contains("jane@example.com"));
  }
}
