package insiderthreatv2.structures;

import insiderthreatv2.entries.Entry;
import insiderthreatv2.entries.ActivityEntry;
import insiderthreatv2.entries.UserEntry;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author eric
 */

public class UserNode{

    protected UserEntry userEntry;
    protected List<UserNode> child; 
    
    public UserNode(UserEntry userEntry){
        this.userEntry = userEntry;
        child = new ArrayList<UserNode>();
    }

    public void addChild(UserEntry userEntry){
        UserNode node = new UserNode(userEntry);
        child.add(node);
    }

    public boolean contains(ActivityEntry key){
        return userEntry.contains(key);
    }


    public UserNode findSon(ActivityEntry key){
        for (UserNode current : child) {
            if (current.contains(key)) {
                return current;
            }
        }
        return null;
    }


    public void show(){
        userEntry.show();
    }
    
}