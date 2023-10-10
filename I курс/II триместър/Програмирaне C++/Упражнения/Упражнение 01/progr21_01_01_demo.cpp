// ����: progr21_01_01_demo.cpp
// �� ���-� 1 �� ������������ (C++) ��� ����. ���., ���., 1 ����
#include <iostream>
using namespace std;
#include <iomanip>
int main() {
  // ����/����� �� ������ ���������
  bool b = false;
  cout << "������ �������� (�����): ";
  cin >> b; // 0 ��� 1
  cout << boolalpha << b << endl << noboolalpha << b << endl;
  cout << "������ �������� (���): ";
  cin >> boolalpha >> b >> noboolalpha; // false ��� true
  cout << boolalpha << b << endl << noboolalpha << b << endl;
  // �������� �� ����, ������ �� ������������, ���� �� ���������
  char fillCh = cout.fill('.');
  cout << '|' <<  left << setw(8) << "f=h" << '|' << endl
       << '|' << right << setw(8) << "f=h" << '|' << endl;
  cout << setfill(fillCh);
  cout << '|' <<  left << setw(8) << "f=h" << '|' << endl
       << '|' << right << setw(8) << "f=h" << '|' << "\n----\n";
  // ������ �� �������� �����
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
  // ������ ������� 10, 8 ��� 16 �� ������ ������������� �����
  int num = 0b100011; // = 35
  cout << num << " (10) = " << hex << num << " (16) = "
       << oct << num << " (8) = "
       << setbase(16) << num << " (16) = " << dec << num << endl;
  num = -1;
  cout << num << " (10) = " << hex << num << " (16) = "
       << oct << num << " (8) = "
       << setbase(16) << num << " (16) = " << dec << num << endl;
}
