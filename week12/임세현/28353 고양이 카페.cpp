#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main() {
	int n, k;
	vector<int> v;
	cin >> n >> k;
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		v.push_back(tmp);
	}
	sort(v.begin(), v.end());
	int st = 0, end = n - 1;
	int cnt = 0;
	while (st < end) {
		if (v[st] + v[end] <= k) {
			cnt++;
			st++;
			end--;
		}
		else end--;
	}
	cout << cnt;
}
