# Euler17, rewritten in python
nums = {0:0, 1:3, 2:3, 3:5, 4:4, 5:4, 6:3, 7:5, 8:5, 9:4, 10:3,
    11:6, 12:6, 13:8, 14:8, 15:7, 16:7, 17:9, 18:8, 19:8, 20:6,
    30:6, 40:5, 50:5, 60:5, 70:7, 80:6, 90:6
}

def numLetters(n):
    sum = 0
    if n % 100 == 0: return nums[n//100] + 7
    if n >= 100: 
        sum = nums[n//100] + 10
        n = n % 100
    try:
        return sum + nums[n]
    except:
        return sum + nums[(n//10)*10] + nums[n%10]

print(sum(numLetters(i) for i in range(1, 1000)) + 11)