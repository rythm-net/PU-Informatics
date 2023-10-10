// ����: progr21_03_04_pointer.cpp
// �� ���-� 3 �� ������������ (C++) ��� ����. ���., ���., 1 ����
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  srand(time(NULL));
  int const Len = 15;
  long ar[Len];
  // ��� ������������ �� ������ �� �� �������� ��� ����� �������,
  // �� �� �� ������� ������������ � ��������� �� �������

  for (long * u = ar + Len - 1; ar <= u; --u)
    *u = rand() % 6 + 5;

  // ����� ��� �� �� �����, ��� ����� ���� �� ��������
  for (long * u = ar + Len - 1; ar <= u; --u) {
    long * L = ar + Len - 1;
    while (*L != *u) --L;
    if ( u < L ) continue; // ������� *u ���� � ���������
    int num = 1;
    for (long * pred = u - 1; ar <= pred; --pred)
      if ( *pred == *u )
        ++num;
    cout << "������� " << *u << " �� ����� �� " << num
         << " �����\n";
  }

  // ��������� �� ������ ���� ����� foreach
  cout << "\n  �����:  ";
  for (long elm : ar) cout << elm << "  ";
  cout << "\n\n";

  // ����� ��� ��������� � ������ out, ��� ����� ���� �� ��������
  bool out[Len] = { false }, * uOut = out + Len - 1;
    // out[i]==true, ����� ������ ar[i] ���� � ��������,
    // �. �. *uOut==true, ����� ������ *u ���� � ��������
  for (long * u = ar + Len - 1; ar <= u; --u, --uOut)
    if ( ! *uOut ) {
      // ������� � *uOut = true;, ������ *uOut ���� �� �� ��������
      int num = 1;
      bool * uPredOut = uOut - 1;//*uPredOut � ��������� �� *uPred
      for (long * uPred = u - 1; ar<=uPred; --uPred, --uPredOut)
        if ( *u == *uPred ) {
          ++num;
          *uPredOut = true;
        }
      cout << "������� " << *u << " �� ����� �� "
           << num << " �����.\n";
    }

  // ��������� �� ������ ��� ����� foreach
  cout << "\n  �����:  ";
  for (long * u = ar; u - ar < Len; ++u)
    cout << *u << "  ";
  cout << endl;
}
