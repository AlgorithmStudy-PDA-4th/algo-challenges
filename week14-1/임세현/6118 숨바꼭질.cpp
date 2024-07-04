#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>

using namespace std;

int hut[20001];
vector<int> v[20001];
bool isvisit[20001];

int maxi = 0;
void bfs() {
	isvisit[1] = 1;
	queue<pair<int, int>> q;
	q.push({ 0,1 });
	while (!q.empty()) {
		pair<int, int> tmp = q.front();
		q.pop();
		int sec = tmp.second;
		for (int i = 0; i < v[sec].size(); i++) {
			if (!isvisit[v[sec][i]]) {
				isvisit[v[sec][i]] = 1;
				q.push({ tmp.first + 1, v[sec][i] });
				maxi = max(maxi, tmp.first + 1);
				hut[v[sec][i]] = tmp.first + 1;
			}
		}
	}
}

int main() {
	int n, m;
	cin >> n >> m;
	
	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}

	bfs();
	int cnt = 0, first;
	for (int i = 2; i <= n; i++) {
		if (hut[i] == maxi) {
			if (cnt == 0) first = i;
			cnt++;
		}
	}
	cout << first << " " << maxi << " " << cnt;
}
