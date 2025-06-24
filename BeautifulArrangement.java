// Approach: Backtracking with In-place Swapping
// Generate permutations of 1 to n using swapping.
// At each position idx, only proceed if nums[idx] % (idx+1) == 0 || (idx+1) % nums[idx] == 0.
// This prunes invalid branches early and avoids exploring unnecessary permutations.

// Time Complexity:
// Better than O(n!) due to pruning, but worst-case is O(n!) if all arrangements are valid.
// Actual runtime is much faster because many permutations get skipped due to the divisibility rule.

// Space Complexity:
// O(n) for recursion stack.
// No extra space for visited or boolean arrays since you're modifying nums in-place.

// N factorial version - optimized
class Solution {
    private int count;
    public int countArrangement(int n) {
        int [] nums = new int[n];
        for(int i=0;i<n;++i){
            nums[i] = i+1;
        }
        helper(nums,0,n);
        return count;
    }

    private void helper(int []nums, int idx, int n){
        // base
        if(idx == n){
            count++;
            return;
        }
        for(int i=idx;i<n;++i){
            swap(nums,i, idx);
            // recurse
            if(nums[idx] % (idx+1) == 0 || (idx+1) % nums[idx] == 0)
                helper(nums,idx+1, n);
            // backtrack
            swap(nums,i,idx);
        }
    }

    private void swap(int []nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
