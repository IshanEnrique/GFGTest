package com.gfg.practice;

public class SumOfMinMaxInArray {

	public static void main(String[] args) {

		int A[] = { 1, 2, -4, 5, 3 };
		System.out.println(findSum(A, A.length));
	}
	public static int findSum(int A[], int N) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int a : A) {
			min = a < min ? a : min;
			max = a > max ? a : max;
		}
		return min + max;
	}
}
