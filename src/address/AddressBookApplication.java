package address;

import address.data.AddressBook;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Application for managing an address book
 *
 * @author Poleon Banouvong
 * @since 2024-01-25
 */
public class AddressBookApplication {
  /**
   * Application runner
   *
   * @param args Command-line arguments to the application
   */
  public static void main(String[] args) {
    Scanner inputScanner = new Scanner(System.in);
    AddressBook addressBook = AddressBook.getAddressBook();
    char actionCharacter = 0;

    while (actionCharacter != 'f') {
      Menu.displayMenu();
      System.out.print("\nPlease make a selection: ");

      try {
        String nextLine = inputScanner.nextLine();

        if (nextLine.length() == 1) {
          actionCharacter = nextLine.charAt(0);
        } else {
          actionCharacter = 0;
        }
      } catch (InputMismatchException ignored) {
        actionCharacter = 0;
      }

      switch (actionCharacter) {
        case 'a': // read from file
          Menu.promptAddEntriesFromFile(inputScanner, addressBook);
          break;
        case 'b': // new address entry
          Menu.promptAddEntry(inputScanner, addressBook);
          break;
        case 'c': // remove address entry
          Menu.promptRemoveEntry(inputScanner, addressBook);
          break;
        case 'd': // find address entries
          Menu.promptFindEntries(inputScanner, addressBook);
          break;
        case 'e': // list address entries
          System.out.println('\n' + addressBook.list());
          break;
        case 'f': // exit
          System.out.println("Exiting...");
          break;
        default: // invalid selection
          System.out.println("Please make a valid selection!");
          break;
      }

      System.out.println();
    }

    inputScanner.close();
  }
}
