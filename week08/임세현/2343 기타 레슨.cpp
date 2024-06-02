	#include<iostream>
	#include<vector>

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

		int left = 1, right = 1000000000;
		int mid;
		int ans = 1000000000;
		int blueCnt = 10000;
		while (left <= right) {
			mid = (left + right) / 2;
			int t = 0, cnt = 1;
			for (int i = 0; i < n; i++) {
				if (cnt > k) break;
				if (t + v[i] <= mid) t += v[i];
				else {
					cnt++;
					t = 0;
					i--;
				}
			}
			if (cnt > k) {
				left = mid + 1;
			}
			else {
				ans = mid;
				right = mid - 1;
			}
		}
		cout << ans;
	}
