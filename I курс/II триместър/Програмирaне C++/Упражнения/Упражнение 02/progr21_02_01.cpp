// Файл: progr21_02_01.cpp
// От упр-е 2 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
#include <iomanip>
int main() {
  const int NColumns = 5;
  long tabl[][NColumns]={{1,2,22},{3,4},{5,6},{7}};
  //long tabl[][NColumns]={{1,2},{3,4},5,6,7,8,9,10,11,12};
  //long tabl[][NColumns]={1,2,3,4,5,6,7,8,9,10,11,12};
  //long tabl[][NColumns]={1,2,3,4,5,{8,9},10,11,12};
  const int NRows = sizeof(tabl) / sizeof(tabl[0]);
  for(int r=0; r<NRows; ++r) {
    for(int c=0; c<NColumns; ++c)
      cout<< setw(5) << tabl[r][c];
    cout<<endl;
  }
  cout<<"-------------\n";
  long num;
  cout<<"Променяна стойност: ";
  cin>>num;
  cout<<"-------------\n";
  for(int r=0; r<NRows; ++r)
    for(int c=0; c<NColumns; ++c)
      if(tabl[r][c]==num) ++tabl[r][c];
  for(int r=0; r<NRows; ++r) {
    for(long elm : tabl[r])
      cout<< setw(5) << elm;
    cout<<endl;
  }
  cout<<"-------------\n";
  for(long *ar = tabl[0];
      ar-tabl[0]<NRows*NColumns;
      ar += NColumns) {
    for(int c=0; c<NColumns; ++c)
        cout<< setw(5) << ar[c];
      cout<<endl;
    }
  cout<<"-------------\n";
  for(decltype(tabl[0]) ar : tabl) {
    for(long elm : ar)
        cout<< setw(5) << elm;
      cout<<endl;
    }
}
