class ArrayStack:

    def __init__(self):
        self.data = []

    def size(self):
        return len(self.data)

    def isEmpty(self):
        return self.size() == 0

    def push(self, item):
        self.data.append(item)

    def pop(self):
        return self.data.pop()

    def peek(self):
        return self.data[-1]

prec = {
    '*': 3, '/': 3,
    '+': 2, '-': 2,
    '(': 1
}

def solution(S):
    opStack = ArrayStack()
    answer = ""
    for x in S:
        if x in ['+','-','*','/']:
            while not opStack.isEmpty() and prec[opStack.peek()] >= prec[x]:
                answer += opStack.pop()
            opStack.push(x)
        elif x == '(':
            opStack.push(x)
        elif x == ')':
            while opStack.peek() != '(':
                answer += opStack.pop()
            opStack.pop()
        else:
            answer += x
    while not opStack.isEmpty():
        answer += opStack.pop()
    return answer

print(solution("(A+B)*(C+D)"))