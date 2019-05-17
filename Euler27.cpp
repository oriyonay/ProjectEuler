#include <iostream>

bool isprime(int n) {
  if (n < 1) return false;
  if (n == 2 || n == 3) return true;
  if (n % 2 == 0) return false;
  // ((n*n) - 1) % 24 != 0
  if (!((((n + 1) % 4 == 0) || ((n - 1) % 4 == 0)) && (((n + 1) % 6 == 0) || ((n - 1) % 6 == 0)))) return false;
  for (int i = 3; i * i <= n; i+= 2) {
    if (n % i == 0) return false;
  }
  return true;
}

int consecutivePrimes(int b, int c) {
  int numPrimes = 0, n = 0;
  while (isprime(((n+b)*n) + c)) {
    numPrimes++;
    n++;
  }
  return numPrimes;
}

int main() {
  int largestNumPrimes = 0, bestB = -1000, bestC = -1000;
  for (int b = -1000; b < 1000; b++) {
    for (int c = -1000; c <= 1000; c++) {
      int temp = consecutivePrimes(b, c);
      if (temp > largestNumPrimes) {
        largestNumPrimes = temp;
        bestB = b;
        bestC = c;
      }
    }
  }
  std::cout << "Best b found: " << bestB << std::endl;
  std::cout << "Best c found: " << bestC << std::endl;
  std::cout << "Product of b & c: " << bestB*bestC << std::endl;
  return 0;
}
