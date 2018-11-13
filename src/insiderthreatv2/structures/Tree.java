/**
 *
 * @author eric
 */
package insiderthreatv2.structures;

import insiderthreatv2.entries.ActivityEntry;
import insiderthreatv2.entries.Entry;
import insiderthreatv2.entries.UserEntry;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Tree {
    
    private RootNode root;
    
    public Tree(){
        root = new RootNode(null);
        
        initializeUsers("../r1/LDAP/2010-04.csv");
        
        ActivityEntry key;
        key = new ActivityEntry("{F1C5-I5CN19JK-9863ZHWX}","01/04/2010 13:45:58","DTAA/QGM0222","PC-1214","http://espn.go.com");
        
        searchEntry(key);
    }
    
    private void initializeUsers(String csvFile) {

        
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        UserEntry userEntry;


        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] logEntry = line.split(cvsSplitBy);    
                
                userEntry = new UserEntry(logEntry[0] , logEntry[1] , logEntry[2] , logEntry[3] , logEntry[4]);

                root.addChild(userEntry);

            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    
    private void searchEntry(ActivityEntry activityEntry){
        UserNode userNode = root.findSon(activityEntry);
        userNode.show();
    }
    
    
}
