#include<iostream>

using namespace std;
int ans[1001];

int main() {
	int n;
	cin >> n;

	ans[1] = 1;
	ans[2] = 2;
	for (int i = 3; i <= n; i++) {
		ans[i] = ans[i - 1] + ans[i - 2];
		ans[i] %= 10007;
	}
	cout << ans[n];
}
