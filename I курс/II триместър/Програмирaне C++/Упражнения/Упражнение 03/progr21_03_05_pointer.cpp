// Файл: progr21_03_05_pointer.cpp
// От упр-е 3 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
#include <ctime>
#include <iomanip>
int const rNum = 5, cNum = 10;
int main() {
  srand(time(NULL));
  long ar[rNum][cNum];

  for (decltype(ar[0]) u : ar)
    for (long &ref : u) ref = rand() % 9 + 3;

  for (decltype(ar[0]) u : ar) {
    for (long elm : u) cout << setw(5) << elm;
    cout << endl;
  }

  for (long * c = *ar; c < *ar + cNum; ++c) {
    // търсене на максимум за колоната
    long max = *c;
    for (long * r = c + cNum; r < c + rNum * cNum; r += cNum)
      if (*r > max)
        max = *r;
    // пренареждане на колоната
    for (long * r = c, *pos = c; r < c + rNum * cNum; r += cNum)
      // чрез r += cNum указателят r се насочва
      // към следващия елемент в колоната,
      // т. е. премества се вертикално надолу на един ред
      if (*r == max) {
        for (long * nr = r; nr > pos; nr -= cNum)
          *nr = *(nr - cNum);
        *(pos) = max;
        pos += cNum;
      }
  }

  cout << "-----------------\n";

  for (decltype(ar[0]) u : ar) {
    for (long elm : u) cout << setw(5) << elm;
    cout << endl;
  }
}
