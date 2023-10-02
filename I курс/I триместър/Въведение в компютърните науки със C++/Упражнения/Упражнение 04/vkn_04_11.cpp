#include <iostream>
using namespace std;

int main() {
    //system("chcp 1251"); // за MS VS
    int n1, n2;
    cout << "Две числа: ";
    cin >> n1 >> n2;
    cout << n1 << (n1 < n2 ? " < " : n1 == n2 ? " = " : " > ") << n2 << endl;
    cout << n1;
    if (n1 < n2) cout << " < ";
    else if (n1 == n2) cout << " = ";
    else cout << " > ";
    cout << n2 << endl;
    //system("pause"); // за MS VS
}