#include<iostream>
#include<cmath>
/*
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, k, ans;
	bool flag = 0;
	cin >> n >> k;

	if (n <= k) {
		ans = 0;
	}
	else {
		for (int i = 1; i < k; i++) {
			int cnt = 0;
			while (pow(2, cnt) < n) {
				cnt++;
			}
			n -= pow(2, cnt-1);
			if (n == 0) {
				ans = 0;
				flag = 1;
				break;
			}
		}
		if (!flag) {
			int cnt = 0;
			while (pow(2, cnt) < n) {
				cnt++;
			}
			ans = pow(2, cnt) - n;
		}
	}
	cout << ans;
}*/