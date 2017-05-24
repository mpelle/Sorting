/*
 * Binary Insertion Sort 
 * Matthew Pellegrino
 * Nyit Cs 335
 */

package main;


import java.io.*;

class BinaryIns{


 public String[] values = new String[13]; //stores array of elements
 int[] ints = new int[values.length];
 
 public static void main(String[] args) throws IOException{
	 BinaryIns x=new BinaryIns();
 x.insert();
 }
 
 public void insert() throws IOException{
 int pos; //Position of the key element
 int key; //key element
 new BufferedReader(new InputStreamReader(System.in));
FileInputStream in = new FileInputStream("values.txt");
 BufferedReader brs = new BufferedReader(new InputStreamReader(in));
 try {
     
    try {
		while ((brs.readLine() ) != null) //While there is still a line to read read in 
			{ 
		    
for (int j = 0; j < values.length; j++)
   {
				values[j] = brs.readLine();
		    }
		         
				}
				in.close();
		   
		     
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }finally{} 
	


 for (int i=0; i < values.length; i++) {
	 try {
	        ints[i] = Integer.parseInt(values[i]);
	    } catch (NumberFormatException nfe) {};
 } 


 //insertion sort
 for(int i=1;i<values.length;i++){
 key=ints[i];
 pos=binarySearch(0,i-1,key); //finds where the element will be stored
 for(int j=i;j>pos;j--) //shifts the other elements by 1 position to the right
 ints[j]=ints[j-1];
 ints[pos]=key; //places the key element in the pos position
 }
 
 try {
     PrintStream out = new PrintStream(new FileOutputStream(
         "OutFile.txt"));
     out.println("Sorted Student ID's: " );
    
     for (int j = 0; j <values.length; j++)
        {
       out.println(j+ ":"+ints[j]);
        }
     out.close();
     } 
 
 catch (FileNotFoundException e) {
     e.printStackTrace();
   }
 
 System.out.println("Sorted Student ID's:");//Console output
 //printing the elements
 for(int i=0;i<values.length;i++)
 System.out.println(i+" : "+ints[i]);
 System.out.println("Sent to OutFile.txt");
 }
 //uses binary search to find the position where the element will be inserted
    public int binarySearch(int low,int high,int key){
         int mid;
 while(low<=high)
  {
     mid=(low+high)/2;
 if(key>ints[mid])
       low=mid+1;
 else if(key<ints[mid])
    high=mid-1;
     else
return mid;
  }
 return low;
   }
    
}