#include<iostream>
#include<string>

using namespace std;

int table[20001];
int main() {
	int n, k;
	string s;

	cin >> n >> k >> s;
	
	for (int i = 0; i < n; i++) {
		if (s[i] == 'P') table[i] = 1; // 사람은 1
		else table[i] = 2;			// 햄버거는 2
	}
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		if (table[i] == 1) {
			int st = (i - k < 0) ? 0 : i - k;
			while (st < n && st <= i + k) {
				if (table[st] == 2) {
					cnt++;
					table[st] = 0;
					break;
				}
				st++;
			}
		}
	}
	cout << cnt;
}
