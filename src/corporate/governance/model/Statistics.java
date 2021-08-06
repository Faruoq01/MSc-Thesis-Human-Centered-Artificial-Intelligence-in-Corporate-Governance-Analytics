/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corporate.governance.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Faruoq
 */
public class Statistics {
    
    public static double round(double value, int places){
        if(places < 0) throw new IllegalArgumentException();
        
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        
        return bd.doubleValue();
    }
    
    public static double Counts(ArrayList<Double> variable){
        
        int counts = 0;
        
        for(int i = 0; i < variable.size() + 1; i++){
            counts = i;
        }
        
        return counts;
    }
    
    public static double Mean(ArrayList<Double> variable){
        
        double sum = 0;
        
        for(int i = 0; i < variable.size(); i++){
            
            sum += variable.get(i);
        }
        
        double Mean = sum/(variable.size() - 1);
        
        return Statistics.round(Mean, 3);
    }
    
    public static double std(ArrayList<Double> variable){
        
        ArrayList<Double> sdArr = new ArrayList<Double>();
        
        double div = 0;
       
        for(int i = 0; i < variable.size(); i++){
            
            div = Math.abs(variable.get(i) - Statistics.Mean(variable));
            double sd = div*div;
            sdArr.add(sd);  
        }
        
        double MSD = Statistics.Mean(sdArr);
        double STD = Math.sqrt(MSD);
        
        return Statistics.round(STD, 3);
       
    }
    
    public static double min(ArrayList<Double> variable){
        
        double min = Collections.min(variable);
        
        return min;
    }
    
    
    public static double max(ArrayList<Double> variable){
        
        double max = Collections.max(variable);
        
        return max;
    }
    
    
    public static double Q2(ArrayList<Double> variable){
        
        Collections.sort(variable);
        double Size = variable.size();
        double Final_Number = 0;
        
        if(Size%2 == 0){
            int Halfway = variable.size()/2;
            double value1 = variable.get( Halfway - 1);
            double value2 = variable.get(Halfway);
            double Number = value1 + value2;
            Final_Number = Number/2;
        }else{
            double HalfWay = (variable.size()+1)/2;
            HalfWay = Statistics.round(HalfWay, 0);
            
            Final_Number = variable.get((int)HalfWay);
        }
        
        return Statistics.round(Final_Number, 3);
    }
    
    public static double Q1 (ArrayList<Double> variable){
        
        Collections.sort(variable);
        
        ArrayList<Double> arr = new ArrayList<Double>();
        
        int i = 0; 
        for (i=0; i < variable.size(); i++){
            
            if(variable.size()%2 == 0){
                
                if(i < (variable.size())/2){
                    arr.add(variable.get(i));
                }
            
            
            }else{
                
                if(i < (variable.size())/2){
                    arr.add(variable.get(i));
                }
            
            
            }
         
           
        }
        
        return Statistics.Q2(arr);
    }
    
    public static double Q3 (ArrayList<Double> variable){
        
        Collections.sort(variable);
        ArrayList<Double> arr = new ArrayList<Double>();
         
        for (int i = 0; i<variable.size(); i++){
            
            if(variable.size()%2 == 0){
                
                if(i > (variable.size()-1)/2){
                    arr.add(variable.get(i));
                }
            
            
            }else{
                
                if(i > (variable.size())/2){
                    arr.add(variable.get(i));
                }
            
            
            }
        }
        
        return Statistics.Q2(arr);
        
    
    }
    
    public static double sumUpSquareArray(ArrayList<Double> array){
        
        double sum = 0;
        for(int x = 0; x<array.size(); x++){
                
            sum += array.get(x)*array.get(x);
        }
        
        return sum;
    
    }
    
     public static double sumUpArray(ArrayList<Double> array){
        
        double sum = 0;
        for(int x = 0; x<array.size(); x++){
                
            sum += array.get(x);
        }
        
        return sum;
    
    }
    
}
