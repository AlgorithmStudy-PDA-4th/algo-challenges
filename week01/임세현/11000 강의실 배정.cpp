#include<iostream>
#include<vector>
#include<queue>
/*
using namespace std;

struct cmp {
	bool operator()(pair<int, int> a, pair<int, int> b) {
		if (a.first == b.first) return a.second > b.second;
		else return a.first > b.first;
	}
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	priority_queue<pair<int, int>, vector<pair<int, int>>, cmp> time;
	priority_queue<int, vector<int>, greater<int>> room;

	int n;
	cin >> n;
	int cnt = 0;

	for (int i = 0; i < n; i++) {
		int s, t;
		cin >> s >> t;
		time.push({ s, t });
	}

	while (!time.empty()) {
		room.push(time.top().second);
		if (time.top().first >= room.top()) room.pop();
		time.pop();
	}
	cout << room.size();
}*/

/*
1 8
3 7
5 6
6 11
8 10
9 16
10 14
11 12
*/