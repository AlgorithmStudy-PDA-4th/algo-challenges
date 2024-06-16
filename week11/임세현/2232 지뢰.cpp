#include<iostream>
#include<vector>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	vector<int> v;
	int cnt = 0;

	cin >> n;

	v.push_back(0);
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		v.push_back(tmp);
	}
	
	for (int i = 1; i < n; i++) {
		if (v[i - 1]<=v[i] && v[i]>=v[i + 1]) cout << i << "\n";
	}
	if (v[n - 1] <= v[n]) cout << n;
}
