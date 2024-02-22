package address;

import address.data.AddressBook;
import address.data.AddressEntry;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Menu has a number of static prompt methods that will ask the user for details about a new person
 * for use in an address book.
 *
 * @author Poleon Banouvong
 * @since 2024-01-25
 */
public class Menu {
  /** Empty constructor explicitly private-protected to prevent creation of Menu instances */
  private Menu() {}

  /** Outputs a menu for interacting with the address book */
  public static void displayMenu() {
    System.out.print(
        """
        ################
        Address Book Menu
        a) Load address entries from file
        b) Add an address entry
        c) Remove an address entry
        d) Find address entries
        e) Address book listing
        f) Quit
        ################
        """);
  }

  /**
   * Generic method for prompting and capturing input. This method will re-prompt the user if they
   * input a line containing only whitespace.
   *
   * @param promptText The text to present to the user
   * @return The text input by the user
   */
  public static String promptInput(String promptText) {
    Scanner scanner = new Scanner(System.in);
    String input = null;

    while (input == null) {
      System.out.print(promptText + ": ");
      input = scanner.nextLine().trim();

      if (input.isEmpty()) {
        System.out.println("Invalid input, please try again!");
        input = null;
      }
    }

    scanner.close();
    return input;
  }

  /**
   * Generic method for prompting and capturing an integer. This method will re-prompt the user if
   * they input a line containing only whitespace.
   *
   * @param promptText The text to present to the user
   * @return The integer input by the user
   */
  public static int promptInteger(String promptText) {
    Scanner scanner = new Scanner(System.in);
    Integer input = null;

    while (input == null) {
      System.out.print(promptText + ": ");

      try {
        input = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException ignored) {
        System.out.println("Invalid input, please try again!");
      }
    }

    scanner.close();
    return input;
  }

  /**
   * Prompts the user for a first name
   *
   * @return The first name entered by the user
   */
  public static String prompt_FirstName() {
    return promptInput("First name");
  }

  /**
   * Prompts the user for a last name
   *
   * @return The last name entered by the user
   */
  public static String prompt_LastName() {
    return promptInput("Last name");
  }

  /**
   * Prompts the user for a street
   *
   * @return The street entered by the user
   */
  public static String prompt_Street() {
    return promptInput("Street");
  }

  /**
   * Prompt the user for a city
   *
   * @return The city entered by the user
   */
  public static String prompt_City() {
    return promptInput("City");
  }

  /**
   * Prompt the user for a state
   *
   * @return The state entered by the user
   */
  public static String prompt_State() {
    return promptInput("State");
  }

  /**
   * Prompt the user for a ZIP code
   *
   * @return The ZIP code entered by the user
   */
  public static int prompt_Zip() {
    return promptInteger("ZIP code");
  }

  /**
   * Prompt the user for a phone number
   *
   * @return The phone number entered by the user
   */
  public static String prompt_Phone() {
    return promptInput("Phone number");
  }

  /**
   * Prompt the user for an e-mail address
   *
   * @return The e-mail address entered by the user
   */
  public static String prompt_Email() {
    return promptInput("Email");
  }

  /**
   * Prompt the user to add address entries from a file
   *
   * @param addressBook The address book to add entries to
   */
  public static void promptAddEntriesFromFile(AddressBook addressBook) {
    String fileName = Menu.promptInput("File name");

    ArrayList<AddressEntry> addedEntries = addressBook.readFromFile(fileName);
    int numberOfAddedEntries = addedEntries.size();

    if (numberOfAddedEntries != 0) {
      System.out.printf(
          "Added %d %s:\n\n",
          numberOfAddedEntries, (numberOfAddedEntries == 1) ? "entry" : "entries");

      for (AddressEntry entry : addedEntries) {
        System.out.println(entry.toString() + ((entry != addedEntries.getLast()) ? '\n' : ""));
      }
    } else {
      System.out.println(
          "No entries were added. "
              + "This may be because the file doesn't exist, "
              + "the file has invalid address entries, "
              + "the file has duplicate address entries, "
              + "or the file was empty.");
    }
  }

  /**
   * Prompt the user to manually add an entry
   *
   * @param addressBook The address book to add the entry to
   */
  public static void promptAddEntry(AddressBook addressBook) {
    String firstName = Menu.prompt_FirstName();
    String lastName = Menu.prompt_LastName();
    String street = Menu.prompt_Street();
    String city = Menu.prompt_City();
    String state = Menu.prompt_State();
    int zip = Menu.prompt_Zip();
    String phone = Menu.prompt_Phone();
    String email = Menu.prompt_Email();

    AddressEntry newEntry =
        new AddressEntry(firstName, lastName, street, city, state, zip, phone, email);

    if (addressBook.add(newEntry)) {
      System.out.println("Successfully added entry");
    } else {
      System.out.println("Could not add entry; this may be a duplicate entry.");
    }
  }

  /**
   * Prompts the user to remove an entry
   *
   * @param addressBook The address book to remove the entry from
   */
  public static void promptRemoveEntry(AddressBook addressBook) {
    String startOfLastName = Menu.promptInput("Last name starts with");
    ArrayList<AddressEntry> matchingEntries = addressBook.find(startOfLastName);
    int numberOfMatchingEntries = matchingEntries.size();

    switch (numberOfMatchingEntries) {
      case 0: // no matching entries
        System.out.println("No entries found");
        break;
      case 1: // 1 matching entry
        AddressEntry firstEntry = matchingEntries.getFirst();

        if (addressBook.remove(firstEntry)) {
          System.out.println("Removed the following entry (the only matching entry):\n");
          System.out.println(firstEntry.toString());
        } else {
          System.out.println("Could not remove entry");
        }

        break;
      default: // more than one matching entry
        int entryNumber = 1;
        System.out.println("Found multiple entries:\n");

        for (AddressEntry entry : matchingEntries) {
          System.out.println(entryNumber + ": " + entry.toString() + '\n');
          entryNumber++;
        }

        int indexPlusOne = Menu.promptInteger("Please select an entry");

        while ((indexPlusOne < 1) || (indexPlusOne > matchingEntries.size())) {
          System.out.println("Invalid input, please try again!");
          indexPlusOne = Menu.promptInteger("Please select an entry to remove");
        }

        AddressEntry selectedEntry = matchingEntries.get(indexPlusOne - 1);

        if (addressBook.remove(selectedEntry)) {
          System.out.printf(
              "Removed entry %d (%s %s)\n",
              indexPlusOne, selectedEntry.getFirstName(), selectedEntry.getLastName());
        } else {
          System.out.printf("Could not remove entry %d\n", indexPlusOne);
        }
    }
  }

  /**
   * Prompts the user to find entries
   *
   * @param addressBook The address book to find entries in
   */
  public static void promptFindEntries(AddressBook addressBook) {
    String startOfLastName = Menu.promptInput("Last name starts with");
    ArrayList<AddressEntry> matchingEntries = addressBook.find(startOfLastName);

    if (matchingEntries.isEmpty()) {
      System.out.println("There are no matching entries");
    } else {
      int entryNumber = 1;
      System.out.println("Found the following entries:\n");

      for (AddressEntry entry : matchingEntries) {
        System.out.println(
            entryNumber
                + ": "
                + entry.toString()
                + ((entry != matchingEntries.getLast()) ? '\n' : ""));

        entryNumber++;
      }
    }
  }
}
