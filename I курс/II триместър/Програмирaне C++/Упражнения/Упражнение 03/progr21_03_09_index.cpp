// ����: progr21_03_09_index.cpp
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
  for(int r=0 ; r<Rows; ++r)
    for(int c=0; c<Columns; ++c)
      tabl[r][c] = rand()%1486 + 5;
  for(decltype(*tabl) row : tabl) {
    for(elmType elm : row) cout<<setw(widthC)<<elm;
    cout<<endl;
  }
  // �)
  elmType sum[Columns] = {0}, min[Columns];
  for(int c=0; c<Columns; ++c) {
    min[c] = tabl[0][c];
    for(int r=0; r<Rows; ++r) {
      sum[c] += tabl[r][c];
      if(min[c] > tabl[r][c]) min[c] = tabl[r][c];
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
