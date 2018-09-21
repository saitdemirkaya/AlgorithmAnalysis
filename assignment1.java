import java.io.BufferedReader;
import java.io.File;
import java.lang.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class assignment1 {
	
    public static void main(String[] args) throws IOException {
    	Scanner scanner = new Scanner(new File(args[0]));// reading file
        String csvFile = (args[0]);
        BufferedReader br = null;
        String line = "";
        ArrayList <String> array = new ArrayList <String> ();
        	int number = Integer.parseInt(args[1]);
	        try {
	        	int i=-1;
	        	 br = new BufferedReader(new FileReader(csvFile));
	             while ((line = br.readLine()) != null) {
	                 array.add(line);//adding array list
	                i++;
	             }
	             long startTime = System.nanoTime(); 
	            //SelectionSort(array,number,i);
	            //InstertionSort(array,number,i);
	            QuickSort sorter = new QuickSort();
	            sorter.sort(array,number,i);
	            br.close();
	            String one = args[2];// T or F
	            	if(one.equals("T")) {
	        	   FileWriter writer = new FileWriter(args[0]);// saving file
	               StringBuilder sb = new StringBuilder();
	               for(int k=0;k<=i;k++) {
	               	sb.append(array.get(k)+"\n");
	               	}
	                writer.write(sb.toString());
	                writer.close();
	            	}else if(one.equals("F")) {
	        	   
	            	}else {
	        	   System.out.println("Please enter T or F");
	            	}
	           long endTime = System.nanoTime(); 
	           long estimatedTime = endTime - startTime; 
	           double seconds = (double)estimatedTime/1000000000;
	           System.out.println(seconds+" seconds");// calculate time
	            
	        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
       } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
public static void SelectionSort(ArrayList<String> array,int number,int i){// selection sort
   	
		String cvsSplitBy = ",";
    	float[] arr = new float[i];
    	for(int j=0;j<i;j++) {
    		String[] country = ((String) array.get(j+1)).split(cvsSplitBy);
    		arr[j]=Float.parseFloat(country[number-1]);
    	}
	    	for (int k = 0; k < arr.length - 1; k++)
	        {
	            int index = k;
	            for (int j = k + 1; j < arr.length; j++)
	                if (arr[j] < arr[index]) 
	                    index = j;
	      
	            float smallerNumber = arr[index];  
	            arr[index] = arr[k];
	            arr[k] = smallerNumber;
	            String small = (String) array.get(index+1);/*change input line */
	            array.set(index+1, array.get(k+1));
	            array.set(k+1, small);
	        }
    }
public static void InstertionSort(ArrayList<String> array,int number,int i) {// Insertion Sort
    	String cvsSplitBy = ",";
    	float[] arr = new float[i];
    	for(int j=0;j<i;j++) {
    		String[] country = ((String) array.get(j+1)).split(cvsSplitBy);
    		arr[j]=Float.parseFloat(country[number-1]);
    	}
    	float temp;
	        for (int k = 1; k < arr.length; k++) {
	            for(int j = k ; j > 0 ; j--){
	                if(arr[j] < arr[j-1]){
	                    temp = arr[j];/*change array number*/
	                    arr[j] = arr[j-1];
	                    arr[j-1] = temp;
	                    String small = (String) array.get(j+1);/*change input line*/
	                    array.set(j+1, array.get(j));
	                    array.set(j, small);
	                }
	            }
	        }
        }
}