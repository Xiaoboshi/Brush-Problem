class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        slow = 0
        fast = 0
        count = 1


        while fast != slow or count == 1:
            fast = nums[nums[fast]]
            slow = nums[slow]
            count += 1
        
        slow = 0
        while slow != fast:
            slow = nums[slow]
            fast = nums[fast]
        
        return fast