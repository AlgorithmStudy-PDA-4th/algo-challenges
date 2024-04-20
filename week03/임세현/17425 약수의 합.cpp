#include<iostream>

using namespace std;

long long dp[1000001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	for (int i = 1; i <= 1000000; i++) {
		for (int j = 1; i * j <= 1000000; j++) {
			dp[i * j] += i;
		}
	}
	for (int i = 2; i <= 1000000; i++) {
		dp[i] += dp[i - 1];
	}

	int t;
	cin >> t;
	while (t--) {
		int tmp;
		cin >> tmp;
		cout << dp[tmp] << "\n";
	}
	return 0;
}
