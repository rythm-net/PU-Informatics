#include <iostream>
#include <iomanip>
using namespace std;

int main() { // извежда ромб
    int r;
    do {
        cout << "Въведете брой интервали от 2 до 8: ";
        cin >> r;
    } while ( r<2 || 8<r );

    for( int f1=r,f2=1;    f1>=-r;    --f1 , f1<0? f2-=2 : f2+=2 )
        cout << setw(1+abs(f1)) << '*' << setw(f2) << '#' << endl;
    //system("pause");
}