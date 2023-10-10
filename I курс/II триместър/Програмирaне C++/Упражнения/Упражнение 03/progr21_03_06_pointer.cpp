// ����: progr21_03_06_pointer.cpp
// �� ���-� 3 �� ������������ (C++) ��� ����. ���., ���., 1 ����
#include <iostream>
using namespace std;
#include <iomanip>
int const r = 3, c = 7;
int main() {
  long t[r][c];

  int N=1;
  for( long * elmP = t[0] + c - 1; // elmP ���� ������ �������
                                   // �� ���������� ������
       elmP-t[0] < r*c; // ������ ����� �� ���������� ����� *elmP
                        // � ��-����� �� ���� �� ������ ��������
       (elmP-t[0]) % c // (elmP-t[0]) % c == true, ����� ������
                       // elmP �� ���� ������� �� 1-�� ������
         ? --elmP // �������� ��� �������� ������� � 1-� ���
         : elmP+=c // �������� ��� ������� ������� � �-�� ������
     )
  {
    int nextC = (elmP-t[0]) % c; // ������ �� �������� �� *next
    for( long * next = elmP; // next �� �������
                             // ��� 1-� ������� �� ���������
         (next-t[0]) / c < r // ������� ������ �� ���
         &&
         nextC++ < c; // ������� ������ �� ������
         next += c + 1 // ������� next ��� ���������
                       // ������� � ���������
       )
      *next = N++;
  }

  for (decltype(t[0]) row : t) {
    for (long elm : row) cout << setw(5) << elm;
    cout << endl;
  }
}
