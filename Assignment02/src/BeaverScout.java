/**
 * BeaverScout is a type of scout that inherits the parameters from the Scout class
 */
import java.util.ArrayList;
public class BeaverScout extends Scout {
    //-----------------------//
    //-------Attributes------//
    //-----------------------//

    private String parentPhone;

    /**
     * The BeaverScout method builds a scouter using the attributes from the Scout class
     * @param name Name of Scout
     * @param county The County the Scout is from
     * @param dateOfBirth  Scout's DOB
     * @param address Scout's Address
     * @param phoneNumber Scout's contact number
     * @param specialInterests Scouts Special Interests which are handled in the SpecialInterest class
     * @param parentPhone The Scout's parent's phone number
     */

    //-----------------------//
    //--------Methods--------//
    //-----------------------//

    public BeaverScout(String name, String county, String dateOfBirth, String address, String phoneNumber, ArrayList<SpecialInterest> specialInterests, String parentPhone) {
        super(name, county, dateOfBirth, address, phoneNumber, specialInterests);
        this.parentPhone = parentPhone;
    }

    /**
     * The calcMembership method used in the calcRegistrationFee method
     * @return the value 100 which is the cost of membership for a Beaver Scout annually
     */
    @Override
    public double calcMembership() {
        return 100;
    }

    //------------------------//
    //---------Getters--------//
    //------------------------//

    public String getParentPhone() {
        return parentPhone;
    }

    //------------------------//
    //---------Setters--------//
    //------------------------//

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    /**
     * The toString() method that is used for the listOfScouts variable
     */
    @Override
    public String toString() {
        return "Beaver Scout Name: " + super.getName()  +
                ", County: " + super.getCounty()  +
                ", Date of Birth: " + super.getDateOfBirth()  +
                ", Address: " + super.getAddress() +
                ", Contact Number: " + super.getPhoneNumber()  +
                ", Special Interests: " + super.getSpecialInterests() +
                ", Parents Phone No: " + parentPhone;
    }
}
