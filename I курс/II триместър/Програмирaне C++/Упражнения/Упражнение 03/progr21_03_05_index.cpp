// Файл: progr21_03_05_index.cpp
// От упр-е 3 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
#include <ctime>
#include <iomanip>
int const rNum = 5, cNum = 10;
int main() {
  srand(time(NULL));
  long ar[rNum][cNum];

  for (int r = 0; r < rNum; ++r)
    for (int c = 0; c < cNum; ++c) ar[r][c] = rand() % 9 + 3;

  for (int r = 0; r < rNum; ++r) {
    for (long elm : ar[r]) cout << setw(5) << elm;
    cout << endl;
  }

  for (int c = 0; c < cNum; ++c) {
    // търсене на максимум за колоната
    long max = ar[0][c];
    for (int r = 1; r < rNum; ++r)
      if (ar[r][c] > max)
        max = ar[r][c];
    // пренареждане на колоната
    for (int r = 0, pos = 0; r < rNum; ++r)
      if (max == ar[r][c]) {
        for (int i = r; i > pos; --i)
          ar[i][c] = ar[i - 1][c];
        ar[pos++][c] = max;
      }
  }

  cout << "-----------------\n";

  for (int r = 0; r < rNum; ++r) {
    for (long elm : ar[r]) cout << setw(5) << elm;
    cout << endl;
  }
}
