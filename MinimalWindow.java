public class Solution {
    public String minWindow(String S, String T) {
		if (S == null || T == null || S.length() < T.length())
			return "";
		boolean[] exist = new boolean[256];
		int[] val = new int[256];
		int count = T.length();
		int end = S.length();
		// get array of which char exist and their times
		for (int i = 0; i < count; i++) {
			exist[T.charAt(i)] = true;
			val[T.charAt(i)]++;
		}
		int slow = 0;
		int fast = 0;
		boolean change = false;
		String res = S;

		while (slow < end && fast < end) {
			// first get fast value
			while (count > 0 && fast < end) {
				if (exist[S.charAt(fast)]) {
					if (val[S.charAt(fast)] > 0)
						count--;
					val[S.charAt(fast)]--;
				}
				fast++;
			}
			// when exit, either count = 0 or we got out of array range, here fast should be the first character we dont need.
			if (count == 0) {
				change = true;

				// here to find slow
				while (count == 0 && slow <= fast) {
					if (exist[S.charAt(slow)]) {
						if (val[S.charAt(slow)] == 0)
							count++;
						val[S.charAt(slow)]++;
					}
					slow++;
				}
				// here slow is the fist character that miss the character we need.
				if (count > 0) {
					String temp = S.substring(slow - 1, fast);
					res = res.length() > temp.length() ? temp : res;
				} else
					return res;
			} else {
				if (!change)
					return "";
			}

		}
		return res;
	}
}
