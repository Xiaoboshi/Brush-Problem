class Solution {


    public int findknums(int[] nums1, int[] nums2, int s1, int e1, int s2, int e2, int k) {
        int len1 = e1 - s1 + 1;
        int len2 = e2 - s2 + 1;
        if (len1 > len2) return findknums(nums2, nums1, s2, e2, s1, e1, k);
        if (len1 == 0) return nums2[s2 + k - 1];


        int i = s1 + Math.min(len1, k / 2) - 1;
        int j = s2 + Math.min(len2, k / 2) - 1;


        if (k == 1) return Math.min(nums1[s1], nums2[s2]);


        if (nums1[i] < nums2[j]) {
            return findknums(nums1, nums2, i + 1, e1, s2, e2, k + s1 - 1 - i);
        } else {
            return findknums(nums1, nums2, s1, e1, j + 1, e2, k + s2 - 1 - j);
        }
    }



    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nlen1 = nums1.length;
        int nlen2 = nums2.length;
        int len = nums1.length + nums2.length;
        int len1 = (len + 1) / 2;
        int len2 = (len + 2) / 2;
        return (findknums(nums1, nums2, 0, nlen1 - 1, 0, nlen2 - 1, len1)
                + findknums(nums1, nums2, 0, nlen1 - 1, 0, nlen2 - 1, len2)) * 0.5;
    }
}