package address;

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
        ########
        Address Book Menu
        1: Load address entries from file
        2: Add an address entry
        3: Remove an address entry
        4: Find address entries
        5: Address book listing
        6: Quit
        ########
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
    boolean alreadyPrompted = false;
    Scanner scanner = new Scanner(System.in);
    String input = null;

    while ((input == null) || (input.isEmpty())) {
      if (alreadyPrompted) {
        System.out.println("Invalid input, please try again!");
      }

      System.out.print(promptText + ": ");

      input = scanner.nextLine().trim();
      alreadyPrompted = true;
    }

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
    Scanner scanner = new Scanner(System.in);
    Integer input = null;

    while (input == null) {
      System.out.print("ZIP code: ");

      try {
        input = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException ignored) {
        System.out.println("Invalid input, please try again!");
      }
    }

    return input;
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
}
