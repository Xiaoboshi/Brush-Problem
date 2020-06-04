class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        rec = [1] * n
        rec2 = [1] * n
        temp = 1


        for i in range(1, n):
            rec[i] = nums[i - 1] * rec[i - 1]
        
        rec[n - 1] *= temp
        for i in range(n - 2, -1, -1):
            temp = nums[i + 1] * temp
            rec[i] *= temp


        return rec