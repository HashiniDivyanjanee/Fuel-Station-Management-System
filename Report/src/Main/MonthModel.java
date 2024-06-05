/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

public class MonthModel {
 

    public String getEmpID() {
        return EmpID;
    }

    public void setEmpID(String EmpID) {
        this.EmpID = EmpID;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getMonthText() {
        return monthText;
    }

    public void setMonthText(String monthText) {
        this.monthText = monthText;
    }
    public MonthModel(int month, String monthText){
        this.month = month;
        this. monthText = monthText;
    }
    
    public MonthModel(){
        
    }
    
   private int month;
   private String monthText;
   private String EmpID;
   
   @Override
   public String toString(){
       return monthText;
   
   } 
  
}
