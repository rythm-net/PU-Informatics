#include <iostream>
#include <iomanip>
using namespace std;

int main() {
    int n;
    do {
        cout << "Четно число от 2 до 10: ";
        cin >> n;
    } while (n < 2 || 10 < n || n % 2 != 0);

    for (int f1=2, f2=n+2, f3=2; f2>1; ++f1, f2-=2, ++f3)
        cout << setw(f1) << "##" << setw(f2) << "=="
             << setw(f3) << "&&" << endl;
    //system("pause");
}