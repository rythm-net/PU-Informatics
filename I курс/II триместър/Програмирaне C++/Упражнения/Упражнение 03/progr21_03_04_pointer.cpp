// Файл: progr21_03_04_pointer.cpp
// От упр-е 3 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  srand(time(NULL));
  int const Len = 15;
  long ar[Len];
  // тук обхожданията на масива са от последен към първи елемент,
  // за да се спестят изважданията в условията на циклите

  for (long * u = ar + Len - 1; ar <= u; --u)
    *u = rand() % 6 + 5;

  // начин без да се помни, кои числа вече са изведени
  for (long * u = ar + Len - 1; ar <= u; --u) {
    long * L = ar + Len - 1;
    while (*L != *u) --L;
    if ( u < L ) continue; // числото *u вече е извеждано
    int num = 1;
    for (long * pred = u - 1; ar <= pred; --pred)
      if ( *pred == *u )
        ++num;
    cout << "числото " << *u << " се среща на " << num
         << " места\n";
  }

  // извеждане на масива чрез цикъл foreach
  cout << "\n  Масив:  ";
  for (long elm : ar) cout << elm << "  ";
  cout << "\n\n";

  // начин със запомняне в масива out, кои числа вече са изведени
  bool out[Len] = { false }, * uOut = out + Len - 1;
    // out[i]==true, точно когато ar[i] вече е изведено,
    // т. е. *uOut==true, точно когато *u вече е изведено
  for (long * u = ar + Len - 1; ar <= u; --u, --uOut)
    if ( ! *uOut ) {
      // излишно е *uOut = true;, защото *uOut няма да се използва
      int num = 1;
      bool * uPredOut = uOut - 1;//*uPredOut е съответен на *uPred
      for (long * uPred = u - 1; ar<=uPred; --uPred, --uPredOut)
        if ( *u == *uPred ) {
          ++num;
          *uPredOut = true;
        }
      cout << "Числото " << *u << " се среща на "
           << num << " места.\n";
    }

  // извеждане на масива без цикъл foreach
  cout << "\n  Масив:  ";
  for (long * u = ar; u - ar < Len; ++u)
    cout << *u << "  ";
  cout << endl;
}
