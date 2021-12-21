class Stack:
    def __init__(self):
        self.items = []

    def push(self, val):
        self.items.append(val)

    def pop(self):
        try:
            return self.items.pop()
        except IndexError:
            print("Stack is empty")

    def top(self):
        try:
            return self.items[-1]
        except IndexError:
            print("Stack is empty")

    def __len__(self):
        return len(self.items)

    def isEmpty(self):
        return self.__len__() == 0

def compute_postfix(postfix):
    s = Stack()
    token_list = postfix.split()
    for token in token_list:
        if token.isnumeric():
            s.push(token)
        elif token in '+-/*^':
            a = float(s.pop())
            b = float(s.pop())
            res = 0

            if token == '+':
                res = b + a
            elif token == '-':
                res = b - a
            elif token == '*':
                res = b * a
            elif token == '/':
                res = b / a
            elif token == '^':
                res = pow(b, a)
            s.push(res)

    return s.pop()

n = input()
print("{:.4f}".format(compute_postfix(n)))