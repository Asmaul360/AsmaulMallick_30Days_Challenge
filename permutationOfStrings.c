#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
Problem: Permutations of Strings

Given an array of strings sorted in lexicographical (dictionary) order,
print all of its permutations in strict lexicographical order.

If two permutations are identical (due to duplicate strings),
print only one of them.

Task:
Complete the function next_permutation which:
- Modifies the array to its next permutation
- Returns 1 if next permutation exists
- Returns 0 if it is the last permutation

Approach:
1. Find the breakpoint from right where s[i] < s[i+1]
2. Find the next greater element from right
3. Swap them
4. Reverse the suffix to get next smallest order

Time Complexity: O(n × n!)
Space Complexity: O(1) (excluding output)
*/

int next_permutation(int n, char **s)
{
    int i = n - 2;

    // Step 1: Find breakpoint
    while (i >= 0 && strcmp(s[i], s[i + 1]) >= 0)
        i--;

    if (i < 0)
        return 0;

    // Step 2: Find next greater element
    int j = n - 1;
    while (strcmp(s[j], s[i]) <= 0)
        j--;

    // Step 3: Swap
    char *temp = s[i];
    s[i] = s[j];
    s[j] = temp;

    // Step 4: Reverse suffix
    int start = i + 1, end = n - 1;
    while (start < end)
    {
        char *t = s[start];
        s[start] = s[end];
        s[end] = t;
        start++;
        end--;
    }

    return 1;
}

int main()
{
    int n;
    scanf("%d", &n);

    char **s = (char **)malloc(n * sizeof(char *));

    for (int i = 0; i < n; i++)
    {
        s[i] = (char *)malloc(11 * sizeof(char));
        scanf("%s", s[i]);
    }

    // Sort initial array
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (strcmp(s[i], s[j]) > 0)
            {
                char *temp = s[i];
                s[i] = s[j];
                s[j] = temp;
            }
        }
    }

    // Generate permutations
    do
    {
        for (int i = 0; i < n; i++)
        {
            printf("%s", s[i]);
            if (i != n - 1)
                printf(" ");
        }
        printf("\n");
    } while (next_permutation(n, s));

    // Free memory
    for (int i = 0; i < n; i++)
        free(s[i]);
    free(s);

    return 0;
}