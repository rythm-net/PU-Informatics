// Файл: progr21_01_05.cpp
// От упр-е 1 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
int main() {
  long long sum = 0LL;
  int number = 0;
  while( sum >= 0LL ) {
    cout<<"Цяло число (край - отрицателна сума): ";
    long long next;
    cin >> next;
    sum += next;
    ++number;
  }
  cout << "Средно аритметично: " << sum/(double)number << endl;
}
