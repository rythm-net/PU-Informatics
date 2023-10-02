#include <iostream>
using namespace std;

int main() {
    int n;
    do {
        cout << "Цяло число, което не се дели на 2, 3 и 5: ";
        cin >> n;
    } while (n % 2 == 0 || n % 3 == 0 || n % 5 == 0);

    if (n < 0) n = -n;
    int base[] = { 2, 3, 5, 7, 9, 11 };
    for (int b : base)
        cout << "Последна цифра в " << b << "-ична БС: " << n % b << endl;
    //system("pause");
}