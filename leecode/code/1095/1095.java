/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length() - 1;
        // int numl = mountainArr.get(left);
        // int numr = mountainArr.get(right);
        int mid = 0;
        // int[] record = new int[mountainArr.length()];

        // 找到 top 值
        while (left <= right) {
            mid = (right - left) / 2 + left;
            // record[mid] = temp;
            // record[mid + 1] = temp2;
            if (mountainArr.get(mid) >= mountainArr.get(mid + 1)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        mid = left;

        left = 0;
        right = mid;
        while (left <= right) {
            int midl = (right - left) / 2 + left;
            if (target == mountainArr.get(midl)) {
                return midl;
            } else if (target < mountainArr.get(midl)) {
                right = midl - 1;
            } else {
                left = midl + 1;
            }
        }

        left = mid;
        right = mountainArr.length() - 1;
        while (left <= right) {
            int midl = (right - left) / 2 + left;
            if (target == mountainArr.get(midl)) {
                return midl;
            } else if (target > mountainArr.get(midl)) {
                right = midl - 1;
            } else {
                left = midl + 1;
            }
        }
        return -1;
    }
}