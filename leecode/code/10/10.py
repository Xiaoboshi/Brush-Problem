class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        if len(p) == 0:
            return len(s) == 0
        else: 
            flag = len(s) > 0 and (s[0] == p[0] or p[0] == '.')


            if len(p) > 1 and p[1] == '*':
                return self.isMatch(s, p[2:]) or (flag and self.isMatch(s[1:], p))
            
            else:
                return (flag and self.isMatch(s[1:], p[1:]))