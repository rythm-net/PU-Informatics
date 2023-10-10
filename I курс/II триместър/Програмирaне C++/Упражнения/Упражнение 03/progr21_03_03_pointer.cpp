// Файл: progr21_03_03_pointer.cpp
// От упр-е 3 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
#include <cmath>
const int Len = 7;
int main() {
  long double ar[Len];
  for(long double *u = ar; u-ar < Len; ++u) {
    cout<<"  "<< u-ar + 1 <<"-о число (от "<<Len<<"): ";
    cin>> *u;
  }
  cout<<"Двойки съседни с целочислена сума:\n";
  for(long double * u = ar + Len-1; ar < u; --u)
    if( trunc(*(u-1)+*u) == *(u-1)+*u )
      cout << *(u-1) <<" + "<< *u
           << " = ar[" << u-1 - ar << "] + ar[" << u - ar
           << "] = " << *(u-1)+*u << endl;
  cout<<"  (край на двойките)\n";
}
