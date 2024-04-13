#include<iostream>
#include<vector>
// 그리디는 아닌 것 같아요
// dfs로 가보자

using namespace std;

vector<int> v = { 1,3,5,7,9 };
vector<int> o = { 2,3,5,7 };
int cnt = 0, tmp = 0;

bool isPrime(int k) {//소수 확인, 소수면 0 리턴
	if (k == 1) return 1;
	if (k == 2) return 0;
	if (k % 2 == 0) return 1;
	for (int i = 2; i * i <= k; i++) {
		if (k % i == 0) return 1;
	}
	return 0;
}

void dfs(int n) {
	if (cnt == n) {
		cout << tmp << "\n";
		return;
	}
	else {
		if (cnt == 0) {
			for (int i = 0; i < o.size(); i++) {
				tmp = o[i];
				cnt++;
				dfs(n);
				tmp /= 10;
				cnt--;
			}
		}
		else {
			for (int i = 0; i < v.size(); i++) {
				tmp = tmp * 10 + v[i];
				if (isPrime(tmp)) {
					tmp /= 10;
					continue;
				}
				else {
					cnt++;
					dfs(n);
					cnt--;
					tmp /= 10;
				}
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;
	dfs(n);
}