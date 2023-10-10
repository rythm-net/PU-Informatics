// Файл: progr21_02_12.cpp
// От упр-е 2 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  srand(time(NULL));
  int Len1 = rand()%8 + 1,  Len2 = rand()%8 + 1;
  long * ar1 = new long[Len1], * ar2 = new long[Len2];
  for(int i=0; i<Len1; ++i) {
    ar1[i]=rand()%7 + 4;
    cout<<ar1[i]<<"  ";
  }
  cout<<endl;
  for(int i=0; i<Len2; ++i) {
    ar2[i]=rand()%7 + 4;
    cout<<ar2[i]<<"  ";
  }
  cout<<endl;
  cout<<"---- Числа, които се срещат и в двата масива ----\n";
  for(int i=0; i<Len1; ++i) {
    int first=0;
    while(ar1[first]!=ar1[i]) ++first;
    if(first==i) {
      first=0;
      while(first<Len2 && ar2[first]!=ar1[i]) ++first;
      if(first<Len2)
        cout<<ar1[i]<<endl;
    }
  }
  cout<<"---- край на общите числа ----";
  delete[] ar1;
  ar1 = NULL;
  delete[] ar2;
  ar2 = NULL;
}
