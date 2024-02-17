package address.data;

/**
 * Holds address and contact information on a person
 *
 * @author Poleon Banouvong
 * @since 2024-01-25
 */
public class AddressEntry implements Comparable<AddressEntry> {
  /** The first name of the person */
  private String firstName;

  /** The last name of the person */
  private String lastName;

  /** The street the person lives on */
  private String street;

  /** The city the person lives in */
  private String city;

  /** The ZIP code where the person lives */
  private int zip;

  /** The phone number of the person */
  private String phone;

  /** The e-mail address of the person */
  private String email;

  /** Constructs an address book entry with no prior information */
  public AddressEntry() {
    this.firstName = "";
    this.lastName = "";
    this.street = "";
    this.city = "";
    this.zip = 0;
    this.phone = "";
    this.email = "";
  }

  /**
   * Constructs an address book entry with all prior information
   *
   * @param firstName The first name of the person
   * @param lastName The last name of the person
   * @param street The street the person lives on
   * @param city The city the person lives in
   * @param zip The ZIP code where the person lives
   * @param phone The telephone number of the person
   * @param email The email address of the person
   */
  public AddressEntry(
      String firstName,
      String lastName,
      String street,
      String city,
      Integer zip,
      String phone,
      String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.street = street;
    this.city = city;
    this.zip = zip;
    this.phone = phone;
    this.email = email;
  }

  /**
   * Calculates a hash code for the address entry. Entries with the same case-normalised first and
   * last names will have the same hash code.
   *
   * @return The hash code
   */
  @Override
  public int hashCode() {
    String firstNameLower = firstName.toLowerCase();
    String lastNameLower = lastName.toLowerCase();

    return (firstNameLower + lastNameLower).hashCode();
  }

  /**
   * Checks if two objects are equal to each other.
   *
   * @param that The object to compare to
   * @return {@code false} if the object to compare to is {@code null} or their hash codes aren't
   *     equal, {@code true} otherwise
   */
  @Override
  public boolean equals(Object that) {
    if (that != null) {
      return hashCode() == that.hashCode();
    } else {
      return false;
    }
  }

  /**
   * Compares this {@link AddressEntry} to another. If the two entries have different
   * case-normalised last names, then the comparison of their case-normalised first names will be
   * returned. Otherwise, the comparison returns 0.
   *
   * @param that The {@link AddressEntry} to be compared
   * @return A negative integer, zero, or a positive integer if this object is less than, equal to,
   *     or greater than the compared object.
   */
  @Override
  public int compareTo(AddressEntry that) {
    String thisLastNameLower = lastName.toLowerCase();
    String thatLastNameLower = that.lastName.toLowerCase();

    int lastNameComparison = thisLastNameLower.compareTo(thatLastNameLower);

    if (lastNameComparison == 0) {
      String thisFirstNameLower = firstName.toLowerCase();
      String thatFirstNameLower = that.firstName.toLowerCase();

      return thisFirstNameLower.compareTo(thatFirstNameLower);
    } else {
      return lastNameComparison;
    }
  }

  /**
   * Converts the address entry into an output-friendly string
   *
   * @return The address entry's information
   */
  public String toString() {
    /* Format is:
    FirstName LastName
    Street
    City, ZIP
    Email
    Phone */
    return String.format(
        "%s %s\n%s\n%s, %d\n%s\n%s", firstName, lastName, street, city, zip, email, phone);
  }

  /**
   * @return The first name of the person
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return The last name of the person
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @return The street the person lives on
   */
  public String getStreet() {
    return street;
  }

  /**
   * @return The city the person lives in
   */
  public String getCity() {
    return city;
  }

  /**
   * @return The ZIP code where the person lives
   */
  public int getZip() {
    return zip;
  }

  /**
   * @return The phone number of the person
   */
  public String getPhone() {
    return phone;
  }

  /**
   * @return The e-mail address of the person
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the first name of the address entry
   *
   * @param firstName The first name of the person
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Sets the last name of the address entry
   *
   * @param lastName The last name of the person
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Sets the street of the address entry
   *
   * @param street The street the person lives on
   */
  public void setStreet(String street) {
    this.street = street;
  }

  /**
   * Sets the city of the address entry
   *
   * @param city The city the person lives in
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * Sets the ZIP code of the address entry
   *
   * @param zip The ZIP code where the person lives
   */
  public void setZip(int zip) {
    this.zip = zip;
  }

  /**
   * Sets the phone number of the address entry
   *
   * @param phone The phone number of the person
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Sets the e-mail of the address entry
   *
   * @param email The e-mail address of the person
   */
  public void setEmail(String email) {
    this.email = email;
  }
}
