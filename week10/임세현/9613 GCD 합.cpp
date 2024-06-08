#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

bool isprime[1000001];
vector<int> prime;

int calGCD(int a, int b) {
	int gcd = 1, i = 0;
	int lim = min(a, b);
	while (prime[i] <= lim) {
		if (i < prime.size() && (a % prime[i]) == 0 && (b % prime[i]) == 0) {
			a /= prime[i];
			b /= prime[i];
			gcd *= prime[i];
		}
		else i++;
	}
	return gcd;
}

int main() {
	int t, n;
	
	for (int i = 2; i * i <= 1000000; i++) {
		if (!isprime[i]) {
			prime.push_back(i);
			for (int j = 2; i * j <= 1000000; j++) isprime[i * j] = 1;
		}
	}

	cin >> t;

	for (int i = 0; i < t; i++) {
		vector<int> v;
		long long sum = 0;

		cin >> n;
		for (int j = 0; j < n; j++) {
			int tmp;
			cin >> tmp;
			v.push_back(tmp);
		}
		for (int j = 0; j < n; j++) {
			for (int k = j + 1; k < n; k++) {
				sum += calGCD(v[j], v[k]);
			}
		}
		cout << sum << "\n";
	}
}
