// ����: progr21_01_02_demo.cpp
// �� ���-� 1 �� ������������ (C++) ��� ����. ���., ���., 1 ����
#include <iostream>
using namespace std;
int main() {
  for (int i = -2; i <= 1; ++i) {
    if (i < 1) if (0 == i) cout << "i = 0; ";
               else cout << "i = " << i << "; ";
    else cout << "i = 1; ";
    switch (i) {
      case -1: cout << "-1, "; break;
      default: cout << i << ", ";
      /* no break */
      case -2: case 0: cout << i << ", ";
    }
    cout << endl;
  }
}
