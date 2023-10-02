#include <iostream>
#include <iomanip>
using namespace std;

int main() {
    int k, n;
    do {
        cout << "Цяло k от 0 до 3: ";
        cin >> k;
    } while (k < 0 || 3 < k);

    do {
        cout << "Цяло n от " << k + 1 << " до 9: ";
        cin >> n;
    } while (n < k + 1 || 9 < n);
    for (int f2=n+1, f1=1; f2>=1; --f2, f1 += k+1>f1?1:0)
        cout << setw(f1) << '=' << setw(k + 2 - f1) << '*'
             << setw(f2) << '&' << endl;
    //system("pause");
}