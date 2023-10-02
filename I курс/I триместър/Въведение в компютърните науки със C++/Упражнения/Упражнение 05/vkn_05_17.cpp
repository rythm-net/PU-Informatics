#include <iostream>
using namespace std;

int main() {
    int n;
    do {
        cout << "Естествено число, по-голямо от 1: ";
        cin >> n;
    } while (n < 2);

    cout << n << " =";
    int next = 2;
    char c = ' ';

    while (n > 1)
        if (n % next == 0) {
            cout << c << next;
            c = '*';
            n /= next;
        }
        else next += next == 2 ? 1 : 2;
    //system("pause");
}