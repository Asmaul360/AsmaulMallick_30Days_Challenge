#include <bits/stdc++.h>
using namespace std;

multiset<long long> low, high;

// Balance both sets
void rebalance() {
    while (low.size() > high.size() + 1) {
        high.insert(*low.rbegin());
        low.erase(prev(low.end()));
    }
    while (high.size() > low.size()) {
        low.insert(*high.begin());
        high.erase(high.begin());
    }
}

// Print median
void printMedian() {
    int total = low.size() + high.size();

    if (total == 0) {
        cout << "Wrong!" << endl;
        return;
    }

    if (total % 2 == 1) {
        cout << *low.rbegin() << endl;
    } else {
        long long a = *low.rbegin();
        long long b = *high.begin();
        long long sum = a + b;

        if (sum % 2 == 0) {
            cout << sum / 2 << endl;
        } else {
            if (sum == -1) cout << "-0.5" << endl;
            else cout << sum / 2 << ".5" << endl;
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        char op;
        long long x;
        cin >> op >> x;

        if (op == 'a') {
            // Add
            if (low.empty() || x <= *low.rbegin())
                low.insert(x);
            else
                high.insert(x);

            rebalance();
            printMedian();

        } else {
            // Remove
            auto itLow = low.find(x);
            auto itHigh = high.find(x);

            if (itLow == low.end() && itHigh == high.end()) {
                cout << "Wrong!" << endl;
                continue;
            }

            if (itLow != low.end())
                low.erase(itLow);
            else
                high.erase(itHigh);

            rebalance();
            printMedian();
        }
    }

    return 0;
}