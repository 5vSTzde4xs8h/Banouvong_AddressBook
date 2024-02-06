package address.data;

/**
 * Holds address and contact information
 * for use in an address book
 * @author Poleon Banouvong
 * @since 2024-01-25
 * @version 1.0
 */
public class AddressEntry {
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private Integer zip;
    private String phone;
    private String email;

    /**
     * Constructs an address book entry
     * with no prior information
     */
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
     * Constructs an address book entry
     * with all prior information
     * @param firstName The first name of the person
     * @param lastName The last name of the person
     * @param street The street the person lives on
     * @param city The city the person lives in
     * @param zip The ZIP code where the person lives
     * @param phone The telephone number of the person
     * @param email The email address of the person
     */
    public AddressEntry(String firstName, String lastName, String street, String city, Integer zip, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    /**
     * Converts the address entry into an output-friendly string
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
                "%s %s\n%s\n%s, %d\n%s\n%s",
                firstName, lastName,
                street,
                city, zip,
                email,
                phone
        );
    }

    /**
     * @return The first name of the person
     */
    public String getFirstName() { return firstName; }

    /**
     * @return The last name of the person
     */
    public String getLastName() { return lastName; }

    /**
     * @return The street the person lives on
     */
    public String getStreet() { return street; }

    /**
     * @return The city the person lives in
     */
    public String getCity() { return city; }

    /**
     * @return The ZIP code where the person lives
     */
    public Integer getZip() { return zip; }

    /**
     * @return The phone number of the person
     */
    public String getPhone() { return phone; }

    /**
     * @return The e-mail address of the person
     */
    public String getEmail() { return email; }

    /**
     * Sets the first name of the address entry
     * @param firstName The first name of the person
     */
    public void setFirstName(String firstName) { this.firstName = firstName; }

    /**
     * Sets the last name of the address entry
     * @param lastName The last name of the person
     */
    public void setLastName(String lastName) { this.lastName = lastName; }

    /**
     * Sets the street of the address entry
     * @param street The street the person lives on
     */
    public void setStreet(String street) { this.street = street; }

    /**
     * Sets the city of the address entry
     * @param city The city the person lives in
     */
    public void setCity(String city) { this.city = city; }

    /**
     * Sets the ZIP code of the address entry
     * @param zip The ZIP code where the person lives
     */
    public void setZip(Integer zip) { this.zip = zip; }

    /**
     * Sets the phone number of the address entry
     * @param phone The phone number of the person
     */
    public void setPhone(String phone) { this.phone = phone; }

    /**
     * Sets the e-mail of the address entry
     * @param email The e-mail address of the person
     */
    public void setEmail(String email) { this.email = email; }
}
