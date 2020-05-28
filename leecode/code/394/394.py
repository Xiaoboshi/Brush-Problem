class Solution:
    def decodeString(self, s: str) -> str:
        if len(s) == 0:
            return ""
        
        res = ""


        # 去掉字母
        i = 0
        while i < len(s):
            if (s[i] < '0' or s[i] > '9') and s[i] != '[' and s[i] != ']':
                i += 1
            else:
                break
        
        res = res + s[0: i]
        # 数字开头    
        s  = s[i:]
        i = 0
        num = 0
        while i < len(s) and s[i] <= '9' and s[i] >= '0':
            num = num * 10 + int(s[i])
            i += 1


        if num > 0:
            s = s[i:]
            i = 0
            count = 0
            if s[i] == '[':
                while i < len(s):
                    if s[i] == '[':
                        count += 1
                    elif s[i] == ']':
                        count -= 1
                    i += 1


                    if count == 0:
                        break
                
            temp = self.decodeString(s[1: i - 1])
            s = s[i:]
            if num > 0:
                for i in range(num):
                    res = res + temp


        return res + self.decodeString(s)