// Файл: progr21_03_06_pointer.cpp
// От упр-е 3 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
#include <iomanip>
int const r = 3, c = 7;
int main() {
  long t[r][c];

  int N=1;
  for( long * elmP = t[0] + c - 1; // elmP сочи първия елемент
                                   // от последната колона
       elmP-t[0] < r*c; // докато броят на елементите преди *elmP
                        // е по-малък от броя на всички елементи
       (elmP-t[0]) % c // (elmP-t[0]) % c == true, точно когато
                       // elmP не сочи елемент от 1-та колона
         ? --elmP // минаване към предишен елемент в 1-я ред
         : elmP+=c // минаване към следващ елемент в ч-та колона
     )
  {
    int nextC = (elmP-t[0]) % c; // индекс на колоната на *next
    for( long * next = elmP; // next се насочва
                             // към 1-я елемент от диагонала
         (next-t[0]) / c < r // валиден индекс на ред
         &&
         nextC++ < c; // валиден индекс на колона
         next += c + 1 // насочва next към следващия
                       // елемент в диагонала
       )
      *next = N++;
  }

  for (decltype(t[0]) row : t) {
    for (long elm : row) cout << setw(5) << elm;
    cout << endl;
  }
}
