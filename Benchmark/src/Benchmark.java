import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Benchmark {
	  public static void main(String[] args) throws FileNotFoundException {
		  	
			
			int[] n = {1000, 2000,3000,4000,5000,6000,7000,8000,9000,10000,15000,20000,25000};
			ArrayList<String> output1 = new ArrayList<>();
			ArrayList<String> output2 = new ArrayList<>();
			ArrayList<String> output3 = new ArrayList<>();
			ArrayList<String> output4 = new ArrayList<>();
			ArrayList<String> output5 = new ArrayList<>();
			MyQuickSort sorter = new MyQuickSort();
			
			long start, duration;
			// TODO change SOP to PrintWriter
			
			for (int i = 0; i < n.length; i++) {
				
				int [] list = buildArray(n[i]);
				int[] list2 = Arrays.copyOf(list, list.length);

				start = System.currentTimeMillis();
				insertionSort(list2);
				duration = System.currentTimeMillis() - start;
				output1.add("insertion,"+ n[i] + "," + duration);

				int[] list3 = Arrays.copyOf(list, list.length);
				try {
					start = System.currentTimeMillis();
					sorter.sort(list3);
					duration = System.currentTimeMillis() - start;
					output2.add("quick,"+ n[i] + "," + duration);
					
				} catch (StackOverflowError soe) {
					System.out.println("quick,"+ n[i] + "," + "overflow");
				}
				
				int[] list4 = Arrays.copyOf(list, list.length);
				start = System.currentTimeMillis();
				selectionSort(list4);
				duration = System.currentTimeMillis() - start;
				output3.add("selection," + n[i] +"," + duration);
				
				int[] list5 = Arrays.copyOf(list, list.length);
				start = System.currentTimeMillis();
				bubbleSort(list5);
				duration = System.currentTimeMillis() - start;
				output4.add("bubble," + n[i] +"," + duration);
				
				int[] list6 = Arrays.copyOf(list, list.length);
				start = System.currentTimeMillis();
				mergeSort(list6,0,list6.length-1);
				duration = System.currentTimeMillis() - start;
				output5.add("merge," + n[i] +"," + duration);
				
			}
			PrintWriter writer = null;
			writer = new PrintWriter("output.csv");
			
			writer.println(output1);
			writer.println(output2);
			writer.println(output3);
			writer.println(output4);
			writer.println(output5);
						

			writer.close();
			
			
			
				System.out.println(output1);
				System.out.println(output2);
				System.out.println(output3);
				System.out.println(output4);
				System.out.println(output5);
		}
		
		private static int[] buildArray(int n) {
			Random rand = new Random();
			int[] i = new int[n];
			for(int j = 0; j < n; j++) {
	            i[j] = rand.nextInt(n);			
			}
			return i;
		}
		
		public static void insertionSort(int [] a)
		{
			for (int i = 1; i < a.length;i++)
			{
				int temp = a[i];
				int j;
				for(j = i-1;j>= 0 && temp < a[j]; j--)
				{
					a[j+1] = a[j];
				}
				a[j+1] = temp;
			}
		}
		
		
		public static void selectionSort(int[] arr)
		{ for (int i = 0; i < arr.length - 1; i++) 
			{ 
			int index = i; for (int j = i + 1; j < arr.length; j++) 
				if (arr[j] < arr[index]) 
					index = j; int smallerNumber = arr[index]; arr[index] = arr[i]; arr[i] = smallerNumber; 
			} 
		}
		
		public static void bubbleSort(int[] arr){
	        int temp;
	        for(int i=0; i < arr.length-1; i++){
	 
	            for(int j=1; j < arr.length-i; j++){
	                if(arr[j-1] > arr[j]){
	                    temp=arr[j-1];
	                    arr[j-1] = arr[j];
	                    arr[j] = temp;
	                }
	            }
	            }
	        }
		
		public static void mergeSort(int[] a, int low, int high) 
	    {
	        int N = high - low;         
	        if (N <= 1) 
	            return; 
	        int mid = low + N/2; 
	        // recursively sort 
	        mergeSort(a, low, mid); 
	        mergeSort(a, mid, high); 
	        // merge two sorted sub-arrays
	        int[] temp = new int[N];
	        int i = low, j = mid;
	        for (int k = 0; k < N; k++) 
	        {
	            if (i == mid)  
	                temp[k] = a[j++];
	            else if (j == high) 
	                temp[k] = a[i++];
	            else if (a[j]<a[i]) 
	                temp[k] = a[j++];
	            else 
	                temp[k] = a[i++];
	        }    
	        for (int k = 0; k < N; k++) 
	            a[low + k] = temp[k];         
	    }
	   
		}
