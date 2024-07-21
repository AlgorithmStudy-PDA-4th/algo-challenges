#include<iostream>
#include<queue>

using namespace std;

int main() {
	int n;
	priority_queue<long long, vector<long long>, greater<long long>> pq;
	cin >> n;
	for (int i = 0; i < n; i++) {
		long long a;
		cin >> a;
		pq.push(a);
	}
	while (pq.size()>1) {
		long long tmp1;
		tmp1 = pq.top();
		pq.pop();
		if (tmp1 == pq.top()) {
			pq.pop();
			pq.push(tmp1 * 2);
		}
	}
	cout << pq.top();
}
