#include<iostream>
#include<set>
#include<queue>


using namespace std;

int main() {
	int n, k;
	cin >> n >> k;

	set<int> s;
	priority_queue<int, vector<int>, greater<int>> pq;
	int sum = 0;
	if (n <= k) {
		cout << 0;
		return 0;
	}
	for (int i = 0; i < n; i++) {
		int t;
		cin >> t;
		s.insert(t);
	}
	auto it = s.begin();
	it++;
	for (it; it != s.end(); it++) {
		pq.push(*it-*prev(it));
	}
	for (int i = 0; i < s.size() - k; i++) {
		sum += pq.top();
		pq.pop();
	}
	cout << sum;
	return 0;
}