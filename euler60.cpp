/* Euler 60
 * this solution seems over-the-top and complicated but it's highly efficient.
 * i'm getting a running time of around 2 seconds.
 */

#include <algorithm>
#include <chrono>
#include <iostream>
#include <vector>

#define NUM_PRIMES 100000000
#define IS_PRIME(n) ((n < NUM_PRIMES) ? prime[n] : false)

using namespace std::chrono;

// cpot = closest power of ten (that is > n)
int cpot(int n) {
    if (n < 10) return 10;
    if (n < 100) return 100;
    if (n < 1000) return 1000;
    if (n < 10000) return 10000;
    if (n < 100000) return 100000;
    if (n < 1000000) return 1000000;
    if (n < 10000000) return 10000000;
    if (n < 100000000) return 100000000;
    if (n < 1000000000) return 1000000000;
    return -1;
}

inline int concat(int a, int b) {
    return (a * cpot(b)) + b;
}

int main() {
    // start the timer:
    auto start = high_resolution_clock::now();
    
    // generate primes and store values in a vector:
    bool* prime = new bool[NUM_PRIMES];
    std::vector<int> list_primes;
    std::fill_n(prime, NUM_PRIMES, true);
    for (int i = 2; i*i < NUM_PRIMES; i++) {
        if (prime[i]) {
            list_primes.push_back(i);
            for (int j = i*i; j < NUM_PRIMES; j += i) {
                prime[j] = false;
            }
        }
    }

    const int P = list_primes.size();
    for (int i = 0; i < P; i++) {
        for (int j = i+1; j < P; j++) {
            if (!IS_PRIME(concat(list_primes[i], list_primes[j]))) continue;
            if (!IS_PRIME(concat(list_primes[j], list_primes[i]))) continue;
            for (int k = j+1; k < P; k++) {
                if (!IS_PRIME(concat(list_primes[i], list_primes[k]))) continue;
                if (!IS_PRIME(concat(list_primes[k], list_primes[i]))) continue;
                if (!IS_PRIME(concat(list_primes[j], list_primes[k]))) continue;
                if (!IS_PRIME(concat(list_primes[k], list_primes[j]))) continue;
                // printf("%d %d %d\n", list_primes[i], list_primes[j], list_primes[k]);
                for (int l = k+1; l < P; l++) {
                    if (!IS_PRIME(concat(list_primes[i], list_primes[l]))) continue;
                    if (!IS_PRIME(concat(list_primes[l], list_primes[i]))) continue;
                    if (!IS_PRIME(concat(list_primes[j], list_primes[l]))) continue;
                    if (!IS_PRIME(concat(list_primes[l], list_primes[j]))) continue;
                    if (!IS_PRIME(concat(list_primes[k], list_primes[l]))) continue;
                    if (!IS_PRIME(concat(list_primes[l], list_primes[k]))) continue;
                    for (int m = l+1; m < P; m++) {
                        if (!IS_PRIME(concat(list_primes[i], list_primes[m]))) continue;
                        if (!IS_PRIME(concat(list_primes[m], list_primes[i]))) continue;
                        if (!IS_PRIME(concat(list_primes[j], list_primes[m]))) continue;
                        if (!IS_PRIME(concat(list_primes[m], list_primes[j]))) continue;
                        if (!IS_PRIME(concat(list_primes[k], list_primes[m]))) continue;
                        if (!IS_PRIME(concat(list_primes[m], list_primes[k]))) continue;
                        if (!IS_PRIME(concat(list_primes[l], list_primes[m]))) continue;
                        if (!IS_PRIME(concat(list_primes[m], list_primes[l]))) continue;
                        int a = list_primes[i];
                        int b = list_primes[j];
                        int c = list_primes[k];
                        int d = list_primes[l];
                        int e = list_primes[m];
                        printf("found numbers: %d %d %d %d %d\n", a, b, c, d, e);
                        printf("sum of the numbers is %d\n", (a+b+c+d+e));
                        auto finish = high_resolution_clock::now();
                        duration<double> time_span = duration_cast<duration<double>>(finish - start);
                        std::cout << "program execution took " << time_span.count() << " milliseconds.\n";
                        return 0;
                    }
                }
            }
        }
    }
    
    printf("no numbers found. try increasing NUM_PRIMES.\n");
    return 0;
}