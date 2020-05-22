class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        l = 2 * len(s) - 1


        for i in range(l):
            left = i // 2
            right = i // 2 + i % 2
            temp = ""
            while left >= 0 and right < len(s) and s[left] == s[right]:
                temp = s[left:right + 1]
                left -= 1
                right += 1
            
            if len(temp) > len(res):
                res = temp
        
        return res
            