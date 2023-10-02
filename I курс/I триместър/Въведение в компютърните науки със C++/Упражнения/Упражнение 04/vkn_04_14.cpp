#include <iostream>
using namespace std;

int main() {
    //system("chcp 1251"); // за MS VS
    double n1, n2, n3, temp;
    cout << "Три реални числа: ";
    cin >> n1 >> n2 >> n3;
    if (n2 < n1) { temp = n1; n1 = n2; n2 = temp; }
    if (n3 < n1) { temp = n1; n1 = n3; n3 = temp; }
    if (n3 < n2) { temp = n2; n2 = n3; n3 = temp; }
    cout << n1 << " <= " << n2 << " <= " << n3 << endl;
    //system("pause"); // за MS VS
}