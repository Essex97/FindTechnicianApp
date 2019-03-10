package gr.aueb.softeng.project1804.domain;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by marios on 4/15/18.
 */

public abstract class User
{
    private String firstName, lastName, phone, email;
    private List<Address> addresses;

    /**
     * The default constructor of the User class.
     */
    public User()
    {
        this.addresses = new ArrayList<Address>();
        this.firstName = null;
        this.lastName = null;
        this.phone = null;
        this.email = null;
    }

    /**
     * The constructor of the User class.
     * @param firstName The first name of the user
     * @param lastName The last name of the user.
     * @param phone The phone of the user.
     * @param email The email of the user.
     */
    public User(String firstName, String lastName, String phone, String email) {
        this.addresses = new ArrayList<Address>();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    /**
     * The getter of the first name.
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * The setter of the first name.
     * @param firstName The first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * The getter of the last name.
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * The setter of the last name.
     * @param lastName The last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * The getter of the phone.
     * @return The phone.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * The setter of the phone.
     * @param phone The phone.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * The getter of the email.
     * @return The email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * The setter of the email.
     * @param email The email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * The getter of the list with the addresses of the user.
     * @return The list that contains the list with the names.
     */
    public List<Address> getAddresses()
    {
        return addresses;
    }

    /**
     * This method removes an address from address list if exists.
     * @param address The address that is to be removed from the list.
     */
    public void removeAddress(Address address)
    {
        addresses.remove(address);
    }

    /**
     * This method addes an address to the list.
     * @param address The address that is to be added to the list.
     */
    public void addAddress(Address address)
    {
        addresses.add(address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (firstName != null && !firstName.equals(user.firstName))
            return false;
        else if (firstName == null &&  user.firstName != null)
            return false;

        if (lastName != null && !lastName.equals(user.lastName))
            return false;
        else if (lastName == null &&  user.lastName != null)
            return false;

        if (phone != null && !phone.equals(user.phone))
            return false;
        else if (phone == null &&  user.phone != null)
            return false;

        if (email != null && !email.equals(user.email))
            return false;
        else if (email == null &&  user.email != null)
            return false;

        if (addresses != null && !addresses.equals(user.addresses))
            return false;
        else if (addresses == null &&  user.addresses != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (addresses != null ? addresses.hashCode() : 0);
        return result;
    }
}
