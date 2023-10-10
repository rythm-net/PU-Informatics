// Файл: progr21_01_09_demo.cpp
// От упр-е 1 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  srand(time(NULL));
  const int Len = 10;
  short ar[Len];
  for (short *u = ar + Len - 1; ar <= u; --u)
    *u = rand() % 10 - 3;
  // а)
  for (short *u = ar; u - ar < Len; ++u)
    cout << *u << "  ";
  cout << endl;
  // б)
  short max = *ar;
  for (short *u = ar + Len - 1; ar < u; --u)
    if (max < *u) max = *u;
  cout << "Максимум: " << max << endl;
  // в)
  cout << "Индекси на максималните елементи: ";
  for (short *u = ar; u - ar < Len; ++u)
    if (max == *u) cout << u - ar << "  ";
  cout << endl;
}
