#include<iostream>
#include<vector>
#include<queue>

using namespace std;

int st, en;
vector<int> chon[101];
bool isvisit[101];

int bfs(int st) {
	queue<pair<int, int>> q;
	q.push({ 0,st });
	isvisit[st] = 1;
	while (!q.empty()) {
		pair<int, int> tmp = q.front();
		q.pop();
		int count = tmp.first;
		int person = tmp.second;
		for (int i = 0; i < chon[person].size(); i++) {
			if (chon[person][i] == en) {
				return count + 1;
			}
			if (!isvisit[chon[person][i]]) {
				isvisit[chon[person][i]] = 1;
				q.push({ count + 1, chon[person][i] });
			}
		}
	}
	return -1;
}

int main() {
	int n, m;
	cin >> n >> st >> en >> m;

	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y;
		chon[x].push_back(y);
		chon[y].push_back(x);
	}

	cout << bfs(st);
}

/*

1	2 3
2	1 7 8 9
3	1
4	5 6
5	4
6	4
7	2
8	2
9	2


*/
