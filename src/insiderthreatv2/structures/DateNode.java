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

//data das observações (nível 2)
public class DateNode{

    protected DateEntry dateEntry;
    protected List<PcNode> child; 
    
    public DateNode(DateEntry dateEntry){
        this.dateEntry = dateEntry;
        child = new ArrayList<PcNode>();
    }

    public void addChild(ActivityEntry activityNode){
        PcNode node = new PcNode(activityNode);
        child.add(node);
    }

    public boolean contains(ActivityEntry key){
        return dateEntry.contains(key);
    }


    public PcNode findSon(ActivityEntry key){
        for (PcNode current : child) {
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