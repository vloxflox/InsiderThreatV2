/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insiderthreatv2.entries;

public abstract class ActivityEntry extends Entry{

    private String id;
    private String date;
    private String user;
    private String pc;
    private String activity;

    public ActivityEntry(String id,String date,String user,String pc,String activity){
        this.id       = id;
        this.date     = date;
        this.user     = user;
        this.pc       = pc;
        this.activity = activity;
    }


    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }


    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return date;
    }


    public void setUser(String user){
        this.user = user;
    }
    public String getUser(){
        return user;
    }

    
    public void setPc(String pc){
        this.pc = pc;
    }
    public String getPc(){
        return pc;
    }

    
    public void setActivity(String activity){
        this.activity = activity;
    }
    public String getActivity(){
        return activity;
    }
    
    @Override
    public boolean contains(Entry entry){
        return true;
    }
    
    @Override
    public void show(){
        System.out.println("ID da atividade:    "     + id);
        System.out.println("Data da atividade:      " + date);
        System.out.println("Usuário responsável: "    + user);
        System.out.println("PC da atividade:   "      + pc);
        System.out.println("Atividade:  "             + activity);
        System.out.println();
    }
    
    
}