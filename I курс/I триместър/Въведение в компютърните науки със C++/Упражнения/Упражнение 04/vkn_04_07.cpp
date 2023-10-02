#include <iostream>
using namespace std;

int main() {
    //system("chcp 1251"); // за MS VS
    int x,y,z;
    cout<<"Цели x y z: ";
    cin>>x>>y>>z;
    cout<<"f("<<x<<";"<<y<<';'<<z<<") = "
        << ( x%2!=0 && (y==2 || y==5) && z==1
             ? "\'W\'"
             : x%2!=0 && y==-7 && z<0
               ? "\'Z\'"
               : x==-6 && y==8 && (z==4 || z==19)
                 ? "\'F\'"
                 : "\'#\'")<<endl;

    char f;
    if(x%2 && (y==2 || y==5) && z==1) f='W';
        else if(x%2 && y==-7 && z<0) f='Z';
            else if(x==-6 && y==8 && (z==4 || z==19)) f='F';
                else f='#';
                    cout<<"f("<<x<<";"<<y<<';'<<z<<") = "
                            << '\'' << f << '\'' <<endl;
    // следващият начин излишно усложнява разклоняването
    f = '?';
    // за да се избегне зависимост на f от предишния код
    if(x%2)
        if((y==2 || y==5) && z==1) f='W';
            else if(y==-7 && z<0) f='Z';
                else f='#';
                    else if(x==-6 && y==8 && (z==4 || z==19)) f='F';
                        else f='#';
                            cout<<"f("<<x<<";"<<y<<';'<<z<<") = "
                                << '\'' << f << '\'' <<endl;
    //system("pause"); // за MS VS
}