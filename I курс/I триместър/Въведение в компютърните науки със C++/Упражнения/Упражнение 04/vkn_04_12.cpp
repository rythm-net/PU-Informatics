#include <iostream>
#include <cmath>
using namespace std;

int main() {
    //system("chcp 1251"); // за MS VS
    double x;
    cout << "Реално число: ";
    cin >> x;
    cout.setf(ios::fixed);
    cout.precision(18);
    cout << "f( " << x << " ) = " << (x>0.0 ? sqrt(x) : x==trunc(x) ? x/4.0 : x*x-1000.5) << endl;
    cout << "f( " << x << " ) = ";
    if (x>0.0) cout << sqrt(x);
    else if (x==trunc(x)) cout << x/4.0;
    else cout << x*x-1000.5;
    cout << endl;
    //system("pause"); // за MS VS
}