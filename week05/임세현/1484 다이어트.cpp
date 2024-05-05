#include<iostream>

using namespace std;

int main() {
	bool ischeck = 0;
	int n;
	int i = 1, j = 1;
	cin >> n;

	while (1) {
		int a = j * j - i * i;
		if (a == n) {
			cout << j << "\n";
			ischeck = 1;
			i++;
			j = i + 1;
		}
		else if (a > n) {	
			if (j == i + 1) {
				if (!ischeck) cout << "-1";
				break;
			}
			i++;
		}
		else j++;
	}
}
