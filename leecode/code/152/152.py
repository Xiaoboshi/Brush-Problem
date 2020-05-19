class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res, lmax, lmin = nums[0], nums[0], nums[0]
        for i in range(1, len(nums)):
            x = lmax
            n = lmin
            lmax = max(x * nums[i], n * nums[i], nums[i])
            lmin = min(n * nums[i], x * nums[i], nums[i])


            res = max(res, lmax, lmin)
        
        return res