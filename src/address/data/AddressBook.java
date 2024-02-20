package address.data;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Holds a list of address entries
 *
 * @author Poleon Banouvong
 * @since 2024-01-25
 */
public class AddressBook {
  /** The address entry list */
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

  /**
   * Returns if an address entry is in the address book
   *
   * @param addressEntry The address entry to check
   * @return {@code true} if the address entry is in the address book
   */
  public boolean contains(AddressEntry addressEntry) {
    return addressEntryList.contains(addressEntry);
  }

  /** Prints out all address book entries */
  public String list() {
    int addressNumber = 1;
    String listing = "";

    for (AddressEntry addressEntry : addressEntryList) {
      listing +=
          (addressNumber
              + ": "
              + addressEntry.toString()
              + ((addressEntry != addressEntryList.getLast()) ? "\n\n" : ""));

      addressNumber++;
    }

    return listing;
  }

  /**
   * Adds and returns a list of address entries read from a file
   *
   * @param fileName The file to read address entries from
   * @return An {@link ArrayList} containing the added entries
   */
  public ArrayList<AddressEntry> readFromFile(String fileName) {
    if (fileName.isBlank()) {
      return new ArrayList<AddressEntry>();
    }

    ArrayList<AddressEntry> addressEntries = new ArrayList<AddressEntry>();
    FileReader fileReader;
    BufferedReader bufferedFileReader;

    try {
      fileReader = new FileReader(fileName);
      bufferedFileReader = new BufferedReader(fileReader);

      AddressEntry nextEntry = new AddressEntry();
      int addressEntryFieldNumber = 0;
      boolean malformedEntry = false;
      String addressFieldLine;

      while (bufferedFileReader.ready()) {
        addressFieldLine = bufferedFileReader.readLine();

        if (!addressFieldLine.isBlank()) {
          switch (addressEntryFieldNumber) {
            case 0: // first name
              nextEntry.setFirstName(addressFieldLine);
              break;
            case 1: // last name
              nextEntry.setLastName(addressFieldLine);
              break;
            case 2: // street
              nextEntry.setStreet(addressFieldLine);
              break;
            case 3: // city
              nextEntry.setCity(addressFieldLine);
              break;
            case 4: // state
              nextEntry.setState(addressFieldLine);
              break;
            case 5: // zip code
              try {
                int zip = Integer.parseInt(addressFieldLine);
                nextEntry.setZip(zip);
              } catch (NumberFormatException exception) {
                malformedEntry = true;
              }

              break;
            case 6: // phone
              nextEntry.setPhone(addressFieldLine);
              break;
            case 7: // email
              nextEntry.setEmail(addressFieldLine);
              break;
            default: // unknown field number
              break;
          }

          if (malformedEntry) {
            bufferedFileReader.close();
            return addressEntries;
          }

          if (addressEntryFieldNumber == 7) {
            // 7 is the last field number
            boolean entryWasAdded = addressEntryList.add(nextEntry);

            if (entryWasAdded) {
              addressEntries.add(nextEntry);
            }

            nextEntry = new AddressEntry();
            addressEntryFieldNumber = 0;
          } else {
            addressEntryFieldNumber++;
          }
        }
      }
    } catch (IOException exception) {
      return new ArrayList<AddressEntry>();
    }

    return addressEntries;
  }

  /**
   * Returns a list of address entries whose last name starts with the provided string
   *
   * @param startOfLastName The prefix to match last names against
   * @return An {@link ArrayList} containing the matching entries
   */
  public ArrayList<AddressEntry> find(String startOfLastName) {
    startOfLastName = startOfLastName.toLowerCase().trim();

    if (startOfLastName.isEmpty()) {
      return new ArrayList<AddressEntry>();
    }

    ArrayList<AddressEntry> addressEntries = new ArrayList<AddressEntry>();

    for (AddressEntry addressEntry : addressEntryList) {
      String lastNameLower = addressEntry.getLastName().toLowerCase();

      if (lastNameLower.startsWith(startOfLastName)) {
        addressEntries.add(addressEntry);
      }
    }

    return addressEntries;
  }
}
