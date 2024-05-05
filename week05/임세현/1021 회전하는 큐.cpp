#include<iostream>
#include<queue>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	deque<int> dq;
	int n, m;
	int ans = 0;

	cin >> n >> m;
	for (int i = 1; i <= n; i++) dq.push_back(i);
	for (int i = 0; i < m; i++) {
		int tmp;
		cin >> tmp;
		int cnt = 0;
		for (auto it = dq.begin(); it != dq.end(); it++) {
			if (*it == tmp) break;
			else cnt++;
		}
		if (cnt <= dq.size() - cnt) {
			ans += cnt;
			for (int j = cnt; j > 0; j--) {
				int k = dq.front();
				dq.push_back(k);
				dq.pop_front();
			}
		}
		else {
			ans += dq.size() - cnt;
			for (int j = dq.size() - cnt; j > 0; j--) {
				int k = dq.back();
				dq.push_front(k);
				dq.pop_back();
			}
		}
		dq.pop_front();
	}
	cout << ans;
}
