#include<iostream>
#include<algorithm>

using namespace std;

int siz[1001];
int many[1001];

int main() {
	int n;
	cin >> n;
	int max_box = 1;
	for (int i = 1; i <= n; i++) {
		int s;
		cin >> s;
		many[i] = s;
		siz[i] = 1;
		for (int j = 1; j < i; j++) {
			if (s > many[j]) {
				siz[i] = max(siz[j] + 1, siz[i]);
				max_box = max(max_box, siz[i]);
			}
		}
	}
	cout << max_box;
}
