/* Two Sum
https://leetcode.com/problems/two-sum/
Runtime: 2ms
Time Complexity: O (N logN) */
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        sort(pairs, 0, nums.length-1);
        for (int i = 0; i < pairs.length; i++) {
            int tg = target - pairs[i].val;
            int ind = binarySearch(pairs, tg);
            if (ind == i)
                continue;
            if (ind >= 0) {
                result[0] = pairs[i].index;
                result[1] = pairs[ind].index;
                break;
            }
        }
        return result;
    }
    
    void merge(Pair arr[], int l, int m, int r) { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
        
        Pair L[] = new Pair[n1]; 
        Pair R[] = new Pair[n2]; 
        for (int i = 0; i < n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j = 0; j < n2; ++j) 
            R[j] = arr[m + 1 + j]; 
        
        int i = 0, j = 0; 
        int k = l; 
        while (i < n1 && j < n2) { 
            if (L[i].val <= R[j].val) { 
                arr[k] = L[i]; 
                i++; 
            } 
            else {
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        while (j < n2) { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
    
    void sort(Pair arr[], int l, int r) 
    { 
        if (l < r) { 
            int m = (l + r) / 2; 
            sort(arr, l, m); 
            sort(arr, m + 1, r); 
  
            merge(arr, l, m, r); 
        } 
    } 
    
    public int binarySearch(Pair arr[], int x) {
        int n = arr.length;
        int high = n - 1;
        int low = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid].val == x) {
                return mid;
            } else if (arr[mid].val < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    
    class Pair {
        int val;
        int index;
        public Pair(int v, int i) {
            val = v;
            index = i;
        }
    }
}


