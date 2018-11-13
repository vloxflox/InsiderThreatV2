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

public class DateNode{

    protected DateEntry dateEntry;
    protected List<ActivityNode> child; 
    
    public DateNode(DateEntry dateEntry){
        this.dateEntry = dateEntry;
        child = new ArrayList<ActivityNode>();
    }

    public void addChild(ActivityNode activityNode){
        ActivityNode node = new ActivityNode(activityNode);
        child.add(node);
    }

    public boolean contains(ActivityEntry key){
        return dateEntry.contains(key);
    }


    public ActivityNode findSon(ActivityEntry key){
        for (ActivityNode current : child) {
            if (current.contains(key)) {
                return current;
            }
        }
        return null;
    }


    public void show(){
        dateEntry.show();
    }
    
}