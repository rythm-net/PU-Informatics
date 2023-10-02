#include<iostream>
using namespace std;

int main() {
    int a_1, a_2, a_3, n, i=0;
    cout << "Моля въведете n: " << endl;
    cin >> n;
    if (cin.fail() || n <= 0) {
        cout << "Грешно n" << endl;
        return 1;
    }

    cout << "Моля въведете a1 и a2" << endl;
    cin >> a_1 >> a_2;
    if (cin.fail()) {
        cout << "Грешни стойности за a1 или a2" << endl;
        return 2;
    }

    while (i < n) {
        a_3 = a_2 + a_1;
        cout << "A[" << (i + 2) << "]=" << a_3 << endl;
        a_1 = a_2;
        a_2 = a_3;
        i++;
    }
    return 0;
}