package com.unibit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		int[] arr = {1,3,2,2,-4,-6,-2,8};
		int k = 4;
		
		solution(arr , k);
	}
	
	
	public static void solution(int[] arr , int k) {
		
		Set<List<Integer>> set = new LinkedHashSet<>();
		
		//first Solution
		combinationForTargetValue(arr,k,set);
		System.out.println("First Combination For “4” : "+set);
		
		
		
		
		//Second Solution
		List<Integer> sortedCombinedList = new ArrayList<>();
		for(List<Integer> i: set ) {
			sortedCombinedList.addAll(i);
		}
		Collections.sort(sortedCombinedList);
		System.out.println("Merge Into a single Array : "+sortedCombinedList);
		
		
		
		
		//Third Solution
		k = 2*k;
		Integer[] digits = sortedCombinedList.toArray(new Integer[0]);
		List<Integer> currentCombination = new ArrayList<>();
		Set<List<Integer>> result = new LinkedHashSet<>();
		combinationForDoubledTaggetValue(k,digits,0,currentCombination,result);
		System.out.println("Second Combination For “8” : "+result);
		
	}
	
	public static void combinationForTargetValue(int[] arr , int k , Set<List<Integer>> set) {
		
		int n = arr.length;
		
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				List<Integer> innerList = new ArrayList<>();
				if(Math.abs( arr[i]+arr[j])==k) {
					innerList.add(arr[i]);
					innerList.add(arr[j]);
					set.add(innerList);
					
				}
			}
		}
	}
	
	public static void combinationForDoubledTaggetValue(int k , Integer[] arr ,int index,List<Integer> currentCombination, Set<List<Integer>> result ) {
		
		
		
		if(k==0) {
			result.add(new ArrayList<>(currentCombination));
		}
		
		
		if(index>=arr.length || k<0) {
			return;
		}
		
		
		for(int i=index;i<arr.length;i++) {
			currentCombination.add(arr[i]);
			combinationForDoubledTaggetValue(k - arr[i], arr, i + 1, currentCombination, result);
			currentCombination.remove(currentCombination.size() - 1);
		}
	}
	
}
