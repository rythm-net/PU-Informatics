// Файл: progr21_03_07_demo.cpp
// От упр-е 3 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
int main() {
  double const N[] = { -5, 15, -25, 1.5, 35 };
  const int Len = sizeof(N)/sizeof(N[0]);
  const double * const w1 = N,
               * const w2 = &N[3], // N+3 също е допустимо
               * const * const w3 = &w2;
  const double (* const w4)[Len] = &N,
               * const AP1[] = {N+2, &N[4]};
  double const * const * const AP2[] = {&w1, &w2, AP1+1};
  cout<< N[1] <<endl;
  cout<< *(N+1) <<endl;
  cout<< *(w1+1) << endl;
  cout<< w1[1] <<endl;
  cout<< *(w2-2) <<endl;
  cout<< w2[-2] <<endl;
  cout<< (*w4)[1] <<endl;
  cout<< *(w4[0]+1) <<endl;
  cout<< *((*w4)+1) <<endl;
  cout<< *(*w3-2) <<endl;
  cout<< w3[0][-2] <<endl;
  cout<< *(AP1[1]-3) <<endl;
  cout<< (AP1+1)[0][-3] <<endl;
  cout<< *(*(AP1+1)-3) <<endl;
  cout<< *(*(AP2[2]-1)-1) <<endl;
  cout<< (*(AP2+2))[-1][-1] <<endl;
  cout<< *(**(AP2+1)-2) <<endl;
  cout<< *(**AP2+1) <<endl;
}
