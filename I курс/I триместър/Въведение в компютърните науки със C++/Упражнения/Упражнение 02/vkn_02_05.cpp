#include <iostream>
using namespace std;

int main() {
    char c;
    do {
        cout << "Шестнадесетична цифра: ";
        cin >> c;
    } while ((c < '0' || '9' < c)
             && (c < 'a' || 'f' < c)
             && (c < 'A' || 'F' < c));

    int val = '0' <= c && c <= '9'
              ? c - '0'
              : 'a' <= c && c <= 'f'
                ? 10 + c - 'a'
                : 10 + c - 'A';
    cout << "Стойност на цифрата: " << val << "\n";
    if (15 == val) cout << "Няма следваща цифра.\n";
    else {
        cout << "Следваща цифра: " << hex << (val + 1) << endl;
        if ('A' <= c && c <= 'F')
            cout << "Следваща цифра: " << (char)(val - 10 + 'A' + 1) << endl;
    }
}