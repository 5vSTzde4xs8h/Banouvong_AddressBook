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
   * @param inputScanner The Scanner to read input from
   * @param promptText The text to present to the user
   * @return The text input by the user
   */
  public static String promptInput(Scanner inputScanner, String promptText) {
    String input = null;

    while (input == null) {
      System.out.print(promptText + ": ");
      input = inputScanner.nextLine().trim();

      if (input.isEmpty()) {
        System.out.println("Invalid input, please try again!");
        input = null;
      }
    }

    return input;
  }

  /**
   * Generic method for prompting and capturing an integer. This method will re-prompt the user if
   * they input a line containing only whitespace.
   *
   * @param inputScanner The Scanner to read input from
   * @param promptText The text to present to the user
   * @return The integer input by the user
   */
  public static int promptInteger(Scanner inputScanner, String promptText) {
    Integer input = null;

    while (input == null) {
      System.out.print(promptText + ": ");

      try {
        input = Integer.parseInt(inputScanner.nextLine());
      } catch (NumberFormatException ignored) {
        System.out.println("Invalid input, please try again!");
      }
    }

    return input;
  }

  /**
   * Prompts the user for a first name
   *
   * @param inputScanner The Scanner to read input from
   * @return The first name entered by the user
   */
  public static String prompt_FirstName(Scanner inputScanner) {
    return promptInput(inputScanner, "First name");
  }

  /**
   * Prompts the user for a last name
   *
   * @param inputScanner The Scanner to read input from
   * @return The last name entered by the user
   */
  public static String prompt_LastName(Scanner inputScanner) {
    return promptInput(inputScanner, "Last name");
  }

  /**
   * Prompts the user for a street
   *
   * @param inputScanner The Scanner to read input from
   * @return The street entered by the user
   */
  public static String prompt_Street(Scanner inputScanner) {
    return promptInput(inputScanner, "Street");
  }

  /**
   * Prompt the user for a city
   *
   * @param inputScanner The Scanner to read input from
   * @return The city entered by the user
   */
  public static String prompt_City(Scanner inputScanner) {
    return promptInput(inputScanner, "City");
  }

  /**
   * Prompt the user for a state
   *
   * @param inputScanner The Scanner to read input from
   * @return The state entered by the user
   */
  public static String prompt_State(Scanner inputScanner) {
    return promptInput(inputScanner, "State");
  }

  /**
   * Prompt the user for a ZIP code
   *
   * @param inputScanner The Scanner to read input from
   * @return The ZIP code entered by the user
   */
  public static int prompt_Zip(Scanner inputScanner) {
    return promptInteger(inputScanner, "ZIP code");
  }

  /**
   * Prompt the user for a phone number
   *
   * @param inputScanner The Scanner to read input from
   * @return The phone number entered by the user
   */
  public static String prompt_Phone(Scanner inputScanner) {
    return promptInput(inputScanner, "Phone number");
  }

  /**
   * Prompt the user for an e-mail address
   *
   * @param inputScanner The Scanner to read input from
   * @return The e-mail address entered by the user
   */
  public static String prompt_Email(Scanner inputScanner) {
    return promptInput(inputScanner, "Email");
  }

  /**
   * Prompt the user to add address entries from a file
   *
   * @param inputScanner The Scanner to read input from
   * @param addressBook The address book to add entries to
   */
  public static void promptAddEntriesFromFile(Scanner inputScanner, AddressBook addressBook) {
    String fileName = Menu.promptInput(inputScanner, "File name");

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
   * @param inputScanner The Scanner to read input from
   * @param addressBook The address book to add the entry to
   */
  public static void promptAddEntry(Scanner inputScanner, AddressBook addressBook) {
    String firstName = Menu.prompt_FirstName(inputScanner);
    String lastName = Menu.prompt_LastName(inputScanner);
    String street = Menu.prompt_Street(inputScanner);
    String city = Menu.prompt_City(inputScanner);
    String state = Menu.prompt_State(inputScanner);
    int zip = Menu.prompt_Zip(inputScanner);
    String phone = Menu.prompt_Phone(inputScanner);
    String email = Menu.prompt_Email(inputScanner);

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
   * @param inputScanner The Scanner to read input from
   * @param addressBook The address book to remove the entry from
   */
  public static void promptRemoveEntry(Scanner inputScanner, AddressBook addressBook) {
    String startOfLastName = Menu.promptInput(inputScanner, "Last name starts with");
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

        int indexPlusOne = Menu.promptInteger(inputScanner, "Please select an entry to remove");

        while ((indexPlusOne < 1) || (indexPlusOne > matchingEntries.size())) {
          System.out.println("Invalid input, please try again!");
          indexPlusOne = Menu.promptInteger(inputScanner, "Please select an entry to remove");
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
   * @param inputScanner The Scanner to read input from
   * @param addressBook The address book to find entries in
   */
  public static void promptFindEntries(Scanner inputScanner, AddressBook addressBook) {
    String startOfLastName = Menu.promptInput(inputScanner, "Last name starts with");
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
