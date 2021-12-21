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

# pseudo code
def parChecker(parSeq):

    try:
        s = Stack()
        for el in parSeq:
            if el == "(":
                s.push(el)
            elif el == ")":
                s.pop()

        if len(s) == 0:
            return True
        else:
            return False
    except:
        return False
par = input()
print(parChecker(par))

