// Файл: progr21_01_01_demo.cpp
// От упр-е 1 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
#include <iomanip>
int main() {
  // вход/изход на булеви стойности
  bool b = false;
  cout << "Булева стойност (число): ";
  cin >> b; // 0 или 1
  cout << boolalpha << b << endl << noboolalpha << b << endl;
  cout << "Булева стойност (низ): ";
  cin >> boolalpha >> b >> noboolalpha; // false или true
  cout << boolalpha << b << endl << noboolalpha << b << endl;
  // широчина на поле, посока на подравняване, знак за запълване
  char fillCh = cout.fill('.');
  cout << '|' <<  left << setw(8) << "f=h" << '|' << endl
       << '|' << right << setw(8) << "f=h" << '|' << endl;
  cout << setfill(fillCh);
  cout << '|' <<  left << setw(8) << "f=h" << '|' << endl
       << '|' << right << setw(8) << "f=h" << '|' << "\n----\n";
  // формат на дробните числа
  double r = 1.2345678;
  cout << r << " = " << fixed << r << " = "
       << scientific << r << " = "
       << resetiosflags(ios::fixed | ios::scientific)
       << r << endl;
  int precis = cout.precision();
  cout.precision(3);
  cout << r << " = ";
  cout.setf(ios::fixed);
  cout << r << " = "
       << scientific << r << " = "
       << resetiosflags(ios::fixed | ios::scientific)
       << r << "\n----\n"
       << setprecision(precis);
  r = 12345678.654321;
  cout << r << " = " << fixed << r << " = "
       << scientific << r << " = "
       << resetiosflags(ios::fixed | ios::scientific)
       << r << endl;
  cout<<setprecision(3);
  cout << r << " = " << fixed << r << " = "
       << scientific << r << " = "
       << resetiosflags(ios::fixed | ios::scientific)
       << r << "\n----\n"
       << setprecision(precis);
  // бройна система 10, 8 или 16 за целите неотрицателни числа
  int num = 0b100011; // = 35
  cout << num << " (10) = " << hex << num << " (16) = "
       << oct << num << " (8) = "
       << setbase(16) << num << " (16) = " << dec << num << endl;
  num = -1;
  cout << num << " (10) = " << hex << num << " (16) = "
       << oct << num << " (8) = "
       << setbase(16) << num << " (16) = " << dec << num << endl;
}
