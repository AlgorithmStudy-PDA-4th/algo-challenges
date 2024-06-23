#include<iostream>
#include<algorithm>

using namespace std;

int main() {
	int n;
	cin >> n;

	double sum = 0, maxi = 0;
	for (int i = 0; i < n; i++) {
		double tmp;
		cin >> tmp;
		sum += tmp;
		maxi = max(maxi, tmp);
	}
	sum /= 2;
	sum += maxi / 2;
	cout << sum;
}
