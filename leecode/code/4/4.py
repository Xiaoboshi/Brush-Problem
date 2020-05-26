class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        def find(nums1, nums2, k):
            ll = len(nums1)
            lr = len(nums2)


            if ll > lr:
                return find(nums2, nums1, k)
            if ll == 0:
                return nums2[k - 1]
            if k == 1:
                return min(nums1[0], nums2[0])
            l = min(k // 2, ll) - 1
            r = min(k // 2, lr) - 1


            if nums1[l] <= nums2[r]:
                return find(nums1[l + 1:], nums2, k - l - 1)
            else:
                return find(nums1, nums2[r + 1:], k - r - 1)


        ln = (len(nums1) + len(nums2) + 1) // 2
        rn = (len(nums1) + len(nums2) + 2) // 2


        left = find(nums1, nums2, ln)
        right = find(nums1, nums2, rn)


        return (left + right) / 2




