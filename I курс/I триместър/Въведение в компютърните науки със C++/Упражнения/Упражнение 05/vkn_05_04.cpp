#include <iostream>
using namespace std;

int main() {
    int k, n;
    cout << "Цяло n: ";
    cin >> n;

    do {
        cout << "Цяло k<>0: ";
        cin >> k;
    } while (0 == k);
    int f;
    switch (n % k) {
        case 0: f = 2 * k + 3 * n; break;
        case -1: case 1: f = k + n; break;
        case -2: case 2: f = k + 2 * n; break;
        case -3: case 3: f = 3 * k + n; break;
        default: f = 4 * n - k;
    }
    cout << "f( " << k << " ; " << n << " ) = " << f << endl;
    //system("pause");
}