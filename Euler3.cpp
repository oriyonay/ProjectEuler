#include <iostream>

int main() {
  long long number = 600851475143;
  int largestPrime = 2;
  for (int i = 3; i <= number; i+= 2) {
    if (number % i == 0) {
      number/= i;
      largestPrime = i;
    }
  }
  std::cout << largestPrime << std::endl;
}
