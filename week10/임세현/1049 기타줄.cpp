#include<iostream>
#include<algorithm>

using namespace std;

int main() {
	int n, m, six = 1000, one = 1000;
	int cost = 0;

	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int tmp1, tmp2;
		cin >> tmp1 >> tmp2;

		six = min(tmp1, six);
		one = min(tmp2, one);
	}
	if (six > one * 6) {
		cout << n * one;
		return 0;
	}
	cost += n / 6 * six;
	n %= 6;
	if(n>0) cost += min(six, one * n);
	cout << cost;
	return 0;
}
