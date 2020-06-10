
package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roberto
 */
public class Program {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> map = new HashMap<>();
                
        System.out.print("Enter file full path: ");
        String path = sc.nextLine();
        
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            
            String line = br.readLine();
            while(line != null){
                String[] fields = line.split(",");
                if(map.get(fields[0]) == null){
                    map.put(fields[0], Integer.parseInt(fields[1]));
                }
                else{
                    map.put(fields[0], Integer.parseInt(fields[1]) + map.get(fields[0]));
                }
                line = br.readLine();
            }  
        } 
        catch (FileNotFoundException ex) { 
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        for (String key : map.keySet()){
            System.out.println(key + ": " + map.get(key));
        }
        
        sc.close();
    }
    
}
