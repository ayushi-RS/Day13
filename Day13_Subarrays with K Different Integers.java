class Solution {
    // number of subarrays with k diff integers = number of subarrays with at most k diff integers - number of subarrays with atmost k-1 diff integers
    public int subarraysWithKDistinct(int[] nums, int k) {
        return count(nums,k) - count(nums,k-1);
    }
    public int count(int[] nums,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int start = 0,end = 0, res = 0;
        while(end < nums.length){
            map.put(nums[end],map.getOrDefault(nums[end],0)+1);
            while(start <= end && map.size() > k){
                if(map.containsKey(nums[start])) map.put(nums[start],map.get(nums[start])-1);
                if(map.get(nums[start]) == 0) map.remove(nums[start]);
                start++;
            }
            res+= (end - start + 1);
            end++;
        }
        return res;
    }
}