class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        nums.sort()
        res = 1
        
        for i in nums:
            if i > 0:
                if i > res:
                    break
                elif i == res:
                    res += 1
                else:
                    continue
        return res