// Файл: progr21_03_08_index.cpp
// От упр-е 3 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
#include <ctime>
#include <iomanip>
int const Len = 15;
int main() {
  srand(time(NULL));
  long long ar[Len];
  for (long long & elm : ar) elm = rand() % 201;
  for (long long elm : ar) cout << setw(4) << elm;
  cout << endl;
  for (int i = 0; i < Len; ++i) cout << setw(4) << i;
  cout << endl;
  cout << "Двойки съседни елементи с еднаква четност:\n";
  for (int i = 1; i < Len; ++i)
    if ( (bool)(ar[i - 1] % 2) == (bool)(ar[i] % 2) )
      cout << ar[i - 1] << " и " << ar[i]
           << " с индекси " << i - 1 << " и " << i << endl;
  cout << "  (край на двойките)\n";
}
