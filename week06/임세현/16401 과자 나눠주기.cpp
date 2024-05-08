#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int main() {
	int m, n;
	vector<int> v;

	cin >> m >> n;


	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		v.push_back(tmp);
	}
	sort(v.begin(), v.end(), greater<int>());

	int left = 0, right = v[0];
	int ans = 0;

	while (left <= right) {
		int mid;
		if (left + right == 1) mid = 1;
		else mid = (left + right) / 2;
		if (mid == 0) break;
		int cnt = 0;
		bool check = 0;
		for (int i = 0; i < v.size(); i++) {
			cnt += v[i] / mid;
			if (cnt >= m) {
				check = 1;
				break;
			}
		}
		if (check) {
			ans = mid;
			left = mid + 1;

		}
		else {
			right = mid - 1;
		}
	}
	cout << ans;
}
