package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/4/14  21:54
 * @description 33
 * 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 *
 *
 * 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
 *
 * 通过次数506,100提交次数1,165,374
 */
public class Solution33 {
    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        int[] arr = {68,69,70,71,72,74,75,77,82,84,90,91,92,93,94,102,104,105,106,107,109,110,111,112,113,114,121,122,123,124,125,127,129,131,132,137,139,142,143,149,151,154,162,166,167,170,172,176,177,179,184,185,187,188,189,193,195,198,202,204,205,206,208,210,211,212,215,221,222,227,230,231,232,235,236,238,239,240,246,247,249,250,253,255,256,261,263,266,267,270,271,273,274,275,276,277,278,280,281,282,285,286,287,289,295,297,299,0,4,7,10,12,15,18,19,24,27,29,30,32,34,35,36,37,41,42,43,44,45,48,52,53,55,65,67};
        int search = solution33.search(arr, 166);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int mid = 0;
        int t = -1;
        int right = nums.length - 1;
        if (nums.length < 100) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        while (left < right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid - 1;
            }
            if (getResult(nums, mid)) {
                t = mid;
                break;
            } else if (getResult(nums, left)) {
                t = left;
                break;
            } else if (getResult(nums, right)) {
                t = right;
                break;
            }
        }
        if (t == -1) {
            return getIndex(nums, left, nums.length - 1, target);
        }
        int index = getIndex(nums, 0, t - 1, target);
        if (index != -1) {
            return index;
        }
        return getIndex(nums, t, nums.length - 1, target);
    }

    private boolean getResult(int[] nums, int mid) {
        if ((mid - 1) >= 0 && (mid + 1) < nums.length && nums[mid - 1] > nums[mid] && nums[mid + 1] > nums[mid]) {
            return true;
        }
        return false;
    }

    public int getIndex(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid1 = (right - left) / 2 + left;
            if (nums[mid1] > target) {
                right = mid1 - 1;
            } else if (nums[mid1] < target) {
                left = mid1 + 1;
            } else {
                return mid1;
            }
        }
        return -1;
    }
}
