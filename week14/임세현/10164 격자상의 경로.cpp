#include<iostream>

using namespace std;

int field[16][16];

int main() {
	int n, m, k;
	cin >> n >> m >> k;

	field[1][1] = 1;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (i == 1 && j == 1) continue;
			field[i][j] = field[i][j - 1] + field[i - 1][j];
		}
	}

	if (k != 0) {
		int i, j;
		if (k % m == 0) {
			i = k / m;
			j = m;
		}
		else {
			i = k / m + 1;
			j = k % m;
		}
		cout << field[i][j] * field[n - i + 1][m - j + 1];
	}
	else cout << field[n][m];
}
