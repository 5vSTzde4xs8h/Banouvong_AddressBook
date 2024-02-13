package address.data;

import java.util.LinkedHashSet;

/**
 * Holds a list of address entries
 *
 * @author Poleon Banouvong
 * @since 2024-01-25
 * @version 1.0
 */
public class AddressBook {
  private final LinkedHashSet<AddressEntry> addressEntryList;

  /** Creates a new address book */
  public AddressBook() {
    addressEntryList = new LinkedHashSet<AddressEntry>();
  }

  /** Prints out all address book entries */
  public void list() {
    int i = 1;

    for (AddressEntry addressEntry : addressEntryList) {
      System.out.println(i + ": " + addressEntry.toString() + '\n');
      i++;
    }
  }

  /**
   * Adds an address entry to the address book
   *
   * @param addressEntry The address entry
   */
  public void add(AddressEntry addressEntry) {
    addressEntryList.add(addressEntry);
  }
}
