#@Author=Onkar Shendge

test_cases = int(input())


def solve(n):
    string_n = str(n)
    for i, d in enumerate(string_n):
        int_d = int(d)
        if int_d % 2 != 0:
            if d == '9':
                return n - int(string_n[:i] + str(int_d - 1) + '8' * (len(string_n) - i - 1))
            next = string_n[:i] + str(int_d + 1) + '0' * (len(string_n) - i - 1)
            prev = string_n[:i] + str(int_d - 1) + '8' * (len(string_n) - i - 1)
            return min(int(next) - n, n - int(prev))
    return 0


for i in range(test_cases):
    n = int(input())
    print(f"Case #{i+1}:", solve(n))