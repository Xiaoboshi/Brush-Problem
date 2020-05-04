class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = 0;
        left = 0;
        right = 0;
        
        while left <= right and right < len(s) :
            record = set()
            while right < len(s) and s[right] not in record :
                record.add(s[right])
                right += 1
            
            res = max(len(record), res)
            left += 1
            right = left     
        return res