// Файл: progr21_03_04_index.cpp
// От упр-е 3 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
#include <ctime>
int const Len = 15;
int main() {
  srand(time(NULL));
  long ar[Len];
  for (long &ref : ar) ref = rand() % 6 + 5;

  // начин без да се помни, кои числа вече са изведени
  for (int i = 0; i < Len; ++i) {
    int f = 0;
    while (ar[f] != ar[i]) ++f;
    if (f < i) continue; // числото ar[i] вече е извеждано
    int num = 1;
    for (int next = i + 1; next < Len; ++next)
      if (ar[next] == ar[i])
        ++num;
    cout << "числото " << ar[i] << " се среща на " << num
         << " места\n";
  }

  cout << "\n  Масив:  ";
  for (long elm : ar) cout << elm << "  ";
  cout << "\n\n";

  // начин със запомняне в масива out, кои числа вече са изведени
  bool out[Len] = { false };
    // out[i]==true, точно когато ar[i] вече е изведено
  for (int i = 0; i < Len; ++i)
    if ( ! out[i] ) { // ar[i] още не е извеждано
      int num = 1;
      for (int next = i + 1; next < Len; ++next)
        if (ar[next] == ar[i]) {
          ++num;
          out[next] = true;
        }
      cout << "числото " << ar[i] << " се среща на " << num
           << " места\n";
    }
}

