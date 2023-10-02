//Да се напише програма, която въвежда от клавиатурата х, n и да изчислява и извежда стойността на S,
//където S = (x^1/1) + (x^2/2) + .... + x^n/n, където ^ означава "на степен"

#include <iostream>
#include <math.h>
using namespace std;

int main() {
    int n = 0;
    double x, S=0;
    cout << "Vyvedete n, x " << endl;
    cin >> n >> x;

    if (cin.fail() || n <= 0) {
        cout << "Nevalidni danni " << endl;
        return 1;
    }

    for (int i = 1; i <= n; i++)
        S += pow(x, i) / i;

    cout << "S = " << S << endl;
    return 0;
}