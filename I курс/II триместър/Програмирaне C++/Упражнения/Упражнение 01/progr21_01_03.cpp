// ����: progr21_01_03.cpp
// �� ���-� 1 �� ������������ (C++) ��� ����. ���., ���., 1 ����
#include <iostream>
using namespace std;
int main() {
  long long n;
  cout << "���� �����: ";
  cin >> n;
  int even = 0, odd = 0;
  do {
    if ( n%10 % 2 ) ++odd;
    else ++even;
    n /= 10; // n = n/10;
  } while (n);
  cout << "���� �� ������� �����: " << even
       << "\n���� �� ��������� �����: " << odd << endl;
}
