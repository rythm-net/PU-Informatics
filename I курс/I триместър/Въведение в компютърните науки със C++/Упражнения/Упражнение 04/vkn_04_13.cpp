#include <iostream>
using namespace std;

int main() {
    //system("chcp 1251"); // за MS VS
    int m, y;
    cout << "Въведете номер на месец от 1 до 12: ";
    cin >> m;
    cout << "Въведете година: ";
    cin >> y;
    cout << "Месец " << m << " от година " << y << " има "
         << ( m==2 ? 28 + (y%400==0 || y%100 && y%4==0)
                   : 31 - (m==4 || m==6 || m==9 || m==11) )
         << " дни.\n";
    cout << "Месец " << m << " от година " << y << " има ";
    if( m==2 ) cout << ( 28 + (y%400==0 || y%100 && y%4==0) );
    else cout << ( 31 - (m==4 || m==6 || m==9 || m==11) );
    cout << " дни.\n";
    //system("pause"); // за MS VS
}