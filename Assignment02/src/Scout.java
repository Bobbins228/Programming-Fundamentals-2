/**
 * The abstract Scout class handles the attributes that are used across the three other Scout classes
 * and implements the iScoutMember interface
 */

import java.util.ArrayList;
public abstract class Scout implements iScoutMember {
    //-----------------------//
    //-------Attributes------//
    //-----------------------//
    private String name;
    private String county;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;
    private ArrayList<SpecialInterest> specialInterests;

    /**
     * @param name Name of Scout
     * @param county The County the Scout is from
     * @param dateOfBirth  Scout's DOB
     * @param address Scout's Address
     * @param phoneNumber Scout's contact number
     * @param specialInterests Scouts Special Interests which are handled in the SpecialInterest class
     */

    //-----------------------//
    //--------Methods--------//
    //-----------------------//

    public Scout(String name, String county, String dateOfBirth, String address, String phoneNumber, ArrayList<SpecialInterest> specialInterests) {
        this.name = name;
        this.county = county;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.specialInterests = specialInterests;
    }

    //------------------------//
    //---------Getters--------//
    //------------------------//

    public String getName() {
        return name;
    }

    public String getCounty() {
        return county;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<SpecialInterest> getSpecialInterests() {
        return specialInterests;
    }
    //------------------------//
    //---------Setters--------//
    //------------------------//

    public void setName(String name) {
        this.name = name;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSpecialInterests(ArrayList<SpecialInterest> specialInterests) {
        this.specialInterests = specialInterests;
    }

    /**
     * The toString() method that is used for the listOfScouts variable
     */

    @Override
    public String toString() {
        return "Scout{" +
                "name='" + name + '\'' +
                ", county='" + county + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", specialInterests=" + specialInterests +
                '}';
    }
}
