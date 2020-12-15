import math
import re

STARTING_NUM = int(math.sqrt(1020304050607080900)) # lowest possible number
ENDING_NUM = int(math.sqrt(1929394959697989990)) # highest possible number

# observation: since the target square ends in 0, its square root must also
# end in 0 (and thus be divisible by 10). this means that we can skip by 10s.
# STARTING_NUM is already divisible by 10 when rounded down, so we don't need
# to do anything.

for num in range(STARTING_NUM, ENDING_NUM, 10):
    square_num = str(num*num)
    if re.fullmatch('1\d2\d3\d4\d5\d6\d7\d8\d9\d0', square_num) != None:
        print('number: %d' % num)
        print('square number: %s' % square_num)
        break
