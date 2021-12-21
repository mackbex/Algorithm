def binary(n):
    if(n<2):
        print(n , end='')
    else:
        print(n%2 , end='')
        binary(n//2)

binary(6)