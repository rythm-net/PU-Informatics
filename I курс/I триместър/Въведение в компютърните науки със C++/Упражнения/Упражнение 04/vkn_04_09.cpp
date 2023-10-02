#include <iostream>
using namespace std;

int main() {
    //system("chcp 1251"); // за MS VS
    char ch;
    cout << "Въведете знак: ";
    cin >> ch;
    bool lat = 'a' <= ch && ch <= 'z';
    cout << "\'" << ch << "\' " << ( lat ? "" : "не " ) << "е малка латинска буква.\n";
    cout << "\'" << ch << "\' ";
    if ( ! lat ) cout << "не ";
    cout << "е малка латинска буква.\n";
    if( lat )
        cout << "Номер на буквата в азбуката: "
             << 1+(ch-'a') << endl;
    //system("pause"); // за MS VS
}