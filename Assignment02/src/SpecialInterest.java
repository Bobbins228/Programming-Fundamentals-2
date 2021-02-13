/**
 * This class handles the attributes for the SpecialInterests ArrayList
 */
public class SpecialInterest {

    //-----------------------//
    //-------Attributes------//
    //-----------------------//

    private String interestCategory;
    private String details;
    private String dateBadgeReceived;

    /**
     * @param interestCategory What the Scout is Interested in
     * @param details The details on how they got their badge
     * @param dateBadgeReceived The date they received their badge
     */

    //-----------------------//
    //--------Methods--------//
    //-----------------------//

    public SpecialInterest(String interestCategory, String details, String dateBadgeReceived) {
        this.interestCategory = interestCategory;
        this.details = details;
        this.dateBadgeReceived = dateBadgeReceived;
    }

    //------------------------//
    //---------Getters--------//
    //------------------------//

    public String getInterestCategory() {
        return interestCategory;
    }

    public String getDetails() {
        return details;
    }

    public String getDateBadgeReceived() {
        return dateBadgeReceived;
    }

    //------------------------//
    //---------Setters--------//
    //------------------------//

    public void setInterestCategory(String interestCategory) {
        this.interestCategory = interestCategory;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setDateBadgeReceived(String dateBadgeReceived) {
        this.dateBadgeReceived = dateBadgeReceived;
    }

    /**
     * The toString() method that is used for the listOfScouts variable
     */
    @Override
    public String toString() {
        return "Interest Category: " + interestCategory +
                ", Details: " + details +
                ", Date Badge Received: " + dateBadgeReceived;
    }
}
