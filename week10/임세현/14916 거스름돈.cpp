#include<iostream>

using namespace std;

int main() {
	int n;
	bool check = 0;

	cin >> n;
	for (int i = n / 5; i >= 0; i--) {
		int tmp = n - (i * 5);
		if (tmp % 2 == 0) {
			cout << i + tmp / 2;
			check = 1;
			break;
		}
	}
	if (!check) cout << -1;
}
