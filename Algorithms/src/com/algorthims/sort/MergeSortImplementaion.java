/**
 * 
 */
package com.algorthims.sort;

/**
 * @author vsubramaniyan
 *
 */
public class MergeSortImplementaion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] source = new int[]{14, 7, 3, 12, 9, 11, 6, 2, 1};  
		splitArray(source, new int[source.length/2], new int[source.length - (source.length/2)]);
		for(int i :source) System.out.println(i); //Expected Output -- 2,3,6,7,9,11,12,14
		
	}
	
	public static void splitArray(int [] source, int [] leftArray, int [] rightArray ){
		int i=0, j=0;//14, 7, 3, 12
		while(i < leftArray.length ) 
		 {
			leftArray[i] = source[i];
			i++;
		 }//9, 11, 6, 2, 1
		while(j < rightArray.length ) 
			
		 {
			rightArray[j++] = source[i++];
		 }
		
		//Dont split if the array has only one element.   left array will be empty if its a single element
		if(source.length >=2) {
			splitArray(leftArray, new int[leftArray.length/2], new int[leftArray.length - (leftArray.length/2)]);
			splitArray(rightArray, new int[rightArray.length/2], new int[rightArray.length - (rightArray.length/2)]);
			
		}
		mergeArray(source, leftArray, rightArray);
		
	}
	public static void mergeArray(int[] source, int []leftArray, int[] rightArray){
		int i=0, j=0, k=0;
		while(j<leftArray.length && k < rightArray.length)
		{
			if(leftArray[j]>rightArray[k] )
				source [i++] =rightArray[k++];
			else
				source [i++] =leftArray[j++];
		}
		while(k < rightArray.length){
			source [i++] =rightArray[k++];
		}
		while(j<leftArray.length){
			source [i++] =leftArray[j++];
		}
	}

}
