#include<iostream>
#include<string>

using namespace std;

int alpha[26];

int main() {
	string s;
	cin >> s;
	for (int i = 0; i < s.size(); i++) {
		alpha[s[i] - 'A']++;
	}
	string ans = "";
	bool check = 0;
	char tmp;
	for (int i = 0; i < 26; i++) {
		if (alpha[i] % 2 == 0) {
			for (int j = 0; j < alpha[i] / 2; j++) ans += ('A' + i);
		}
		else {
			if (check) {
				cout << "I'm Sorry Hansoo";
				return 0;
			}
			else {
				for (int j = 0; j < alpha[i] / 2; j++) ans += ('A' + i);
				tmp = 'A' + i;
				check = 1;
			}
		}
	}
	if (check) {
		ans += tmp;
		for (int i = ans.size() - 2; i >= 0; i--) {
			ans += ans[i];
		}
	}
	else {
		for (int i = ans.size() - 1; i >= 0; i--) {
			ans += ans[i];
		}
	}
	cout << ans;
}
