// ����: progr21_01_04.cpp
// �� ���-� 1 �� ������������ (C++) ��� ����. ���., ���., 1 ����
#include <iostream>
using namespace std;
#include <iomanip>
int main() {
  int k, n;
  do {
    cout<<"k �� 0 �� 3: ";
    cin>>k;
  } while( k<0 || 4<=k );
  do {
    cout<<"n �� "<<k+1<<" �� 9: ";
    cin>>n;
  } while( n<=k || 9<n );
  for(int f1=1, f2=k+1, f3=n+1;
      f3>0;
      --f3, f2>1 ? ++f1,--f2 : 0
      )
    cout << setw(f1) << '=' << setfill('*') << setw(f2) << '*'
         << setw(f3) << setfill(',') << '&' << setfill(' ')
         << endl;
}
