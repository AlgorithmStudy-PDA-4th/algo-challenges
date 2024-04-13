#include<iostream>

using namespace std;

bool prime[1000001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	bool flag = 0;
	cin >> n;

	if (n < 8) {
		cout << -1;
		return 0;
	}
	prime[0] = 1;
	prime[1] = 1;

	for (int i = 2; i * i <= 1000000; i++) {
		if (!prime[i]) {
			for (int j = 2; i * j <= 1000000; j++) prime[i * j] = 1;
		}
	}

	if (n % 2 == 0) {
		n -= 4;
		for (int i = 2; i + i <= n; i++) {
			if (!prime[i] && !prime[n - i]) {
				cout << "2 " << "2 " << i << " " << n - i;
				flag = 1;
				break;
			}
		}
	}
	else {
		n -= 5;
		for (int i = 2; i + i <= n; i++) {
			if (!prime[i] && !prime[n - i]) {
				cout << "2 " << "3 " << i << " " << n - i;
				flag = 1;
				break;
			}
		}
	}
	if (!flag) cout << -1;
}
