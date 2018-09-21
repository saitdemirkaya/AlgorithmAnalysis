import java.util.ArrayList;

public class QuickSort {
     
    private float array1[];
    private int length;
 
    public void sort(ArrayList<String> array,int number, int i) {
    	String cvsSplitBy = ",";
    	float[] arr = new float[i];
    	for(int j=0;j<i;j++) {
    		String[] country = ((String) array.get(j+1)).split(cvsSplitBy);
    		arr[j]=Float.parseFloat(country[number-1]);
    	}
        this.array1 = arr;
        length = arr.length;
        quickSort(array,0, length - 1);
    }
 
    private void quickSort(ArrayList<String> array,int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        float pivot = array1[lowerIndex+(higherIndex-lowerIndex)/2];
        while (i <= j) {
            while (array1[i] < pivot) {
                i++;
            }
            while (array1[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(array,i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        //quickSort() method recursively
        if (lowerIndex < j)
            quickSort(array,lowerIndex, j);
        if (i < higherIndex)
            quickSort(array,i, higherIndex);
    }
 
    private void exchangeNumbers(ArrayList<String> array,int i, int j) {
        float temp = array1[i];
        array1[i] = array1[j];
        array1[j] = temp;
        String small = (String) array.get(i+1);
        array.set(i+1, array.get(j+1));
        array.set(j+1, small);
    }
}