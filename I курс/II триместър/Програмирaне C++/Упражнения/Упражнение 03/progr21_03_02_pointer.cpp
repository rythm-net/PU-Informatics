// Файл: progr21_03_02_pointer.cpp
// От упр-е 3 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
int const number = 6;
int main() {
  long long ar[number];
  for( long long * u = ar; u-ar<number; ++u ) {
    cout<<"  "<< u-ar + 1 <<"-о число (от общо "<<number<<"): ";
    cin>> *u;
  }
  for(long long r = -2LL; r<=2LL; ++r) {
    cout<<"остатък "<<r<<" се получава от: ";
    for(long long elm : ar)
      if( elm % 3 == r )
        cout<<elm<<' ';
    cout<<endl;
  }
}
