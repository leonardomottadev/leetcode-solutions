import java.util.HashMap;

/*

You are given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.

You may assume that each input would have exactly one solution, and you may not use the *same* element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

- 2 <= nums.length <= 104
- 109 <= nums[i] <= 109
- 109 <= target <= 109

*/

class Solution 
{
    public static void main(String[] args) {
        int[] example1Array = {2, 7, 11, 15};
        int example1Target = 9;

        int[] example2Array = {3, 2, 4};
        int example2Target = 6;

        int[] example3Array = {3, 3};
        int example3Target = 6;

        printArray(twoSum(example1Array, example1Target), example1Target);
        printArray(twoSum(example2Array, example2Target), example2Target);
        printArray(twoSum(example3Array, example3Target), example3Target);
    }

    public static int[] twoSum(int[] nums, int target) 
    {
       HashMap<Integer,Integer> map = new HashMap<>();
       int [] result = new int[2];
       for(int i = 0; i < nums.length; i++) 
       {
           if(map.containsKey(target - nums[i])) 
           {
               result[0] = i;
               result[1] = map.get(target - nums[i]);
               return result;
           }
           map.put(nums[i], i);
       }
       return result;
    }

    public static void printArray(int[] nums, int target) 
    {
        System.out.print("[");
        for(int i = 0; i < nums.length; i++) 
        {
            String format = ((i + 1) < nums.length) ? "%d," : "%d";
            System.out.print(String.format(format, nums[i]));
        }
        System.out.print("]\n");
        System.out.println(String.format("target: %d", target));
    }
}