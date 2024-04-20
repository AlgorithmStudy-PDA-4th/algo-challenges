#include<iostream>
#include<vector>
#include<algorithm>
#include<climits>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m;
	vector<int> v;

	cin >> n >> m;

	for (int i = 0; i < n; i++) {//수열 입력
		int tmp;
		cin >> tmp;
		v.push_back(tmp);
	}

	sort(v.begin(), v.end());//수열 정렬

	int mini = INT_MAX;
	int i = 0, j = 1;
	while (j<=n-1) {
		int tmp = v[j] - v[i];
		if (tmp == m) {
			cout << m;
			return 0;
		}
		if (tmp < m) j++;
		else {
			if (tmp < mini) {
				mini = tmp;
			}
			i++;
		}
	}
	cout << mini;
}
