#include <iostream>
using namespace std;

int main() {
    //system("chcp 1251"); // за MS VS
    int n;
    cout << "Въведете цяло число: ";
    cin >> n;
    cout << "g(" << n << ") = " << (n % 2 == 0 ? n % 3 == 0 ? 3 * n : n * n : n + n - 1) << endl;
    cout << "g(" << n << ") = ";
    if (n % 2 == 0) if (n % 3 == 0) cout << 3 * n;
        else cout << n * n;
    else cout << n + n - 1;
    cout << endl;
    //system("pause"); // за MS VS
}