// Файл: progr21_02_03_demo.cpp
// От упр-е 2 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
int main() {
  double * u = new double; // създаване на единична данна
  cout<<"Число: ";
  cin>> *u;
  cout<<"Прочетено: "<< *u <<endl;
  delete u; // унищожаване на единична данна
  u = NULL; // стойността показва, че u не сочи данна
  if(u) cout<<"Прочетено: "<< *u <<endl;
  const double * uc = new double const (-234.56778989);
    // създаване на константа в динамичната памет
  cout<<"*uc = "<< *uc <<endl;
  delete uc;
  uc = NULL;
  if(uc) cout<<"Прочетено: "<< *uc <<endl;
  int Len = 4;
  u = new double [Len]; // създаване на изменяем масив
    for(int i=0; i<Len; ++i) u[i] = i*10.23 + 1;
    for(int i=0; i<Len; ++i) cout<<u[i]<<"  ";
    cout<<endl;
  delete[] u; // унищожаване на динамичен масив
  u = NULL;
  if(u) {
    for(int i=0; i<Len; ++i) cout<<u[i]<<"  ";
    cout<<endl;
  }
  Len = 6;
  uc = new double const [Len] {1.1, 2.2, 3.3, 4.444};
    // създаване на масив от константи
    for(int i=0; i<Len; ++i) cout<<uc[i]<<"  ";
    cout<<endl;
  delete[] uc;
  uc = NULL;
}
