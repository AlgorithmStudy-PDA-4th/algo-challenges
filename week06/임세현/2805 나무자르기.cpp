#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main() {
	vector<int> v;
	int n, m;

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		v.push_back(tmp);
	}

	sort(v.begin(), v.end(), greater<int>());

	int left = 0, right = v[0];
	int ans = -1;

	while (left <= right) {
		int mid = (left + right) / 2;
		long long tmpSum = 0;
		for (int i = 0; i < n; i++) {
			if (v[i] >= mid) tmpSum += v[i] - mid;
			else break;
		}
		if (tmpSum >= m) {
			ans = mid;
			left = mid + 1;
		}
		else {
			right = mid - 1;
		}
	}
	cout << ans;
}
