// Файл: progr21_01_07_demo.cpp
// От упр-е 1 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
int main() {
  double ar[4] = { 1.056, -2.67, -234.2, 999 };
  ar[0] *= 100;
  cout << ar[0] << endl;
  for (int i = 0; i < 4; ++i) cout << ar[i] << "  ";
  cout << endl;
  cout << "ar = " << ar << endl;
    // извеждане на указател (константен)
  cout << "(int)ar = " << (int) ar << endl;
    // извеждане на адрес, част от указател
  double *u;
  u=ar; // константа указател се присвоява на променлива указател
  for (int i = 0; i < 4; ++i)
    cout << u[i] << "  "; // достъп чрез променлива указател
  cout << endl;
  u = &ar[1]; // насочване към втория елемент
  for (int i = -1; i < 3; ++i) // възможни са отрицателни индекси
    cout << u[i] << "  "; // достъп чрез променлива указател
  cout << endl;
  for (int i = 0; i < 4; ++i)
    cout << *(ar + i) << "  "; // аритметика с указател
  cout << endl;
  u = &ar[3]; // указател към четвъртия елемент
  for (int i = -3; i <= 0; ++i)
    cout << *(u + i) << "  ";
      // аритметика с указател към 4-я елемент
  cout << endl;
  cout << "ar = " << ar << endl;
  cout << "u = " << u << endl;
  cout << "(int)u-(int)ar = "
       << (int) u - (int) ar << endl; // изваждане на числа
  cout << "u-ar = " << u - ar << endl; // изваждане на указатели
  for (u = ar; u - ar < 4; ++u) // обхождане чрез указател
    cout << *u << "  ";
  cout << endl;
  for (u = ar + (4 - 1); u >= ar; --u) // обхождане чрез указател
    cout << *u << "  ";
  cout << endl;
}
