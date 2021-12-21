import collections

class Solution:
    def isPossibleDivide(self, nums: [int], k: int) -> bool:
        c = collections.Counter(nums)
        for i in sorted(c):
            if c[i]> 0:
                for j in range(k)[::-1]:
                    c[i+j] -= c[i]
                    if c[i+j] < 0:
                        return False

        return True


A = [1,2,3,3,4,4,5,6]
B = 4

C = Solution()

print(C.isPossibleDivide(A,B))