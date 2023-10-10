// Файл: progr21_03_02_index.cpp
// От упр-е 3 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
int const number = 6;
int main() {
  long long ar[number];
  for(int i=0; i<number; ++i) {
    cout<<"  "<<i+1<<"-о число (от общо "<<number<<"): ";
    cin>>ar[i];
  }
  for(long long r = -2LL; r<=2LL; ++r) {
    cout<<"остатък "<<r<<" се получава от: ";
    for(long long elm : ar)
      if( elm % 3 == r )
        cout<<elm<<' ';
    cout<<endl;
  }
}
