package insiderthreatv2.structures;

import insiderthreatv2.entries.Entry;
import insiderthreatv2.entries.ActivityEntry;
import insiderthreatv2.entries.DateEntry;
import insiderthreatv2.entries.UserEntry;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author eric
 */

public class RootNode{

    protected List<UserNode> child; 
    
    public RootNode(UserEntry userEntry){
        child = new ArrayList<UserNode>();
    }

    public void addChild(UserEntry userEntry){
        UserNode node = new UserNode(userEntry);
        child.add(node);
    }

    public UserNode findSon(ActivityEntry key){
        for (UserNode current : child) {
            if (current.contains(key)) {
                return current;
            }
        }
        return null;
    }
    
}