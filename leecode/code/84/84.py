class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        res = 0
        rec = list()
        n = len(heights)
        left, right = [0] * n, [n] * n
        for i in range(0, len(heights)):
            while len(rec) > 0 and heights[rec[-1]] > heights[i]:
                k = rec.pop()
                right[k] = i
            left[i] = rec[-1] if rec else -1
            rec.append(i)


        for i in range(0, len(heights)):
            temp = heights[i] * (right[i] - left[i] - 1)
            res = max(res, temp)


        return res