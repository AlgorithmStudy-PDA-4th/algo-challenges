#include<iostream>
#include<vector>
#include<algorithm>
#include<string.h>

using namespace std;

int sushi[30001];
bool isit[3001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, d, k, c;
	int big = 0, again = 0;
	bool coupon = 1;

	cin >> n >> d >> k >> c;

	for (int i = 0; i < n; i++) {
		cin >> sushi[i];
	}

	for (int i = 0; i < n; i++) {
		again = 0;
		coupon = 1;
		for (int j = i; j < i + k; j++) {
			if (isit[sushi[j%n]]) again++;
			else isit[sushi[j%n]] = 1;
			if (sushi[j % n] == c) coupon = 0;
		}
		big = max(big, k - again + coupon);
		memset(isit, 0, sizeof(isit));
	}
	cout << big;
}
