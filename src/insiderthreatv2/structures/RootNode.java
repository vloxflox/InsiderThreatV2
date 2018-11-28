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

//nó que armazena todos os usuários
public class RootNode{

    
    protected List<UserNode> child; 
    
    public RootNode(UserEntry userEntry){
        child = new ArrayList<UserNode>();
    }

    public void addChild(UserEntry userEntry, String currentDate){
        UserNode node = new UserNode(userEntry, currentDate);
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
    
    public UserNode findId(String id){
        for (UserNode current : child) {
            if (current.checkId(id)) {
                return current;
            }
        }
        return null;
    }
    
}