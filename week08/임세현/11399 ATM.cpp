#include<iostream>
#include<queue>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, sum = 0;
	priority_queue<int, vector<int>, greater<int>> pq;
	
	cin >> n;
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		pq.push(tmp);
	}

	while (!pq.empty()) {
		sum += pq.top() * n;
		pq.pop();
		n--;
	}
	cout << sum;
}
