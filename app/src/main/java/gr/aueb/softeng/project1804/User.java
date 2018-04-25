package gr.aueb.softeng.project1804;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by marios on 4/15/18.
 */

public abstract class User
{
    private String firstName, lastName, phone, email;
    private List<Address> addresses;

    public User()
    {

    }

    public User(String firstName, String lastName, String phone, String email) {
        this.addresses = new ArrayList<Address>();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Address> getAddresses()
    {
        return addresses;
    }

    public void removeAddress(Address address)
    {
        addresses.remove(address);
    }

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
