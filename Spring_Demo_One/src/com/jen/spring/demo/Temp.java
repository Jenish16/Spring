package com.jen.spring.demo;

import java.util.Random;

public class Temp {
	
	public static void main (String ... arg) throws Exception
	{
		Random rand = new Random();
		int []arr1 = new int[100000];
		int []arr2 = new int[100000];
		int n = 1;
		long old = 0;
		long neww = 0;

		while(n<10000)
		{
			arr1 = new int[100000];
			arr2 = new int[100000];
			for (int i = 1 ; i < 100000 ; i++)
			{
				arr1[i] = rand.nextInt(i*n);
				arr2[i] = arr1[i]; 
			}
			long start=0,end=0;
			start = System.nanoTime();
			for(int i = 0 ; i < arr2.length ; i++)
			{
				arr2[i] = arr2[i] * 2;
				arr2[i] = arr2[i] * 4;
				arr2[i] = arr2[i] * 8;
				arr2[i] = arr2[i] * 16;
				arr2[i] = arr2[i] * 32;
				arr2[i] = arr2[i] * 64;
				arr2[i] = arr2[i] * 128;
				arr2[i] = arr2[i] * 256;
				arr2[i] = arr2[i] * 512;
				arr2[i] = arr2[i] * 1024;
			}
			end = System.nanoTime();
			old = old + (end - start);
			System.out.println("Time taked in normal :" + (end - start));
			
			
			start = System.nanoTime();
			for(int i = 0 ; i < arr1.length ; i++)
			{
				arr1[i] = arr1[i] << 1;
				arr1[i] = arr1[i] << 2;
				arr1[i] = arr1[i] << 3;
				arr1[i] = arr1[i] << 4;
				arr1[i] = arr1[i] << 5;
				arr1[i] = arr1[i] << 6;
				arr1[i] = arr1[i] << 7;
				arr1[i] = arr1[i] << 8;
				arr1[i] = arr1[i] << 9;
				arr1[i] = arr1[i] << 10;
			}
			end = System.nanoTime();
			neww = neww + (end - start);
			System.out.println("Time taked in new :" + (end - start));
			
			
			for(int i = 0 ; i < arr1.length ; i++)
			{
				if(arr1[i] != arr2[i])
				{
					System.out.println("Not equal");
					throw new Exception();
				}
			}
			n++;
		}
		System.out.println("final old : " + (old));
		System.out.println("final new : " + (neww));
	}

}