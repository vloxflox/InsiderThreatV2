/**
 *
 * @author eric
 */
package insiderthreatv2.structures;

import insiderthreatv2.entries.Entry;
import insiderthreatv2.entries.ActivityEntry;
import insiderthreatv2.entries.DeviceEntry;
import insiderthreatv2.entries.HttpEntry;
import insiderthreatv2.entries.LogonEntry;
import insiderthreatv2.entries.UserEntry;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


//estrutura que gerencia usuários
public class Tree {
    
    private RootNode root;
    
    public Tree(){
        root = new RootNode(null);
        
        initializeUsers("../r1/LDAP/2010-04.csv", "01/04/2010");
        
        ActivityEntry key;
        key = new LogonEntry("{Q8D8-W9AS61AT-5411NKYP}","01/04/2010 04:08:42","DTAA/CRC0996","PC-3916","Logon");
        
        searchEntry(key);
    }
    
    private void initializeUsers(String csvFile, String currentDate) {

        
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

                root.addChild(userEntry, currentDate);

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
        if( activityEntry instanceof DeviceEntry) {
            System.out.println("device search");
        }
        if( activityEntry instanceof HttpEntry) {
            System.out.println("http search");
        }
        if( activityEntry instanceof LogonEntry) {
            System.out.println("logon search");
        }
        
        UserNode userNode = root.findSon(activityEntry);
        userNode.show();
    }
    
    
}
