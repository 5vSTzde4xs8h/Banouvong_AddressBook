package address;

import address.data.AddressBook;
import address.data.AddressEntry;

/**
 * Address book driver
 *
 * @author Poleon Banouvong
 * @since 2024-01-25
 * @version 1.0
 */
public class AddressBookApplication {
  /**
   * Creates two address book entries and places them into an address book
   *
   * @param ab The address book the entries will be placed in
   */
  public static void initAddressBookExercise(AddressBook ab) {
    AddressEntry ae1 =
        new AddressEntry(
            "John",
            "Doe",
            "123 Main Street",
            "Main Town",
            12345,
            "123-456-789",
            "john_doe@example.com");

    AddressEntry ae2 =
        new AddressEntry(
            "Jane",
            "Doe",
            "456 Main Street",
            "Main Town",
            12345,
            "987-654-321",
            "jane_doe@example.com");

    // add entries
    ab.add(ae1);
    ab.add(ae2);

    ab.list(); // print out the address book
  }

  public static void main(String[] args) {
    AddressBook addressBook = new AddressBook();
    initAddressBookExercise(addressBook);
  }
}
