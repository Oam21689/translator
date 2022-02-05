
package yomommatranslator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class YoMommaTranslator {

    public static void main(String[] args) throws FileNotFoundException{
        
        TreeMap<String, String> acronyms = new TreeMap<>();
        
        File input = new File("acronyms.txt");
        Scanner inputAcronym = new Scanner(input);
        Scanner in = new Scanner(System.in).useDelimiter("\\n");
        String acronym = null;
        
        while(inputAcronym.hasNextLine()){
            String line = inputAcronym.nextLine();
            String[] split = line.split("\\t");
            acronyms.put(split[0].toLowerCase(), split[1]);
        }
        
        System.out.println("Enter the sentence you want to expend:");
            String userInput = in.next();
            String[] split = userInput.split("\\s+");
            String translated_Sentence = "";
            for(int i = 0; i < split.length;i++)
            {
                acronym = split[i];
                
//                if(acronyms.get(acronym) == null)
//                    System.out.print(acronym+" ");
//                else
//                    System.out.print(acronyms.get(acronym).toLowerCase()+" ");
if (acronyms.containsKey(split[i].toLowerCase())) {
                translated_Sentence += acronyms.get(split[i].toLowerCase()).toLowerCase() + " ";
            } 
            
            else {
                translated_Sentence += split[i] + " ";
            }
            }
            System.out.print(translated_Sentence);
    }
    
}
