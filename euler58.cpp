/* Euler 58
 * Lesson: sometimes it's useful to try different methods of doing the same thing
 *         (i was stuck and adamant about using a sieve to generate primes...)
*/

#include <algorithm>
#include <stdio.h>

#define SPIRAL_SIZE diff+1

bool isprime(int n) {
  // HIGHLY EFFICIENT
    if (n <= 1) return false;
    if (n <= 3) return true;
    if (n % 2 == 0 || n % 3 == 0) return false;
    if (!((((n + 1) % 4 == 0) || ((n - 1) % 4 == 0)) && (((n + 1) % 6 == 0) || ((n - 1) % 6 == 0)))) return false;
    for (int i = 5; i * i <= n; i = i+6){
        if (n % i == 0 || n % (i+2) == 0) return false;
    }
    return true;
}

int main() {
  int diff = 2;
  int n = 1;
  int num_primes_in_spiral = 0;
  int total_numbers_in_spiral = 1;
  while (true) {
    for (int i = 0; i < 4; i++) {
      n += diff;
      if (isprime(n)) {
        num_primes_in_spiral++;
      }
      total_numbers_in_spiral++;
    }

    if (((double) num_primes_in_spiral / total_numbers_in_spiral) < 0.10) {
      // printf("num_primes_in_spiral: %d\n", num_primes_in_spiral);
      // printf("total_numbers_in_spiral: %d\n", total_numbers_in_spiral);
      printf("ratio: %f\n", ((double) num_primes_in_spiral / total_numbers_in_spiral));
      printf("success at spiral size %d\n", SPIRAL_SIZE);
      return 0;
    }

      diff += 2;
  }

  // will never be executed:
  return 0;
}
