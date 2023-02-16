// The stock span problem is a financial problem where we have a series of N daily price quotes for a 
// stock and we need to calculate the span of the stock’s price for all N days. The span Si of the 
// stock’s price on a given day i is defined as the maximum number of consecutive days just before 
// the given day, for which the price of the stock on the current day is less than its price on the given day. 

// Input: N = 7, price[] = [100 80 60 70 60 75 85]
// Output: 1 1 1 2 1 4 6

// Input: N = 6, price[] = [10 4 5 90 120 80]
// Output:1 1 2 4 5 1

// Java program for brute force method
// to calculate stock span values

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class StockSpan {

	static ArrayList<Integer> calculateSpan(int arr[], int n){
		Deque<Integer> s = new ArrayDeque<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			while (!s.isEmpty() && arr[s.peek()] <= arr[i])
				s.pop();

			if (s.isEmpty())
				ans.add(i + 1);
			else {
				int top = s.peek();
				ans.add(i - top);
			}
			s.push(i);
		}

		return ans;
	}

	static void printArray(ArrayList<Integer> arr)	{
		for (int i = 0; i < arr.size(); i++)
			System.out.print(arr.get(i) + " ");
	}

	public static void main(String args[])	{
		int price[] = { 10, 4, 5, 90, 120, 80 };
		int n = price.length;

		ArrayList<Integer> arr = calculateSpan(price, n);
		printArray(arr);
	}
}
