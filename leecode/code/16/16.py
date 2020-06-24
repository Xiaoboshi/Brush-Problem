class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        res = 0
        mins = 100000
        nums.sort()


        for i in range(len(nums)):
            left = i + 1
            right = len(nums) - 1
            while left < right:
                sumt = nums[i] + nums[left] + nums[right]
                temp = sumt - target
                if mins > abs(temp):
                    mins = abs(temp)
                    res = sumt
                
                if mins == 0:
                    return res
                elif temp > 0:
                    right -= 1
                else:
                    left += 1
        return res