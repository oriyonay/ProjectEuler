import numpy as np

f = open('p099_base_exp.txt')
largest_log_val = 0
largest_line_num = 0

line_num = 1
for line in f.readlines():
    a, b = line.strip().split(',')
    a, b = int(a), int(b)

    log_val = b * np.log(a)
    if log_val > largest_log_val:
        largest_log_val = log_val
        largest_line_num = line_num

    line_num += 1

print('largest log val: %f at line number %d' % (largest_log_val, largest_line_num))
