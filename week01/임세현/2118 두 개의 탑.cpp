#include<iostream>
#include<algorithm>
/*
using namespace std;

int arr[50001];
int sum[50001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, big = 0;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
		sum[i] = sum[i - 1] + arr[i];
	}
	for (int i = 0; i <	 n; i++) {
		for (int j = i; j < n; j++) {
			int unclock = sum[j] - sum[i];
			int tmp = min(unclock, sum[n]-unclock);
			big = max(big, tmp);
		}
	}
	cout << big;
}*/