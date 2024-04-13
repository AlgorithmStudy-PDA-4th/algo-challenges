#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int box[51];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m, big=0;
	vector<int> crane;
	vector<int> bb;
	int cnt = 0;

	cin >> n;
	for (int i = 0; i < n; i++) {//크레인 정보 입력
		int tmp;
		cin >> tmp;
		crane.push_back(tmp);
	}
	sort(crane.begin(), crane.end());//크레인 정렬
	cin >> m;
	for (int i = 0; i < m; i++) {//박스 정보 입력
		int tmp;
		cin >> tmp;
		big = max(tmp, big);
		if (big > crane[n - 1]) {
			cout << -1;
			return 0;
		}
		bb.push_back(tmp);
	}
	sort(bb.begin(), bb.end());//박스 정렬

	int j = 0;
	for (int i=0; i < bb.size();) {//박스 분류하기
		while (bb[i] <= crane[j]) {
			box[j]++;
			i++;
			if (i == m) break;
		}
		j++;
	}

	while (1) {
		cnt++;
		for (int i = 0; i < n; i++) {
			if (box[i] != 0) {
				box[i]--;//내거 하나 옮겨
				m--;
			}
			else {//다 옮겼으면 작은거 하나 옮겨
				int j = i;
				while (j > 0 && box[j]==0) j--;
				if (box[j] > 0) {
					box[j]--;
					m--;
				}
			}
			
			if (m == 0) {
				cout << cnt;
				return 0;
			}
		}
	}
}