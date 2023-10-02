#include <iostream>
using namespace std;

int main() {
    int w,x,y,z,f;
    cout<<"Цели числа w x y z: ";
    cin>>w>>x>>y>>z;
    switch((w%2!=0) + (x%2!=0) + (y%2!=0) + (z%2!=0)) {
        case 1: f=w*(x+y+z); break;
        case 2: f=(w+x)*(y+z); break;
        case 3: f=(w+x+y)*z; break;
        case 4: f=w+x+y+z;
    }
    cout<<"f("<<w<<','<<x<<','<<y<<','<<z<<") = "<<f<<endl;
    //system("pause");
}