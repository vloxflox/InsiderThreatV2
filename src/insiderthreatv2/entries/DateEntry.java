/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insiderthreatv2.entries;

public class DateEntry extends Entry{

    private String date;
    
    public DateEntry(String id){
        this.date = date;
    }


    public void setDate(String date){
        this.date = date;
    }
    
    public String getDate(){
        return date;
    }
    
    @Override
    public boolean contains(Entry entry){
        return true;
    }
    
    @Override
    public void show(){
        System.out.println("Data: " + date);
        System.out.println();
    }
    
    
}