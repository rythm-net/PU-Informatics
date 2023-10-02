#include <iostream>
using namespace std;

int main() {
    unsigned long long num;
    cout << "Цяло положително число (до 19 цифри): ";
    cin >> num;

    int a0 = (int) (num % 10),
            a1 = (int) (num / 10 % 10),
            a2 = (int) (num / 100 % 10);

    for (int i = 1; i <= 5; ++i) {
        int n;
        switch (i) {
            case 1: n = (a0 * 10 + a1) * 10 + a2; break;
            case 2: n = (a1 * 10 + a0) * 10 + a2; break;
            case 3: n = -((a1 * 10 + a2) * 10 + a0); break;
            case 4: n = (a1 * 10 + a2) * 10 + 8; break;
            default: n = (a1 * 10 + 2) * 10 + a0;
        }

        cout << "a0a1a2(10) = "
             << (n<0?"-":"")
             << (abs(n)<100?"0":"") << (abs(n)<10?"0":"")
             << abs(n)
             << " = " << n << "; " << n << "*2 = " << n + n << endl;
    } //system("pause");
}