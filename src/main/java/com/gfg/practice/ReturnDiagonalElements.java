package com.gfg.practice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class ReturnDiagonalElements {

	public static void main(String[] args) {

		String path = "C://Users//omnie//Documents//fileInput.txt";
		String outputPath = "C://Users//omnie//Documents//fileOutput.txt";
		try {

			System.setOut(new PrintStream(outputPath));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Stream<String> stream=Files.lines(Paths.get(path));
				
				/*BufferedReader stream = new BufferedReader(new InputStreamReader(new FileInputStream(path)));*/) {

			int A[][] = 
					stream.map(s -> Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray())
							.toArray(int[][]::new);

//			int A[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
			System.out.println("Output : " + downwardDigonal(A.length, A));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static ArrayList<Integer> downwardDigonal(int n, int arr[][]) {
		ArrayList<Integer> downardDigonal = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
//				System.out.print("\t " + arr[i][j] + " (" + i + "," + j + ")");
				System.out.print("\t " + arr[i][j]);
			}
			System.out.println("\n");
		}

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println();
		boolean reverse = false;
		for (int i = 0; i < n; i++) {
			if (!reverse) {
				for (int j = i, k = 0; j >= 0; j--, k++) {
					downardDigonal.add(arr[k][j]);
					System.out.print(" " + arr[k][j]);
				} 
			} else {
				for (int j = n - 1, k = i; k < n; j--, k++) {
					downardDigonal.add(arr[k][j]);
					System.out.print(" " + arr[k][j]);
				}
			}
			if (i == n - 1 && !reverse) {
				i = 0;
				reverse = true;
			}
			System.out.println();
		}
		System.out.println();
		return downardDigonal;
	}
}
