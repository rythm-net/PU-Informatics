#include <iostream>
using namespace std;

int main() {
    int num;
    do {
        cout << "Въведете цяло число, различно от 1 и -1: ";
        cin >> num;
    } while( 1==num || -1==num );

    int d = 2;
    while (num % d) d += 2==d?1:2;
    cout << "Минимален прост делител: " << d << endl;
    //system("pause");
}