// Файл: progr21_02_10.cpp
// От упр-е 2 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  srand(time(NULL));
  int Len =rand()%15 + 1;
  long * ar = new long[Len];
  int evenCount=0;
  for(int i=0; i<Len; ++i) {
    ar[i]=rand()%16 - 5;
    cout<<ar[i]<<"  ";
    if(ar[i]%2) { // ar[i] е нечетено
      int first=0;
      while(ar[first]!=ar[i]) ++first;
      evenCount += first==i; // ar[i] не се среща преди индекс i
    }
  }
  cout<<endl;
  if(! evenCount) cout<<"Няма нечетни числа.\n";
  else {
    long * even = new long[evenCount];
      for(int i=0, next=0; i<Len; ++i)
        if(ar[i]%2) { // ar[i] е нечетено
          int first=0;
          while(ar[first]!=ar[i]) ++first;
          if(first==i) // ar[i] не се среща преди индекс i
            even[next++] = ar[i];
        }
      for(int i=0; i<evenCount; ++i) cout<<even[i]<<"  ";
      cout<<endl;
    delete[] even;
    even = NULL; // заради добрия стил на програмиране
  }
  delete[] ar;
  ar = NULL;
}
