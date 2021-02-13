/**
 * CubScout is a type of scout that inherits the parameters from the Scout class
 */

import java.util.ArrayList;
public class CubScout extends Scout {

    //-----------------------//
    //-------Attributes------//
    //-----------------------//
    private String cubPhoneNumber;

    /**
     * The CubScout method builds a scouter using the attributes from the Scout class
     * @param name Name of Scout
     * @param county The County the Scout is from
     * @param dateOfBirth  Scout's DOB
     * @param address Scout's Address
     * @param phoneNumber Scout's contact number
     * @param specialInterests Scouts Special Interests which are handled in the SpecialInterest class
     * @param cubPhoneNumber The Scouts phone number
     */
    //-----------------------//
    //--------Methods--------//
    //-----------------------//

    public CubScout(String name, String county, String dateOfBirth, String address, String phoneNumber, ArrayList<SpecialInterest> specialInterests,  String cubPhoneNumber) {
        super(name, county, dateOfBirth, address, phoneNumber, specialInterests);
        this.cubPhoneNumber = cubPhoneNumber;
    }

    /**
     * The calcMembership method used in the calcRegistrationFee method
     * @return the value 150 which is the cost of membership for a Cub Scout annually
     */
    @Override
    public double calcMembership() {
        return 150;
    }

    //------------------------//
    //---------Getters--------//
    //------------------------//

    public String getCubPhoneNumber() {
        return cubPhoneNumber;
    }

    //------------------------//
    //---------Setters--------//
    //------------------------//

    public void setCubPhoneNumber(String cubPhoneNumber) {
        this.cubPhoneNumber = cubPhoneNumber;
    }

    /**
     * The toString() method that is used for the listOfScouts variable
     */
    @Override
    public String toString() {
        return "Cub Scout Name: " + super.getName()  +
                ", County: " + super.getCounty()  +
                ", Date of Birth: " + super.getDateOfBirth()  +
                ", Address: " + super.getAddress() +
                ", Contact Number: " + super.getPhoneNumber()  +
                ", Special Interests: " + super.getSpecialInterests() +
                ", Cub Phone Number: " + cubPhoneNumber;
    }
}
