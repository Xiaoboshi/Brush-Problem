class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        record = {}
        record[0] = 1;
        res = 0
        pre = 0


        for i in nums:
            pre += i
            res += record.get(pre - k, 0)
            record[pre] = record.get(pre, 0) + 1


        return res 
            
            


