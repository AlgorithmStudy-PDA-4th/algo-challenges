#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int main() {
	int n;
	vector<int> v;

	cin >> n;
	for (int i = 0; i < n; i++) {
		int t;
		cin >> t;
		v.push_back(t);
	}
	sort(v.begin(), v.end(), greater<int>());
	int end = 2;
	while (end<n) {
		if (v[end - 2] < v[end - 1] + v[end]) {
			cout << v[end] + v[end - 1] + v[end - 2];
			return 0;
		}
		else end++;
	}
	cout << -1;
	return 0;
}
