package Homework1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class BinarySearchRecursive {

	public static final int notFound = -1;

	// use two comparisons per level.
	// This method calls the recursive method.

	public int binarySearch(int[] a, int x) {
		return binarySearch(a, x, 0, a.length - 1);
	}

	// need extra low and high parameters
	private int binarySearch(int[] a, int x, int low, int high) {
		if (low > high) {
			return notFound;
		}
		int mid = (low + high) / 2;
		if (a[mid] == x) {
			return mid;
		} else if (a[mid] < x) {
			return binarySearch(a, x, mid + 1, high);

		} else // last possibility
		{
			return binarySearch(a, x, low, mid - 1);
		}

	}

	public static void main(String[] args) throws IOException {

		Scanner s = new Scanner(new File("array.txt"));

		File file = new File("array.txt");
		//convert to bytes
		byte[] bytes = new byte[(int) file.length()];

		FileInputStream fis = new FileInputStream(file);
        //read in the bytes
		fis.read(bytes);
		fis.close();

		String[] valueStr = new String(bytes).trim().split("\\s+");
		int[] integers = new int[valueStr.length];

		for (int i = 0; i < valueStr.length; i++)
			integers[i] = Integer.parseInt(valueStr[i]);

		// System.out.println(Arrays.toString(integers));

		BinarySearchRecursive bin = new BinarySearchRecursive();

		System.out.println("Please enter the search key");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();

		if (bin.binarySearch(integers, num) == -1) {
			System.out.println(num + " is not found");
		} else
			System.out.println(num + " is found at index "
					+ bin.binarySearch(integers, num));

	}

}
