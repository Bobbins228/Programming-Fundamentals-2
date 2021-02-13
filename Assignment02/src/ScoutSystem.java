/**
 * The Scouting Ireland program is an application that allows a user to read options from a menu and select whether they
 * want to add, delete, update, list scouts or search by name, view total membership costs, list scouts by group,
 * print a summary report of total scouts or save and load them to external files.
 *
 * @author Mark Campbell
 * @version 1.0
 * @since 06/04/2020
 */

import java.util.Scanner;
import java.util.ArrayList;
public class ScoutSystem {
    private Scanner input = new Scanner(System.in);
    private ScoutList scoutList = new ScoutList();

    public ScoutSystem() {
        runMenu();
    }

    public static void main(String[] args) {
        new ScoutSystem();
    }

    /**
     * The mainMenu() method displays a menu for the user to follow
     */
    private int mainMenu() {
        System.out.println("Scouting Ireland Menu");
        System.out.println("*********************");
        System.out.println("1) Load All Scouts from File");
        System.out.println("-------------------------------");
        System.out.println("2) Register a new Scout");
        System.out.println("3) List all Scouts");
        System.out.println("4) Delete a Scout");
        System.out.println("5) Update Scout Details");
        System.out.println("-------------------------------");
        System.out.println("6) List Scouts by Group (Beaver/Cub/Scouter)");
        System.out.println("7) Calculate Total Annual Fees Received from Scouts");
        System.out.println("8) View Total Number of Scouts by Group (Beaver/Cub/Scouter)");
        System.out.println("9) Summary Report of all Scout Membership Numbers");
        System.out.println("10) Search Scouts by Name");
        System.out.println("-------------------------");
        System.out.println("11) Save Scouts to file");
        System.out.println("-------------------------");
        System.out.println("0) Exit");
        System.out.print("==>> ");
        int option = input.nextInt();
        return option;
    }

    /**
     * The runMenu() method takes in user input and corresponds it with other methods
     */
    private void runMenu() {
        int option = mainMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    try {
                        scoutList.load();
                    } catch (Exception e) {
                        System.out.println("Error reading from file" + e);
                    }
                    break;
                case 2:
                    addScout();
                    break;
                case 3:
                    listScouts();
                    break;
                case 4:
                    deleteScout();
                    break;
                case 5:
                    updateScout();
                    break;
                case 6:
                    listNamesByGroup();
                    break;
                case 7:
                    calcRegistrationFee();
                    break;
                case 8:
                    listNumberOfScouts();
                    break;
                case 9:
                    ScoutSummaryReport();
                    break;
                case 10:
                    SearchByName();
                    break;
                case 11:
                    try {
                        scoutList.save();
                    } catch (Exception e) {
                        System.out.println("Error writing to file" + e);
                    }
                    break;
                default:
                    System.out.println("Invalid option entered " + option);
                    break;
            }
            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine();
            option = mainMenu();
        }
        System.out.println("Exiting... bye");
        System.exit(0);
    }

    /**
     * The addScout method first asks the user which type of scout the want to add
     * then using a switch statement dependant on which option they picked various user inputs will be
     * used to add the details of the scout
     */
    private void addScout(){

        System.out.println("What kind of scout would you like to add?.");
        System.out.println("1. Beaver Scout");
        System.out.println("2. Cub Scout");
        System.out.println("3. Scouter");
        int option = input.nextInt();
        switch(option){
            case 1:
                input.nextLine();
                System.out.println("Name => ");
                System.out.println("County=> ");
                System.out.println("Date of Birth => ");
                System.out.println("Address => ");
                System.out.println("Contact number => ");
                String name = input.nextLine();
                String county = input.nextLine();
                String dateOfBirth = input.nextLine();
                String address = input.nextLine();
                String phoneNumber = input.nextLine();
                System.out.println("Enter Special Interest Details");
                System.out.println("Special Interest Category");
                System.out.println("Details");
                System.out.println("date Badge Received");
                String interestCategory = input.nextLine();
                String details = input.nextLine();
                String dateBadgeReceived = input.nextLine();

                //This is the Special Interest ArrayList used to pass the SpecialInterest attributes as sp1 for the scout
                ArrayList<SpecialInterest> sps = new ArrayList<>();
                SpecialInterest sp1 = new SpecialInterest(interestCategory,details,dateBadgeReceived);
                sps.add(sp1);


                System.out.println("Do you wish to enter another special Interest: Y/y for yes, N/n for no ==> ");
                String ans = input.nextLine();
                ans = ans.toUpperCase();
                while(ans.equals("Y")){
                    System.out.println("Enter Special Interest Details");
                    System.out.println("Special Interest Category");
                    System.out.println("Details");
                    System.out.println("date Badge Received");
                    interestCategory = input.nextLine();
                    details = input.nextLine();
                    dateBadgeReceived = input.nextLine();
                    sp1 = new SpecialInterest(interestCategory,details,dateBadgeReceived);
                    sps.add(sp1);
                    System.out.println("Do you wish to enter another special Interest: Y/y for yes, N/n for no ==> ");
                    ans = input.nextLine();
                    ans = ans.toUpperCase();
                }
                System.out.println("Parents Phone Number?");
                String parentPhone = input.nextLine();
                BeaverScout s1 = new BeaverScout(name, county, dateOfBirth, address, phoneNumber, sps, parentPhone);
                scoutList.addScout(s1);
                System.out.println("Beaver Scout Added");
                break;
            case 2:
                input.nextLine();
                System.out.println("Name => ");
                System.out.println("County=> ");
                System.out.println("Date of Birth => ");
                System.out.println("Address => ");
                System.out.println("Contact number => ");
                name = input.nextLine();
                county = input.nextLine();
                dateOfBirth = input.nextLine();
                address = input.nextLine();
                phoneNumber = input.nextLine();
                System.out.println("Enter Special Interest Details");
                System.out.println("Special Interest Category");
                System.out.println("Details");
                System.out.println("date Badge Received");
                interestCategory = input.nextLine();
                details = input.nextLine();
                dateBadgeReceived = input.nextLine();


                sps = new ArrayList<>();
                sp1 = new SpecialInterest(interestCategory,details,dateBadgeReceived);
                sps.add(sp1);


                System.out.println("Do you wish to enter another special Interest: Y/y for yes, N/n for no ==> ");
                ans = input.nextLine();
                ans = ans.toUpperCase();
                while(ans.equals("Y")){
                    System.out.println("Enter Special Interest Details");
                    System.out.println("Special Interest Category");
                    System.out.println("Details");
                    System.out.println("date Badge Received");
                    interestCategory = input.nextLine();
                    details = input.nextLine();
                    dateBadgeReceived = input.nextLine();
                    sp1 = new SpecialInterest(interestCategory,details,dateBadgeReceived);
                    sps.add(sp1);
                    System.out.println("Do you wish to enter another special Interest: Y/y for yes, N/n for no ==> ");
                    ans = input.nextLine();
                    ans = ans.toUpperCase();
                }
                System.out.println("Cub Scout Phone Number (if they have one):");
                String cubPhoneNumber = input.nextLine();
                CubScout cs1 = new CubScout(name, county, dateOfBirth, address, phoneNumber, sps, cubPhoneNumber);
                scoutList.addScout(cs1);
                System.out.println("Cub Scout Added");
                break;
            case 3:
                input.nextLine();
                System.out.println("Name => ");
                System.out.println("County=> ");
                System.out.println("Date of Birth => ");
                System.out.println("Address => ");
                System.out.println("Contact number => ");
                name = input.nextLine();
                county = input.nextLine();
                dateOfBirth = input.nextLine();
                address = input.nextLine();
                phoneNumber = input.nextLine();
                System.out.println("Enter Special Interest Details");
                System.out.println("Special Interest Category");
                System.out.println("Details");
                System.out.println("date Badge Received");
                interestCategory = input.nextLine();
                details = input.nextLine();
                dateBadgeReceived = input.nextLine();


                sps = new ArrayList<>();
                sp1 = new SpecialInterest(interestCategory,details,dateBadgeReceived);
                sps.add(sp1);


                System.out.println("Do you wish to enter another special Interest: Y/y for yes, N/n for no ==> ");
                ans = input.nextLine();
                ans = ans.toUpperCase();
                while(ans.equals("Y")){
                    System.out.println("Enter Special Interest Details");
                    System.out.println("Special Interest Category");
                    System.out.println("Details");
                    System.out.println("date Badge Received");
                    interestCategory = input.nextLine();
                    details = input.nextLine();
                    dateBadgeReceived = input.nextLine();
                    sp1 = new SpecialInterest(interestCategory,details,dateBadgeReceived);
                    sps.add(sp1);
                    System.out.println("Do you wish to enter another special Interest: Y/y for yes, N/n for no ==> ");
                    ans = input.nextLine();
                    ans = ans.toUpperCase();
                }
                System.out.println("Date of Garda Vetting: ");
                String dateOfVetting = input.nextLine();
                Scouter ss1 = new Scouter(name, county, dateOfBirth, address, phoneNumber, sps, dateOfVetting);
                scoutList.addScout(ss1);
                System.out.println("Scouter Added");
                break;
            default:
                System.out.println("Invalid option entered " + option);
        }
    }

    /**
     * This method prints the scouts to the screen
     */
    private void listScouts() {
        System.out.println(scoutList.listOfScouts());
    }

    /**
     * This method asks the user which scout they would like to delete and deletes it based
     * on the index inputted by the user
     */
    private void deleteScout(){
        listScouts();
        String scoutDetails = scoutList.listOfScouts();
        int size = scoutList.getSize();

        if (!scoutDetails.equals("No Scouts")){
            System.out.println("Enter the index of the scout you would like to delete: ");
            int index = input.nextInt();
            if(size > 0 && index < size){
                scoutList.deleteScout(index);
                System.out.println("Scout Removed");
            }
            else {
                System.out.println("Invalid Index - No scouts of index " + index);
            }
        }
    }

    /**
     * This method updates the attributes of an existing scout based on the index inputted
     */
    private void updateScout() {
        listScouts();
        String scoutDetails = scoutList.listOfScouts();
        int size = scoutList.getSize();

        if (!scoutDetails.equals("No Scouts")){
            System.out.println("Index of scout to edit ==>");
            int index = input.nextInt();
            if (size > 0 && (index < size)) {
                input.nextLine();
                System.out.println("Enter a new Scout Name (Blank to remain unchanged) => ");
                System.out.println("County (Blank to remain unchanged) => ");
                System.out.println("Date of Birth (Blank to remain unchanged) => ");
                System.out.println("Address (Blank to remain unchanged) => ");
                System.out.println("Contact number (Blank to remain unchanged) => ");
                String name = input.nextLine();
                String county = input.nextLine();
                String dateOfBirth = input.nextLine();
                String address = input.nextLine();
                String phoneNumber = input.nextLine();
                scoutList.updateScout(index, name, county, dateOfBirth, address, phoneNumber);
                System.out.println("Update Successful");
            }
            else{
                System.out.println("Incorrect Index - no Scout valid for index " + index);

            }
        }
    }

    /**
     * This method asks the user which group to search by and uses a switch statement
     * for each case the group String is changed in accordance to the Scout category inputted by the user.
     * The group String is then passed into the listScoutsBySpecificGroup method in the scoutList class and
     * the output is then printed
     */
    private void listNamesByGroup(){
        System.out.println("List of Scout Member names only");
        System.out.println("Choose a category");
        System.out.println("1. Beaver Scout");
        System.out.println("2. Cub Scout");
        System.out.println("3. Scouter");
        System.out.print("Please Enter your Choice [1-3]: ");
        int option = input.nextInt();
        System.out.println("Your Choice is: " + option);
        switch (option){
            case 1:
                String group = "BeaverScout";
            System.out.println(scoutList.listScoutsBySpecificGroup(group));
            break;
            case 2:
                group = "CubScout";
                System.out.println(scoutList.listScoutsBySpecificGroup(group));
                break;
            case 3:
                group = "Scouter";
                System.out.println(scoutList.listScoutsBySpecificGroup(group));
                break;
            default:
                System.out.println("Wrong option entered " + option);
                break;
        }

    }

    /**
     * This method changes the group String to the three different types of scout and for
     * each scout type the group is passed into the registrationFee method and is added
     * to the sum variable which is then printed to the screen
     */
    public void calcRegistrationFee(){
        if (scoutList.getSize() == 0){
            System.out.println("No Scouts have signed up yet!");
        }
        else {
            double sum = 0;
            String group = "BeaverScout";
            sum = (Double.parseDouble(scoutList.registrationFee(group)));
            group = "CubScout";
            sum = sum + (Double.parseDouble(scoutList.registrationFee(group)));
            group = "Scouter";
            sum = sum + (Double.parseDouble(scoutList.registrationFee(group)));
            System.out.println("Fees Report");
            System.out.println("Total Fees: €" + sum);
        }

    }

    /**
     * This method operates in a similar way to the listNamesByGroup method except group
     * is passed into the scoutList method listNumberOfScoutsBySpecificGroup and are then printed
     */
    private void listNumberOfScouts(){
        System.out.println("List of the Number of Scouts in a Scout Group");
        System.out.println("Choose a category");
        System.out.println("1. Beaver Scout");
        System.out.println("2. Cub Scout");
        System.out.println("3. Scouter");
        System.out.print("Please Enter your Choice [1-3]: ");
        int option = input.nextInt();
        System.out.println("Your Choice is: " + option);
        switch (option){
            case 1:
                String group = "BeaverScout";
                System.out.println(scoutList.listNumberOfScoutsBySpecificGroup(group));
                break;
            case 2:
                group = "CubScout";
                System.out.println(scoutList.listNumberOfScoutsBySpecificGroup(group));
                break;
            case 3:
                group = "Scouter";
                System.out.println(scoutList.listNumberOfScoutsBySpecificGroup(group));
                break;
            default:
                System.out.println("Wrong option entered " + option);
                break;
        }

    }

    /**
     * This method lists the total number of scouts by using the getSize() method
     * This method lists the total number of the other groups by passing the group
     * String into the listNumberOfScoutsBySpecificGroup() method each time it changes.
     */
    public void ScoutSummaryReport(){
        System.out.println("Scout Member Summary Report: ");
        System.out.println("Total Number of Scout Members: " + scoutList.getSize());
        System.out.println();
        String group = "BeaverScout";
        System.out.println("Beaver Scout Report");
        System.out.println("Number of Beaver Scouts: " + scoutList.listNumberOfScoutsBySpecificGroup(group) );
        System.out.println();
        group = "CubScout";
        System.out.println("Cub Scout Report");
        System.out.println("Number of Cub Scouts: " + scoutList.listNumberOfScoutsBySpecificGroup(group) );
        System.out.println();
        group = "Scouter";
        System.out.println("Scouter Report");
        System.out.println("Number of Scouters: " + scoutList.listNumberOfScoutsBySpecificGroup(group) );

    }

    /**
     * This method takes in the name String as user input and passes it into the searchScoutsByName() method
     * and is then printed to the screen
     */
    public void SearchByName(){
        System.out.println("Enter a Name to search by: ");
        input.nextLine();
        String name = input.nextLine();
        System.out.println(scoutList.searchScoutsByName(name));
    }
}
























