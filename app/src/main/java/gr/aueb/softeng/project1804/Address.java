package gr.aueb.softeng.project1804;

/**
 * Created by marios on 4/15/18.
 */

public class Address
{
    private String street, postalCode;
    private int number;

    public Address(String street, String postalCode, int number)
    {
        this.street = street;
        this.postalCode = postalCode;
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (number != address.number) return false;

        if (street != null && !street.equals(address.street))
            return false;
        else if (street == null &&  address.street != null)
            return false;

        if (postalCode != null && !postalCode.equals(address.postalCode))
            return false;
        else if (postalCode == null &&  address.postalCode != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + number;
        return result;
    }
}
