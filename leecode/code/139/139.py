class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * len(s)
        dp.insert(0, True)

        for i in range(1, len(s) + 1):
            for j in range(0, i):
                tmp = s[j: i]
                if dp[j] and tmp in wordDict:
                    dp[i] = dp[j]


        return dp[len(s)]
