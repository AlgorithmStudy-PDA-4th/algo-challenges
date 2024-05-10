#include<iostream>
#include<vector>
#include<map>
#include<algorithm>

using namespace std;

int main() {
	int n;
	vector<int> v;
	map<int, int> m;

	cin >> n;
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		v.push_back(tmp);
	}
	vector<int> v2 = v;

	sort(v.begin(), v.end());

	int tmp = -2000000000, cnt = 0;

	for (int i = 0; i < v.size(); i++) {
		if (v[i] > tmp) {
			m[v[i]] = i-cnt;
			tmp = v[i];
		}
		else cnt++;
	}
	for (int i = 0; i < v2.size(); i++) {
		cout << m[v2[i]] << " ";
	}
}
