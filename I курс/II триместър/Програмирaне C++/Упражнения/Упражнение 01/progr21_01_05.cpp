// ����: progr21_01_05.cpp
// �� ���-� 1 �� ������������ (C++) ��� ����. ���., ���., 1 ����
#include <iostream>
using namespace std;
int main() {
  long long sum = 0LL;
  int number = 0;
  while( sum >= 0LL ) {
    cout<<"���� ����� (���� - ����������� ����): ";
    long long next;
    cin >> next;
    sum += next;
    ++number;
  }
  cout << "������ �����������: " << sum/(double)number << endl;
}
