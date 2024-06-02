#include<iostream>
#include<algorithm>

using namespace std;

int stairs[3][301];

int main() {
	int n;
	
	cin >> n;
	for (int i = 1; i <= n; i++) cin >> stairs[0][i];
	stairs[1][1] = stairs[0][1];
	for (int i = 2; i <= n; i++) {
		stairs[1][i] = stairs[0][i] + max(stairs[1][i - 2], stairs[2][i - 2]);
		stairs[2][i] = stairs[0][i] + stairs[1][i - 1];
	}
	cout << max(stairs[1][n], stairs[2][n]);
}
