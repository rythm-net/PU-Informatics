// ����: progr21_01_08.cpp
// �� ���-� 1 �� ������������ (C++) ��� ����. ���., ���., 1 ����
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  srand(time(NULL));
  const int Len = 10;
  short ar[Len];
  for (short* u = ar+Len-1; u >= ar; --u) *u = rand()%11-5;
  for (short* u = ar; u-ar < Len; ++u) cout << *u << "  ";
  cout << endl;
}
