// ����: progr21_02_04.cpp
// �� ���-� 2 �� ������������ (C++) ��� ����. ���., ���., 1 ����
#include <iostream>
using namespace std;
int main() {
  int n;
  do {
    cout<<"���� �� 2 �� 10: ";
    cin>>n;
  } while(n<2 ||10<n);
  double *ar = new double[n];
  for(int i=1; i<=n; ++i) {
    cout<<"  "<<i<<"-� �����: ";
    cin>>ar[i-1];
  }
  cout<<"����� � ������� ���:\n";
  for(int i=n-1; 0<=i; --i) cout<<ar[i]<<endl;
  delete[] ar;
  ar = NULL; // ���� ������ ������ ���� �� ������������
}
