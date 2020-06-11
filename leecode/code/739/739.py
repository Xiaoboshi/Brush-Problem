class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        rec = list()
        res = [0] * len(T)


        for i in range(len(T) - 1, -1, -1):
            while len(rec) > 0 and T[rec[len(rec) - 1]] <= T[i]:
                rec.pop()
            
            if len(rec) == 0:
                res[i] = 0
            else:
                res[i] = rec[len(rec) - 1] - i
            
            rec.append(i)
            
        
        return res