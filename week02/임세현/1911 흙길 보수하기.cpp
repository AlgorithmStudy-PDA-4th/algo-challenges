#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

bool cmp(pair<int, int> a, pair<int, int> b) {
	if (a.first == b.first) return a.second < b.second;
	else return a.second < b.second;
};

int main() {
	int n, l;
	int cnt = 0;
	vector<pair<int, int>> v;

	cin >> n >> l;

	for (int i = 0; i < n; i++) {//¿õµ¢ÀÌ Á¤º¸ ÀÔ·Â
		int st, en;
		cin >> st >> en;
		v.push_back({ st, en-1 });
	}
	sort(v.begin(), v.end(), cmp);

	int now = v[0].first;
	for (int i = 0; i < n; i++) {
		now = max(now, v[i].first);
		int len = v[i].second - v[i].first;
		while (now <= v[i].second) {
			now += l;
			cnt++;
		}
	}
	cout << cnt;
}