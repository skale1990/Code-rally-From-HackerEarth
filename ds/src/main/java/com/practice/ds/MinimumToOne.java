package com.practice.ds;


/*Problem Statement: On a positive integer, you can perform any one of the following 3 steps. 
 * 1.) Subtract 1 from it. ( n = n - 1 )  , 
 * 2.) If its divisible by 2, divide by 2. ( if n % 2 == 0 , then n = n / 2  )  , 
 * 3.) If its divisible by 3, divide by 3. ( if n % 3 == 0 , then n = n / 3  ). 
 * Now the question is, given a positive integer n, find the minimum number of steps that takes n to 1
eg: 
1.)For n = 1 , output: 0       
2.) For n = 4 , output: 2  ( 4  /2 = 2  /2 = 1 )    
3.)  For n = 7 , output: 3  (  7  -1 = 6   /3 = 2   /2 = 1 )
*/

public class MinimumToOne {
	//public int n=0;
	public int[] minsteps = null;
	
	public MinimumToOne(int n) {
		// TODO Auto-generated constructor stub
		minsteps = new int[n+1];
		for (int i = 0; i < minsteps.length; i++) {
			minsteps[i]=-1;
		}
		System.out.println(findMinStepsUsingMemoization(n));
		for (int i = 0; i < minsteps.length; i++) {
			System.out.println("minstep for "+i+" is: "+minsteps[i]);
		}
		System.out.println(findMinStepsUsingTabulation(n));
	}
	
	public int findMinStepsUsingMemoization(int n) {
		if (n==1) {
			minsteps[1]=0;
			return 0;
		}
		
		if (minsteps[n] != -1) {
			System.out.println("Already Calculated for "+ n+ ":"+minsteps[n]);
			return minsteps[n];
		}
		
		//recurrence relation
		//min(n)=1+min(minSteps(n-1),)
		int min = 1 + findMinStepsUsingMemoization(n-1);
		if (n%2==0) 
			min = min(min, 1+findMinStepsUsingMemoization(n/2));
		if (n%3==0) 
			min = min(min, 1+findMinStepsUsingMemoization(n/3));
		minsteps[n]=min;
		return min;
	}
	
	public int findMinStepsUsingTabulation(int n) {
		
		int i;
		minsteps[1] = 0;  // trivial case
		for( i = 2 ; i <= n ; i ++ )
		{
			minsteps[i] = 1 + minsteps[i-1];
		if(i%2==0) minsteps[i] = min( minsteps[i] , 1+ minsteps[i/2] );
		if(i%3==0) minsteps[i] = min( minsteps[i] , 1+ minsteps[i/3] );
		System.out.println("Min Step using tabulation for "+i + "is:"+minsteps[i]);
		}
		return minsteps[n];
		
	}
	
	public int min(int a, int b) {
		if (a>b) {
			return b;
		}
		return a;
		}
	
	public static void main(String[] args) {
		MinimumToOne minimumToOne = new MinimumToOne(111);
		
	}
	
	
}
