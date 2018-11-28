/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insiderthreatv2.structures;

import insiderthreatv2.entries.ActivityEntry;
import insiderthreatv2.entries.DeviceEntry;
import insiderthreatv2.entries.HttpEntry;
import insiderthreatv2.entries.LogonEntry;
import java.util.List;
    
    
/**
 *
 * @author eric
 */

//computador onde as observações estão sendo feitas (nível 3)
public class PcNode {
    
    //IMPLEMENTAR HISTOGRAMA AQUI
    String id;
    protected List<HttpEntry>   httpChilds;
    protected List<LogonEntry>  logonChilds;
    protected List<DeviceEntry> deviceChilds;
    
    //recebe uma entry e adiciona ao registro
    PcNode(ActivityEntry activityEntry) {
        id = activityEntry.getPc();
        addChild(activityEntry);
    }
    
    
    public void addChild(ActivityEntry activityEntry){
        
        if( activityEntry instanceof DeviceEntry) {
            deviceChilds.add( (DeviceEntry)activityEntry);
            return;
        }
        if( activityEntry instanceof HttpEntry) {
            httpChilds.add( (HttpEntry)activityEntry);
            return;
        }
        if( activityEntry instanceof LogonEntry) {
            logonChilds.add( (LogonEntry)activityEntry);
            return;
        }
    }
    
    public boolean contains(ActivityEntry activityEntry){
        return id.equals(activityEntry.getPc() );
    }

}
