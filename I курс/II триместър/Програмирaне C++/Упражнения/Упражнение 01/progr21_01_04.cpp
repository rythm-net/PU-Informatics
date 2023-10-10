// Файл: progr21_01_04.cpp
// От упр-е 1 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
#include <iomanip>
int main() {
  int k, n;
  do {
    cout<<"k от 0 до 3: ";
    cin>>k;
  } while( k<0 || 4<=k );
  do {
    cout<<"n от "<<k+1<<" до 9: ";
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
