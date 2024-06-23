#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main() {
	int n, m;
	vector<int> ans;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		vector<int> v;
		int p, l;
		cin >> p >> l;
		for (int j = 0; j < p; j++) {
			int score;
			cin >> score;
			v.push_back(score);
		}
		if (l > p) {
			ans.push_back(1);
			continue;
		}
		sort(v.begin(), v.end(), greater<int>());
		ans.push_back(v[l - 1]);
	}
	sort(ans.begin(), ans.end());
	int sum = 0, i = 0, cnt = 0;
	for (int i = 0; i < n; i++) {
		sum += ans[i];
		if (sum > m) break;
		cnt++;
	}
	cout << cnt;
}
