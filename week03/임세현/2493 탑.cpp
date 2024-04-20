#include<iostream>
#include<vector>
#include<stack>

using namespace std;

int ans[500001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, tmp, tmp_prev = 0;
	vector<int> v;
	stack<pair<int, int>> st;

	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> tmp;
		if (tmp_prev > tmp) st.push({ i - 1, tmp_prev });
		if (st.empty()) {
			cout << 0 << " ";
			st.push({ i,tmp });
		}
		else if (!st.empty() && st.top().second > tmp) cout << st.top().first << " ";
		else {
			while (!st.empty() && st.top().second < tmp) {
				st.pop();
			}
			if (st.empty()) cout << 0 << " ";
			else cout << st.top().first << " ";
			st.push({ i, tmp });
		}
		tmp_prev = tmp;
	}
}
