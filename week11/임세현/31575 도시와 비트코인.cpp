#include<iostream>
#include<queue>

using namespace std;

bool field[301][301];
bool isvisit[301][301];

int main() {
	int n, m;
	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			cin >> field[i][j];
		}
	}
	queue<pair<int, int>> q;
	q.push({ 0,0 });
	while (!q.empty()) {
		pair<int, int> tmp = q.front();
		if (tmp.first == m - 1 && tmp.second == n - 1) {
			cout << "Yes";
			return 0;
		}
		q.pop();
		int x = tmp.first, y = tmp.second;
		if (x + 1 < m && !isvisit[x + 1][y] && field[x + 1][y]) {
			q.push({ x + 1, y });
			isvisit[x + 1][y] = 1;
		}
		if (y + 1 < n && !isvisit[x][y + 1] && field[x][y + 1]) {
			q.push({ x, y + 1 });
			isvisit[x][y + 1] = 1;
		}
	}
	cout << "No";
	return 0;
}
