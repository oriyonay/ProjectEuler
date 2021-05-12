#include <stdio.h>
#include <sys/time.h>

#define MAX_VALUE 1000000
#define CHAIN_SIZE (MAX_VALUE * 3)

int loop_lengths[CHAIN_SIZE] = {0};
int factorials[10] = {1};

int calculate_chain(int n, int start, int length=0);
int sum_factorials(int n);

int main() {
  // start the timer:
  struct timeval start, end;
  gettimeofday(&start, NULL);

  // initialize factorials:
  for (int i = 1; i < 10; i++) {
    factorials[i] = factorials[i-1] * i;
  }

  // manually initialize loops since we know these are the only ones to exist:
  loop_lengths[169] = 3;
  loop_lengths[363601] = 3;
  loop_lengths[1454] = 3;
  loop_lengths[871] = 2;
  loop_lengths[45361] = 2;
  loop_lengths[872] = 2;
  loop_lengths[45362] = 2;
  loop_lengths[145] = 1;
  loop_lengths[40585] = 1;

  for (int i = 0; i < CHAIN_SIZE; i++) {
    if (loop_lengths[i]) continue;
    if (sum_factorials(i) == i) {
      loop_lengths[i] = 1;
      continue;
    }
    calculate_chain(i, i);
  }

  int num_chains = 0;
  for (int i = 0; i < MAX_VALUE; i++) {
    if (loop_lengths[i] == 60) num_chains++;
  }

  // stop the clock & calculate execution time:
  gettimeofday(&end, NULL);
  long execution_ms = (1e3 * (end.tv_sec - start.tv_sec)) + (((end.tv_usec) - (start.tv_usec)) / 1e3);

  printf("number of chains with length 60 = %d\n", num_chains);
  printf("program execution took %lu ms\n", execution_ms);

  return 0;
}

int calculate_chain(int n, int start, int length) {
  if (loop_lengths[n]) return loop_lengths[n] + 1;
  if ((length != 0) && (n == start)) return 1;
  loop_lengths[n] = calculate_chain(sum_factorials(n), start, length+1);
  return loop_lengths[n] + 1;
}

int sum_factorials(int n) {
  int sum = 0;
  while (n) {
    sum += factorials[n%10];
    n /= 10;
  }
  return sum;
}
