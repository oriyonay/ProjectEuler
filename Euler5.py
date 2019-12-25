N = 20
factors = {}

# iterate through all the numbers:
for i in range(2, N+1):
    # find the prime factors of i, along with their occurrences:
    div = 3
    iCopy = i
    
    # first, divide by 2. count the occurrences:
    # another way to explain what we're doing here is we're trying to find the highest x such that i is divisible by 2^x (the highest power of 2 that will divide i)
    occurrence = 0
    while iCopy % 2 == 0:
        occurrence += 1
        iCopy /= 2
    if 2 not in factors:
        factors[2] = occurrence
    elif factors[2] < occurrence:
        factors[2] = occurrence
    
    # same thing here, but with the rest of the numbers. we only look at odd numbers here because there's no use checking evens, since we did 2 :)
    while iCopy != 1:
        occurrence = 0
        while iCopy % div == 0:
            occurrence += 1
            iCopy /= div
        if div not in factors:
            factors[div] = occurrence
        elif factors[div] < occurrence:
            factors[div] = occurrence
        div += 2

total = 1   
for key in factors:
    total *= key**factors[key]
print(total)
