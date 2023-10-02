#include <iostream>
using namespace std;

int main() {
    //system("chcp 1251"); // за MS VS
    bool x, y;
    cout << "Ѕулеви x y: ";
    cin >> x >> y;
    cout << "f(" << x << ';' << y << ") = " << (x == y) << endl;
    cout << "f(" << (x ? "true" : "false") << ';'
         << (y ? "true" : "false") << ") = "
         << (x == y ? "true" : "false") << endl;
    //system("pause"); // за MS VS
}