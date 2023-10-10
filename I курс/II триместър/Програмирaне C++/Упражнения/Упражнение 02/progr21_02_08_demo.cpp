// Файл: progr21_02_08_demo.cpp
// От упр-е 2 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
int main() {
  double g=1.55, h=-.123;
  for(int i=0; i<2; ++i) {
    double * u;
    if(i) u = &g;
    else u = &h;
    double & ref = *u;
    cout<<"ref = "<<ref<<endl;
  }
  double ar[] = {1.1,2.22,3.3,.444};
  const int Len = sizeof(ar) / sizeof(ar[0]);
  for(int i=0; i<Len; ++i) cout<<ar[i]<<"  ";
  cout<<endl;
  for(double &rElm : ar) rElm *= 2;
  for(double elm : ar) cout<<elm<<"  ";
  cout<<endl;
}
