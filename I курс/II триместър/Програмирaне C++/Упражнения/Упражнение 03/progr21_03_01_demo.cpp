// Файл: progr21_03_01_demo.cpp
// От упр-е 3 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
#include <typeinfo> // за достъп до typeid
int main() {
  long arL[]={1,2,3,4,5};
  cout<<"   --------- long arL[]={1,2,3,4,5} \n"
      <<"typeid(arL).name() = \""<<typeid(arL).name()<<"\"\n"
      <<"sizeof(arL) = "<<sizeof(arL)<<'\n';
  long *u=arL;
  cout<<"   --------- long *u=arL \n"
      <<"typeid(u).name() = \""<<typeid(u).name()<<"\"\n"
      <<"sizeof(u) = "<<sizeof(u)<<'\n';
  int ari[]={1,2,3,4,5};
  cout<<"   --------- int ari[]={1,2,3,4,5} \n"
      <<"typeid(ari).name() = \""<<typeid(ari).name()<<"\"\n"
      <<"sizeof(ari) = "<<sizeof(ari)<<'\n';
  int *ui=ari;
  cout<<"   --------- int *ui=ari \n"
      <<"typeid(ui).name() = \""<<typeid(ui).name()<<"\"\n"
      <<"sizeof(ui) = "<<sizeof(ui)<<'\n';
  long ar2d[][4]={{10,20,30},{10,20},{10}};
  cout<<"   --------- long ar2d[][4]={{10,20,30},{10,20},{10}} \n"
      <<"typeid(ar2d).name() = \""<<typeid(ar2d).name()<<"\"\n"
      <<"sizeof(ar2d) = "<<sizeof(ar2d)<<'\n'
      <<"typeid(ar2d[0]).name() = \""<<typeid(ar2d[0]).name()<<"\"\n"
      <<"sizeof(ar2d[0]) = "<<sizeof(ar2d[0])<<'\n';
  long (*ua)[4]=ar2d;
  cout<<"   --------- long (*ua)[4]=ar2d \n"
      <<"typeid(ua).name() = \""<<typeid(ua).name()<<"\"\n"
      <<"sizeof(ua) = "<<sizeof(ua)<<'\n'
      <<"typeid(*ua).name() = \""<<typeid(*ua).name()<<"\"\n"
      <<"sizeof(*ua) = "<<sizeof(*ua)<<'\n';
  u=*ua;
  cout<<"   --------- ua[0] \n"
      <<"typeid(ua[0]).name() = \""
      <<typeid(ua[0]).name()<<"\"\n"
      <<"sizeof(ua[0]) = "
      <<sizeof(ua[0])<<'\n';
  for(long elm : *ua) cout<<elm<<"  ";
  cout<<endl;
  long **uu=&u;
  cout<<"   --------- long **uu=&u \n"
      <<"typeid(uu).name() = \""<<typeid(uu).name()<<"\"\n"
      <<"sizeof(uu) = "<<sizeof(uu)<<'\n';
  cout<<"   --------- uu[0] \n"
      <<"typeid(uu[0]).name() = \""
      <<typeid(uu[0]).name()<<"\"\n"
      <<"sizeof(uu[0]) = "
      <<sizeof(uu[0])<<'\n';
  cout<<"   --------- uu[0][0] \n"
      <<"typeid(uu[0][0]).name() = \""
      <<typeid(uu[0][0]).name()<<"\"\n"
      <<"sizeof(uu[0][0]) = "
      <<sizeof(uu[0][0])<<'\n';
  // не може следното: for(long elm : *uu)
  *uu=*ua;
  cout<<"   --------- *uu=*ua \n"
      <<"typeid(*uu).name() = \""
      <<typeid(*uu).name()<<"\"\n"
      <<"sizeof(*uu) = "
      <<sizeof(*uu)<<'\n';
}
