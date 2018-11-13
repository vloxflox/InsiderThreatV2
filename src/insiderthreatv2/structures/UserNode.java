package insiderthreatv2.structures;

import insiderthreatv2.entries.Entry;
import insiderthreatv2.entries.ActivityEntry;
import insiderthreatv2.entries.DateEntry;
import insiderthreatv2.entries.UserEntry;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author eric
 */

public class UserNode{

    protected UserEntry userEntry;
    protected List<DateNode> child; 
    
    public UserNode(UserEntry userEntry){
        this.userEntry = userEntry;
        child = new ArrayList<DateNode>();
        
        addChild(new DateEntry("01/04/2010"));
    }

    public void addChild(DateEntry dateEntry){
        DateNode node = new DateNode(dateEntry);
        child.add(node);
    }

    public boolean contains(ActivityEntry key){
        return userEntry.contains(key);
    }


    public DateNode findSon(ActivityEntry key){
        for (DateNode current : child) {
            if (current.contains(key)) {
                return current;
            }
        }
        return null;
    }


    public void show(){
        userEntry.show();
        
        child.get(0).show();
    }
    
}