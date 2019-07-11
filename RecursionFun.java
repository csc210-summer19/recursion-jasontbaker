/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Your Name
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 0) {
			return 1;
		}
		if (k == n) {
			return 1;
		} else {
			return combinations(n - 1, k - 1) + combinations(n - 1, k);
		}
	}

	// Complete recursive method intWithCommas that returns the argument as a
	// String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		// TODO: Implement this method using recursion. Do not use a loop
		String num = Integer.toString(n);
		if (num.length() <= 3) {
			return num;
		} else {
			int intnum = Integer.parseInt(num.substring(0, num.length() - 3));
			return intWithCommas(intnum) + ","
					+ num.substring(num.length() - 3);
			}
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length);
	}

	private void reverseArray(int[] x, int index, int len) {
		// TODO: Complete this method with a recursive algorithm.
		// Do NOT use a loop.
		if (index == len / 2) {
			return;
		} else {
			int tempfront = x[index];
			int tempback = x[len - index - 1];
			x[index] = tempback;
			x[len - index - 1] = tempfront;
			reverseArray(x, index + 1, len);
		}
	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		int mx = Integer.MIN_VALUE;
		int mn = Integer.MAX_VALUE;
		int index = 0;
		int range = arrayRange(a, mx, mn, index);
		return range;
	}

	public int arrayRange(int[] a, Integer mx, Integer mn, int index) {
		if (index < a.length) {
			mx = Math.max(mx, a[index]);
			mn = Math.min(mn, a[index]);
			return arrayRange(a, mx, mn, index + 1);
		}
		return mx - mn;
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		// Need to send down 0 to keep track of the index
		int index = 1;
		return isSorted(nums, index);
	}

	public boolean isSorted(int[] nums, int index) {
		if (index >= nums.length) {
			return true;
		} else {
			if (nums[index - 1] > nums[index]) {
				return false;
			} else {
				return isSorted(nums, index + 1);
			}
		}
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		int index = 0;
		return found(search, strs, index);
	}

	public boolean found(String search, String[] strs, int index) {
		if (index < strs.length) {
			if (strs[index].equals(search)) {
				return true;
			} else {
				return found(search, strs, index + 1);
			}
		}
		return false;
	}
}
