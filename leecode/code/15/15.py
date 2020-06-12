class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        if len(nums) < 3:
            return []


        nums.sort()
        if nums[0] > 0 or nums[len(nums) - 1] < 0:
            return []   
        
        res = []
        for i in range(0, len(nums), 1):
            if nums[i] > 0:
                return res
            
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            temp = nums[i]


            left = i + 1
            right = len(nums) - 1


            while left < right:
                sumt = temp + nums[left] + nums[right]
                if sumt == 0:
                    tmp = [nums[i], nums[left], nums[right]]
                    res.append(tmp)
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    left += 1
                    right -= 1 
                elif sumt > 0:
                    right -= 1
                
                else:
                    left += 1
            # for j in range(len(nums) - 1, -1, -1):
            #     if (nums[i] > 0 and nums[j] > 0) or (nums[i] < 0 and nums[j] < 0):
            #         continue
                
            #     temp = nums[i] + nums[j]


            #     for k in range(i + 1, j, 1):
            #         if temp + nums[k] == 0:
            #             tmp = [nums[i], nums[k], nums[j]]
            #             if tmp not in res:
            #                 res.append(tmp)


        return res


