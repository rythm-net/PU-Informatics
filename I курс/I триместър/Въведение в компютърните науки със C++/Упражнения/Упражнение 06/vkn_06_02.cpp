#include <iostream>
#include <vector>
using namespace std;

struct AB {
    int A;
};

int main (){
    float *A=0;
    int n=0;
    cout << "Моля, въведете n: " << endl;
    cin >> n;

    if(cin.fail() || n<=1){
        cout << "Невалидна стойност" << endl;
        return 1;
    }
    A=new float[n];
    for(int i=0; i<n; i++){
        cout << "Въведете стойност за A[" << i << "] =" << endl;
        cin >> A[i];
        if(cin.fail()){
            cout<<"Невалидна стойност" << endl;
            return 2;
        }
    }
    max_number=A[0]
    float Sum=A[0]
    for(int i=0; i<n; i++)
        Sum+=A[i];
    if(A[i]>max_number) {
        max_number=A[i]
    }

    cout << "средноаритметично от всички: " << (sum/n) << endl;
    cout << "позиции, на които се среща максималното число" << max_number << endl;
    for(int i=0; i<n; i++)
        if(A[i]==max_number) {
            cout << i << endl;
        }

    float t=0
    cout << "Моля, въведете стойност за t " << endl;
    cin >> t;

    if(cin.fail()) {
        cout << "Невалидна стойност за t " << endl;
        return 4;
    }

    float sumLess=0;
    int numLess=0;
    for(int i=0; i<n; i++)
        if(A[i] < t) {
            sumless += A[i];
            numless++;
        }
    cout << "средноаритметично на числата, които са по-малки от" << t << " е: " << (sumLess/numLess) << endl;
    return 0;
}