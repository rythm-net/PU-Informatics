// Файл: progr21_02_06.cpp
// От упр-е 2 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  srand(time(NULL));
  int Len = rand()%15 + 1;
  long * ar = new long[Len];
  for(int i=0; i<Len; ++i) {
    ar[i] = rand()%16 - 5;
    cout<<ar[i]<<' ';
  }
  cout<<endl;
  long max = ar[0];
  int maxCount = 1;
  for(int i=1; i<Len; ++i)
    if(max==ar[i]) ++maxCount;
    else if(max<ar[i]) { max=ar[i]; maxCount=1; }
  cout<<"Брой на максималните елементи: "<<maxCount
      <<"\nИндекси на максимални елементи: ";
  for(int i=0; i<Len; ++i)
    if(max==ar[i]) cout<<i<<"  ";
}
