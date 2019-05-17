// euler 34

#include <iostream>

int main() {
    int factorials[10];
    factorials[0] = 1;
    for (int i = 1; i < 10; i++) factorials[i] = i * factorials[i-1];
    for (int i = 10; i < 1000000; i++) {
        int sumDigitFactorials = 0, j = i;
        while (j > 0) {
            sumDigitFactorials+= factorials[j%10];
            j/=10;
        }
        if (i == sumDigitFactorials) std::cout << i << std::endl;
    }
}