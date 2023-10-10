// ����: progr21_03_05_pointer.cpp
// �� ���-� 3 �� ������������ (C++) ��� ����. ���., ���., 1 ����
#include <iostream>
using namespace std;
#include <ctime>
#include <iomanip>
int const rNum = 5, cNum = 10;
int main() {
  srand(time(NULL));
  long ar[rNum][cNum];

  for (decltype(ar[0]) u : ar)
    for (long &ref : u) ref = rand() % 9 + 3;

  for (decltype(ar[0]) u : ar) {
    for (long elm : u) cout << setw(5) << elm;
    cout << endl;
  }

  for (long * c = *ar; c < *ar + cNum; ++c) {
    // ������� �� �������� �� ��������
    long max = *c;
    for (long * r = c + cNum; r < c + rNum * cNum; r += cNum)
      if (*r > max)
        max = *r;
    // ������������ �� ��������
    for (long * r = c, *pos = c; r < c + rNum * cNum; r += cNum)
      // ���� r += cNum ���������� r �� �������
      // ��� ��������� ������� � ��������,
      // �. �. ��������� �� ���������� ������ �� ���� ���
      if (*r == max) {
        for (long * nr = r; nr > pos; nr -= cNum)
          *nr = *(nr - cNum);
        *(pos) = max;
        pos += cNum;
      }
  }

  cout << "-----------------\n";

  for (decltype(ar[0]) u : ar) {
    for (long elm : u) cout << setw(5) << elm;
    cout << endl;
  }
}
