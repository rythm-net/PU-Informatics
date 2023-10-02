#include <iostream>
#include <cmath>
using namespace std;

int main() {
    //system("chcp 1251"); // за MS VS
    double x, y, temp;
    cout << "Въведете краища на интервал: ";
    cin >> x >> y;
    if( x > y ) { temp=x; x=y; y=temp; }
    double num = 1.0+(floor(y)-ceil(x));
    cout.precision(17); // за да се вижда наличието на дробна част
    cout << "В интервала [ " << x << " ; " << y << " ]\n  има " << num;
    if( num == 1.0 ) cout << " цяло число.\n";
    else cout << " цели числа.\n";
    //system("pause"); // за MS VS
}