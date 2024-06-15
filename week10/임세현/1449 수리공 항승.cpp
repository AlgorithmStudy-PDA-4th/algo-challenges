#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, l;
	vector<int> v;

	cin >> n >> l;
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		v.push_back(tmp);
	}
	sort(v.begin(), v.end()); //이거 내림차순이던가? -> 오름차순이네요

	int start = v[0], now = 1, cnt = 0;
	while (now < n) {
		cnt++;
		while (now<n && (start + l > v[now] || start+l==1000)) {
			now++;
		}
		if (now < n) start = v[now];
	}
	if (cnt == 0) cnt = 1;
	cout << cnt;
}
