// ����: progr21_03_08_index.cpp
// �� ���-� 3 �� ������������ (C++) ��� ����. ���., ���., 1 ����
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
  cout << "������ ������� �������� � ������� �������:\n";
  for (int i = 1; i < Len; ++i)
    if ( (bool)(ar[i - 1] % 2) == (bool)(ar[i] % 2) )
      cout << ar[i - 1] << " � " << ar[i]
           << " � ������� " << i - 1 << " � " << i << endl;
  cout << "  (���� �� ��������)\n";
}
