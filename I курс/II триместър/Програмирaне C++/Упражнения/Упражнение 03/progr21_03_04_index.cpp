// ����: progr21_03_04_index.cpp
// �� ���-� 3 �� ������������ (C++) ��� ����. ���., ���., 1 ����
#include <iostream>
using namespace std;
#include <ctime>
int const Len = 15;
int main() {
  srand(time(NULL));
  long ar[Len];
  for (long &ref : ar) ref = rand() % 6 + 5;

  // ����� ��� �� �� �����, ��� ����� ���� �� ��������
  for (int i = 0; i < Len; ++i) {
    int f = 0;
    while (ar[f] != ar[i]) ++f;
    if (f < i) continue; // ������� ar[i] ���� � ���������
    int num = 1;
    for (int next = i + 1; next < Len; ++next)
      if (ar[next] == ar[i])
        ++num;
    cout << "������� " << ar[i] << " �� ����� �� " << num
         << " �����\n";
  }

  cout << "\n  �����:  ";
  for (long elm : ar) cout << elm << "  ";
  cout << "\n\n";

  // ����� ��� ��������� � ������ out, ��� ����� ���� �� ��������
  bool out[Len] = { false };
    // out[i]==true, ����� ������ ar[i] ���� � ��������
  for (int i = 0; i < Len; ++i)
    if ( ! out[i] ) { // ar[i] ��� �� � ���������
      int num = 1;
      for (int next = i + 1; next < Len; ++next)
        if (ar[next] == ar[i]) {
          ++num;
          out[next] = true;
        }
      cout << "������� " << ar[i] << " �� ����� �� " << num
           << " �����\n";
    }
}

