import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ScoutList {
    private ArrayList<Scout> scouts = new ArrayList<>();;
    public void addScout(Scout scout){scouts.add(scout);}

    /**
     * This method produces a string that lists every scout followed by their names and other attributes
     * @return listOfScouts String
     */
    public String listOfScouts() {
        if (scouts.size() == 0) {
            return "No Scouts";
        } else {
            String listOfScouts = "";
            for (int i = 0; i < scouts.size(); i++) {
                listOfScouts = listOfScouts + i + ": " + scouts.get(i) + "\n";
            }
            return listOfScouts;
        }
    }

    /**
     * This method takes a scout by a user inputted index and updates their attributes
     * If the user leaves their change blank the attribute will be changed back into what
     * it previously was
     * @param index index Number
     * @param name Scout Name
     * @param county Scout's County
     * @param dateOfBirth Scout's DOB
     * @param address Scout's Address
     * @param phoneNumber Scout's Contact Number
     */
    public void updateScout(int index, String name, String county, String dateOfBirth, String address, String phoneNumber){
        Scout s = scouts.get(index);
        if (name.equals("")){
            name = scouts.get(index).getName();
        }
        else {
            s.setName(name);
        }
        if (county.equals("")){
            county = scouts.get(index).getCounty();
        }
        else {
            s.setCounty(county);
        }
        if (dateOfBirth.equals("")){
            dateOfBirth = scouts.get(index).getDateOfBirth();
        }
        else{
            s.setDateOfBirth(dateOfBirth);
        }
        if (address.equals("")){
            address = scouts.get(index).getAddress();
        }
        else{
            s.setAddress(address);
        }
        if (phoneNumber.equals("")){
            phoneNumber = scouts.get(index).getPhoneNumber();
        }
        else {
            s.setPhoneNumber(phoneNumber);
        }
    }

    /**
     * This is the getScout method used for reading a Scout in other methods and allowing changes to be made
     * to its attributes
     * @param Scout an index number
     * @return scouts.get(Scout) is a scout of the index given
     */
    public Scout getScout(int Scout){
        return scouts.get(Scout);
    }

    /**
     * This method gets the number of objects in the ArrayList scouts
     * @return number of objects in the ArrayList
     */
    public int getSize(){return scouts.size();}

    /**
     * This method removes a scout provided an index number is passed
     * @param index the index number for the scout needed to be deleted
     */
    public void deleteScout(int index){scouts.remove(index);}

    /**
     * This method works by taking in the group String from the user and checking if it
     * is the same as the Group String and if so puts the name Attributes of scouts in the
     * group in the listOfScouts String
     * @param group group name inputted by user in the ScoutSystem Class
     * @return listOfScouts String
     */
    public String listScoutsBySpecificGroup(String group){
        String listOfScouts = "";
        String Group = "";
        if (scouts.size() == 0)
        {
            return "There are no scouts stored in the list";
        }
        for (int i = 0; i < scouts.size(); i++) {
            Group = getScout(i).getClass().getName();
            if (Group.equals(group)) {
                listOfScouts = listOfScouts + scouts.get(i).getName() + "\n";
            }
        }
        return listOfScouts;

    }

    /**
     * This method works similar to the listScoutsBySpecificGroup method except
     * if the group String equals the Group String, listOfScouts will add 1
     * and this continues until there are no more scouts of that group
     * @param group group name inputted by user in the ScoutSystem Class
     * @return integer value of the number of Scouts in a group (listOfScouts)
     */
    public String listNumberOfScoutsBySpecificGroup(String group){
        int listOfScouts = 0;
        String Group = "";
        if (scouts.size() == 0)
        {
            return "There are no scouts stored in the list";
        }
        for (int i = 0; i < scouts.size(); i++) {
            Group = getScout(i).getClass().getName();
            if (Group.equals(group)) {
                listOfScouts = listOfScouts + 1;
            }
        }
        return String.valueOf(listOfScouts);
    }

    /**
     * Again This method works similar with way it checks if the group and Group Strings
     * are equal but this time if they are equal the num value will equal itself plus the
     * calcMembership method which returns different values dependant on which group is
     * passed through.
     * I needed to make the reqistrationFee method a String so that I could use the group and
     * Group Strings. The return Statement changes the double for num into a String.
     * @param group group name inputted by user in the ScoutSystem Class
     * @return String num
     */
    public String registrationFee(String group){
        String Group = "";
        double num = 0;
        for(int i = 0; i < scouts.size(); i++) {
            Group = scouts.get(i).getClass().getName();
            if (Group.equals(group)) {
                num = num + getScout(i).calcMembership();
            }

        }
        return String.valueOf(num);
    }

    /**
     * This method takes in a name given by the user and checks if it equals
     * any names in the scoutList and if it does it prints the scouts with the same name
     * @param name name inputted by user in the ScoutSystem Class
     * @return String of the list of scouts with the name entered by the user
     */
    public String searchScoutsByName(String name){
        String listOfScouts = "";
        String Name = "";
        if (scouts.size() == 0)
        {
            return "There are no scouts stored in the list";
        }
        else{
            for(int i = 0; i < scouts.size(); i++) {
                Name = getScout(i).getName();
                if (Name.equals(name)) {
                    listOfScouts = listOfScouts + i + ": " + scouts.get(i) + "\n";
                }
            }
            return listOfScouts;
        }
    }
    //This is the standard load method
    @SuppressWarnings("unchecked")
    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("scouts.xml"));
        scouts = (ArrayList<Scout>) is.readObject();
        is.close();
    }
    //This is the standard save method
    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("scouts.xml"));
        out.writeObject(scouts);
        out.close();
    }


}
