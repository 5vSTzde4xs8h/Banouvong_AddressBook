package address;

/**
 * Menu has a number of static prompt methods that will ask the user for details about a new person
 * for use in an address book.
 *
 * @author Poleon Banouvong
 * @since 2024-01-25
 * @version 1.0
 */
public class Menu {
  /**
   * Prompts the user for a first name
   *
   * @return The first name entered by the user, or a default
   */
  public static String prompt_FirstName() {
    System.out.println("First name: ");
    return "Jane";
  }

  /**
   * Prompts the user for a last name
   *
   * @return The last name entered by the user, or a default
   */
  public static String prompt_LastName() {
    System.out.println("Last name: ");
    return "";
  }

  /**
   * Prompts the user for a street
   *
   * @return The street entered by the user, or a default
   */
  public static String prompt_Street() {
    System.out.println("Street: ");
    return "";
  }

  /**
   * Prompt the user for a city
   *
   * @return The city entered by the user, or a default
   */
  public static String prompt_City() {
    System.out.println("City: ");
    return "";
  }

  /**
   * Prompt the user for a state
   *
   * @return The state entered by the user, or a default
   */
  public static String prompt_State() {
    System.out.println("State: ");
    return "";
  }

  /**
   * Prompt the user for a ZIP code
   *
   * @return The ZIP code entered by the user, or a default
   */
  public static String prompt_Zip() {
    System.out.println("Zip: ");
    return "";
  }

  /**
   * Prompt the user for a telephone number
   *
   * @return The telephone number entered by the user, or a default
   */
  public static String prompt_Telephone() {
    System.out.println("Telephone: ");
    return "";
  }

  /**
   * Prompt the user for an e-mail address
   *
   * @return The e-mail address entered by the user, or a default
   */
  public static String prompt_Email() {
    System.out.println("Email: ");
    return "";
  }
}
