class Solution:
    def minWindow(self, s: str, t: str) -> str:
        res = ""
        left, right, count, maxl = 0, 0, 0, len(s) + 1


        dic = {k: t.count(k) for k in t}
        dicw = {k : 0 for k in t}


        while right < len(s) and len(s) >= len(t):
            while right < len(s) and count < len(t):
                if s[right] in dic:
                    if dicw[s[right]] < dic[s[right]]:
                        count += 1
                    dicw[s[right]] += 1
                right += 1


            if count < len(t):
                break
                
            while count >= len(t) and left < right:
                if s[left] in dic:
                    dicw[s[left]] -= 1
                    if dicw[s[left]] < dic[s[left]]:
                        count -= 1
                left += 1


            if right - left + 1 >= len(t):
                temp = s[left - 1 : right]
                if len(temp) < maxl:
                    res = temp
                    maxl = len(temp)
        return res