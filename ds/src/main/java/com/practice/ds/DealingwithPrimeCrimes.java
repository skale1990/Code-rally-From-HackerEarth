package com.practice.ds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class DealingwithPrimeCrimes {
	private static long[][] graph = null;
	private static ArrayList<Long> primes = new ArrayList<Long>();
	private static long[] finalArray = null;
	private static int number;
	private static int status=1,i=2,j=2;
	private static long num=3;
	private static Queue<Integer> queue=  null ;
	private static int[] lookup = null ;
	
	


	public static void readyPrimes(long n) {
		if(primes.size()>=n) return;
		if (primes.size()==0) {
			primes.add(2l);
		}

		for ( i = 2; i <= n;) {
			for ( j = 2; j <= Math.sqrt(num); j++) {
				if (num % j == 0) {
					status = 0;
					break;
				}
			}
			if (status != 0) {
				primes.add(num);
				i++;
			}
			status = 1;
			num++;
		}
	}

	public static long findPrimeCrimes() {
		long sum = 0;
		queue.offer(1);
		lookup[1] = 1;
		int i , j ,count=1;
		while (!queue.isEmpty()) {
			i=queue.poll();
			
			for ( j = 1; j<=number;j++){
				
				if (i != j && graph[i][j] > 0) {
					//sum = sum + graph[i][j];
					if (lookup[j] != 1) {
						lookup[j]=1;
						sum = sum + graph[i][j];
						queue.offer(j);
						++count;
						if (count==number) {
							queue.clear();
							break;
						}
					}
				}
			}
//			if (i <number && count != number && queue.isEmpty()) {
//				++i;
//				queue.add(i);
//				lookup[i]=1;
//			}
		}
		
		return sum;

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testcase = Integer.parseInt(br.readLine());
		finalArray = new long[testcase];
		StringTokenizer st = null;
		int connections, a, b;
		long prime;
		for (int i = 1; i <= testcase; i++) {
			st = new StringTokenizer(br.readLine());
			number = Integer.parseInt(st.nextToken());
			graph=null;
			graph = new long[number + 1][number + 1];
			queue = new PriorityQueue<>(number);
			lookup = new int[number+1] ;
			
			readyPrimes(number);
			
			connections = Integer.parseInt(st.nextToken());
			
				for (int j = 1; j <= connections; j++) {
					st = new StringTokenizer(br.readLine());
					a = Integer.parseInt(st.nextToken());
					b = Integer.parseInt(st.nextToken());
					prime = primes.get(b - 1) * primes.get(a - 1);
					graph[b][a] = prime;
					graph[a][b] = prime;	
//					if (a>b) {
//						graph[b][a] = prime;
//					}
//					else
//						graph[a][b] = prime;					
					
				}
				if (connections >=number-1) {
				finalArray[i - 1] = findPrimeCrimes();
			}
			
			
			

		}
		br.close();

		PrintStream psConsole = new PrintStream(System.out);
		for (Long i : finalArray) {
			if (i!=0) {
				psConsole.write(i.toString().getBytes());
			}
			psConsole.println();
		}
		psConsole.flush();
		psConsole.close();

	}

}
