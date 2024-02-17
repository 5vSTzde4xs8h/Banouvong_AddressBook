package address.data;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Holds a list of address entries
 *
 * @author Poleon Banouvong
 * @since 2024-01-25
 */
public class AddressBook {
  private final TreeSet<AddressEntry> addressEntryList;

  /** Creates a new address book */
  public AddressBook() {
    addressEntryList = new TreeSet<AddressEntry>();
  }

  /**
   * Adds an address entry to the address book
   *
   * @param addressEntry The address entry to add
   * @return {@code true} if the address entry was not already in the address book
   */
  public boolean add(AddressEntry addressEntry) {
    return addressEntryList.add(addressEntry);
  }

  /**
   * Removes an address entry from the address book
   *
   * @param addressEntry The address entry to remove
   * @return {@code true} if the address entry was in the address book
   */
  public boolean remove(AddressEntry addressEntry) {
    return addressEntryList.remove(addressEntry);
  }

  /** Prints out all address book entries */
  public String getListing() {
    int addressNum = 1;
    String listing = "";

    for (AddressEntry addressEntry : addressEntryList) {
      listing += (addressNum + ": " + addressEntry.toString() + '\n');
      addressNum++;
    }

    return listing;
  }

  /**
   * TODO: Implement addEntriesFromFile
   * Adds and returns a list of address entries read from a file
   *
   * @param fileName The file to read address entries from
   * @return An {@link ArrayList} containing the added entries
   */
  public ArrayList<AddressEntry> addEntriesFromFile(String fileName) {
    ArrayList<AddressEntry> addressEntries = new ArrayList<AddressEntry>();
    return addressEntries;
  }

  /**
   * TODO: Implement findEntriesWithLastNameStartingWith
   * Returns a list of address entries whose last name starts with a prefix
   *
   * @param prefix The prefix to match last names against
   * @return An {@link ArrayList} containing the matching entries
   */
  public ArrayList<AddressEntry> findEntriesWithLastNameStartingWith(String prefix) {
    ArrayList<AddressEntry> addressEntries = new ArrayList<AddressEntry>();
    return addressEntries;
  }
}
