#include <iostream>
#include <math.h>
#include <vector>

using namespace std;

int main() {
    vector<int> Fib;
    int k, n;
    cout << "Въведи Fib(0) " << endl;
    cin >> k;

    Fib.push_back(k);
    cout << "Въведи Fib(1) " << endl;
    cin >> k;

    Fib.push_back(k);
    cout << "Въведи n " << endl;
    cin >> n;
    for (int i = 2; i < n+2; i++) {
        k = Fib[i - 1] + Fib[i - 2];
        Fib.push_back(k);
    }

    cout << "Fib: " << endl;
    for (auto a : Fib) {
        cout << a << endl;
    }
    return 0;
}