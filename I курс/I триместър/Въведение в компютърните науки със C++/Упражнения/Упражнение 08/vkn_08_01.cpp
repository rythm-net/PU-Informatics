//Да се напише програма, която въвежда имената на пет студента, както и техни оценки по дисциплината ВКН.
//Програмата да намира максималния успех и да извежда имената на студентите, които го имат.

#include <iostream>
#include <string>
#include <limits>
#include <math.h>
#include <vector>
constexpr auto ARRAY_LENGTH = 5;
using namespace std;

int main() {
	float Uspeh[ARRAY_LENGTH];
	string Imena[ARRAY_LENGTH];

	float max_uspeh = 0;

	for (int i = 0; i < ARRAY_LENGTH; i++) {
		cout << "Vyvedete ime za student " << i << endl;
		//getline(cin, Imena[i]);
		cin.ignore(numeric_limits<streamsize>::max(), '\n');
		getline(cin, Imena[i]);

		cin.ignore(numeric_limits<streamsize>::max(), '\n');
		cout << "Vyvedete Uspeh za student " << i << endl;
		cin >> Uspeh[i];

		if (Uspeh[i] > max_uspeh) {
			max_uspeh = Uspeh[i];
		}
	}
	cout << "Max uspeh: " << max_uspeh << endl;

	for (int i = 0; i < ARRAY_LENGTH; i++) {
		if (Uspeh[i] == max_uspeh) {
			cout << "Student: " << Imena[i] << endl;
		}
	}
	return 0;
}