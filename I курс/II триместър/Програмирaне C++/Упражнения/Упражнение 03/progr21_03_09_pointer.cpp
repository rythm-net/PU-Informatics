// ����: progr21_03_09_pointer.cpp
// �� ���-� 3 �� ������������ (C++) ��� ����. ���., ���., 1 ����
#include <iostream>
using namespace std;
#include <ctime>
#include <iomanip>
int const Rows = 5, Columns = 8, widthC = 6;
int main() {
  srand(time(NULL));
  typedef long long elmType;//����� elmType ����� ������� �� long long
  elmType tabl[Rows][Columns];
  // �)
  for(elmType* elmP=*tabl + Rows*Columns-1; elmP>=*tabl; --elmP)
    *elmP = rand()%1486 + 5;
  for(elmType * firstP : tabl) {
    for(elmType * elmP = firstP; elmP-firstP<Columns; ++elmP)
      cout<<setw(widthC)<<*elmP;
    cout<<endl;
  }
  // �)
  elmType sum[Columns] = {0}, min[Columns];
  for(elmType * firstC = *tabl, * nextSum = sum, * nextMin = min;
      firstC - *tabl < Columns;
      ++firstC, ++nextSum, ++nextMin
     )
  {
    *nextMin = *firstC;
    for( elmType * nextElm = firstC;
         nextElm - *tabl < Rows*Columns;
         nextElm += Columns
       )
    {
      *nextSum += *nextElm;
      if(*nextMin > *nextElm) *nextMin = *nextElm;
    }
  }
  cout<<"���� �� ������:\n";
  for(elmType s : sum) cout<<setw(widthC)<<s;
  cout<<endl;
  cout<<"�������� �� ������:\n";
  for(elmType m : min) cout<<setw(widthC)<<m;
  cout<<endl;
  // �)
  elmType totalSum = 0LL;
  for(elmType s : sum) totalSum += s;
  elmType maxMin = min[0];
  cout<<"���� �� ������ ��������: "<<totalSum<<endl;
  for(elmType m : min)
    if(maxMin < m)
      maxMin = m;
  cout<<"���������� �� ���������� �� ������: "<<maxMin<<endl;
}
