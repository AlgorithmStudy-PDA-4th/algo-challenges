#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main() {
	int n, maxi;
	int sum = 0;
	vector<int> v;

	cin >> n;
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		sum += tmp;
		v.push_back(tmp);
	}
	cin >> maxi;

	sort(v.begin(), v.end(), greater<int>());

	if (sum <= maxi) {
		cout << v[0];
		return 0;
	}

	int left = v[v.size() - 1], right = v[0], ans = 0;
	while (left <= right) {
		int mid = (left + right) / 2;
		int tmpSum = 0;
		for (int i = 0; i < n; i++) {
			if (v[i] >= mid) tmpSum += mid;
			else tmpSum += v[i];
		}
		if (tmpSum > maxi) {
			right = mid - 1;
		}
		else {
			ans = mid;
			left = mid + 1;
		}
	}
	if (ans == 0) ans = maxi / n;
	cout << ans;
}
