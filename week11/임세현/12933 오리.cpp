#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

int quack[4];
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string s;
	int maxi = 0, cnt = 0, all = 0;

	cin >> s;

	for (int i = 0; i < s.size(); i++) {
		if (s[i] == 'q') {
			quack[0]++;
			cnt++;
		}
		else if (s[i] == 'u') {
			if (quack[0] == 0) {
				cout << -1;
				return 0;
			}
			else {
				quack[0]--;
				quack[1]++;
			}
		}
		else if (s[i] == 'a') {
			if (quack[1] == 0) {
				cout << -1;
				return 0;
			}
			else {
				quack[1]--;
				quack[2]++;
			}
		}
		else if (s[i] == 'c') {
			if (quack[2] == 0) {
				cout << -1;
				return 0;
			}
			else {
				quack[2]--;
				quack[3]++;
			}
		}
		else {
			if (quack[3] == 0) {
				cout << -1;
				return 0;
			}
			else {
				quack[3]--;
				all++;
			}
		}
		maxi = max(maxi, cnt - all);
	}
	for (int i = 0; i < 4; i++) {
		if (quack[i] > 0) {
			cout << -1;
			return 0;
		}
	}
	cout << maxi;
}
