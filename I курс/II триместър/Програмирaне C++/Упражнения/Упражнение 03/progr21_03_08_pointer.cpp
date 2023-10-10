// ����: progr21_03_08_pointer.cpp
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
  for (long long *right = ar + 1; right-ar < Len; ++right)
    if ( (bool)(*(right - 1) % 2) == (bool)(*right % 2) )
      cout << *(right - 1) << " � " << *right
           << " � ������� " << right-ar - 1
           << " � " << right-ar << endl;
  cout << "  (���� �� ��������)\n";
}
