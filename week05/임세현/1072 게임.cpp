#include<iostream>
#include<cmath>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	long long x, y;
	cin >> x >> y;

	int left = 0, right = 1000000000;
	if (x == y) {
		cout << -1;
		return 0;
	}
	if (y * 100 / x >= 99) {
		cout << -1;
		return 0;
	}
	int z = y *100 / x;
	int ans = -1;
	while (left<=right) {
		int mid = (left + right) / 2;
		int tmp = (y + mid) * 100 / (x + mid);
		if (z >= tmp) {
			ans = mid + 1;
			left = mid + 1;
		}
		else right = mid - 1;
	}
	cout << ans;
}
