/**
 * Scouter is a type of scout that inherits the parameters from the Scout class
 */

import java.util.ArrayList;

public class Scouter extends Scout{
    //-----------------------//
    //-------Attributes------//
    //-----------------------//
    private String dateOfVetting;

    /**
     * The Scouter method builds a scouter using the attributes from the Scout class
     * @param name Name of Scout
     * @param county The County the Scout is from
     * @param dateOfBirth  Scout's DOB
     * @param address Scout's Address
     * @param phoneNumber Scout's phone number
     * @param specialInterests Scouts Special Interests which are handled in the SpecialInterest class
     * @param dateOfVetting The date that the Scouter was garda vetted
     */

    //-----------------------//
    //--------Methods--------//
    //-----------------------//
    public Scouter(String name, String county, String dateOfBirth, String address, String phoneNumber, ArrayList<SpecialInterest> specialInterests, String dateOfVetting) {
        super(name, county, dateOfBirth, address, phoneNumber, specialInterests);
        this.dateOfVetting = dateOfVetting;
    }

    //------------------------//
    //---------Getters--------//
    //------------------------//
    public String getDateOfVetting() {
        return dateOfVetting;
    }

    //------------------------//
    //---------Setters--------//
    //------------------------//
    public void setDateOfVetting(String dateOfVetting) {
        this.dateOfVetting = dateOfVetting;
    }

    /**
     * The calcMembership method used in the calcRegistrationFee method
     * @return the value 10 which is the cost of insurance
     */
    @Override
    public double calcMembership() {
        return 10;
    }

    /**
     * The toString() method that is used for the listOfScouts variable
     */
    @Override
    public String toString() {
        return "Scouter Name: " + super.getName()  +
                ", County: " + super.getCounty()  +
                ", Date of Birth: " + super.getDateOfBirth()  +
                ", Address: " + super.getAddress() +
                ", Contact Number: " + super.getPhoneNumber()  +
                ", Special Interests: " + super.getSpecialInterests() +
                ", Date of Garda Vetting: " + dateOfVetting;
    }
}
