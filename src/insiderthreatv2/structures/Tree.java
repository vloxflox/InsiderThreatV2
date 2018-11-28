/**
 *
 * @author eric
 */
package insiderthreatv2.structures;

import java.util.Scanner;
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
        
        //userInterface();
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
        UserNode userNode = root.findSon(activityEntry);
        if(userNode!=null){
            userNode.show();
        }else{
            System.out.println("Entrada não correspondente a nenhum valor armazenado");
        }
    }
    
    private void searchId(String id){
        UserNode userNode = root.findId(id);
        if(userNode!=null){
            userNode.show();
        }else{
            System.out.println("Id não correspondente ao de nenhum funcionário cadastrado");
        }
    }
    
    private void userInterface(){
        boolean isRunning = true;
        Scanner scanner;
        scanner = new Scanner(System.in); 
        String userId;
        
        while (isRunning){             
            System.out.println("Digite o ID do usuário que deseja visualizar, e 0 para finalizar a busca");
            userId = scanner.nextLine();
            if(!userId.equals("0")){
                searchId(userId);
            }else{
                isRunning = false;
            }
            
        }
    }
    
    
}
