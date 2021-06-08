// very efficient! uses a trie-like structure :)

#include <chrono>
#include <stdio.h>

using namespace std::chrono;

// number of cubic permutations:
#define N 5

typedef unsigned long long U64;

struct perm_node {
    perm_node* next_level[10];
    int perms[N];
    int num_perms;
    
    perm_node() : next_level{nullptr}, num_perms(0) {}
};

U64 add_and_check(int x, perm_node* root) {
    U64 cube = (U64) x * x * x;
    int digit_counts[10] = {0};
    while (cube) {
        digit_counts[cube % 10]++;
        cube /= 10;
    }
    
    // navigate the tree to find the right node:
    perm_node* cur = root;
    for (int digit = 0; digit < 10; digit++) {
        // create the extra branch if one doesn't exist already:
        if (!cur->next_level[digit_counts[digit]]) {
            cur->next_level[digit_counts[digit]] = new perm_node();
        }
        
        // navigate to that branch:
        cur = cur->next_level[digit_counts[digit]];
    }
    
    // add this cube to the tree:
    cur->perms[cur->num_perms++] = x;
    
    // check if we've found the solution:
    if (cur->num_perms == N) {
        return (U64) cur->perms[0] * cur->perms[0] * cur->perms[0];
    }
    
    // otherwise, we haven't found the solution yet:
    return 0;
}

int main() {
    // start the timer:
    steady_clock::time_point start_time = steady_clock::now();
    
    // search for the solution:
    perm_node* root = new perm_node();
    U64 smallest_cube;
    for (int i = 1;; i++) {
        smallest_cube = add_and_check(i, root);
        if (smallest_cube) {
            printf("found smallest cube with %d permutations: %llu\n", N, smallest_cube);
            break;
        }
    }
    
    // stop the timer:
    steady_clock::time_point end_time = steady_clock::now();
    double elapsed = duration<double>(duration_cast<microseconds>(end_time - start_time)).count();
    printf("program execution took %f seconds\n", elapsed);
    return 0;
}
