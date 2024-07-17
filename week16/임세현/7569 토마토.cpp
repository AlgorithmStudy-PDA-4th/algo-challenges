#include<iostream>
#include<queue>

using namespace std;

int box[101][101][101];
bool isvisit[101][101][101];
int dx[6] = { 1, -1, 0, 0, 0, 0 };
int dy[6] = { 0, 0, 1, -1, 0, 0 };
int dz[6] = { 0, 0, 0, 0, 1, -1 };
int n, m, h, cnt;

struct Node {
	int h;
	int n;
	int m;
	int cnt;
};
queue<Node> q;

int bfs() {
	if (cnt == 0) return 0;
	while (!q.empty()) {
		Node tmp = q.front();
		int tmpcnt = 0;
		q.pop();
		for (int i = 0; i < 6; i++) {
			int x2 = tmp.n + dx[i];
			int y2 = tmp.m + dy[i];
			int z2 = tmp.h + dz[i];
			if (x2 > 0 && x2 <= n && y2 > 0 && y2 <= m && z2 > 0 && z2 <= h) {
				if (isvisit[z2][x2][y2]) continue;
				else if (box[z2][x2][y2] == 0) {
					cnt--;
					if (cnt == 0) return tmp.cnt + 1;
					q.push({ z2, x2, y2, tmp.cnt + 1 });
					isvisit[z2][x2][y2] = 1;
				}
			}
		}
	}
	return -1;
}

int main() {
	cin >> m >> n >> h;
	for (int i = 1; i <= h; i++) {
		for (int j = 1; j <= n; j++) {
			for (int k = 1; k <= m; k++) {
				cin >> box[i][j][k];
				if (box[i][j][k] == 0) cnt++;
				else if (box[i][j][k] == 1) {
					q.push(Node({ i, j, k, 0 }));
					isvisit[i][j][k] = 1;
				}
			}
		}
	}
	cout << bfs();
	return 0;
}
