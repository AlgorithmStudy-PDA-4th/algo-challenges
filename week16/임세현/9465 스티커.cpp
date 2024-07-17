#include<iostream>
#include<algorithm>

using namespace std;

int score[2][100001];
int ans[2][100001];

int main() {
	int t, n;
	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> n;
		// 스티커 점수 배열 입력받기
		for (int j = 0; j < 2; j++) {
			for (int k = 1; k <= n; k++) {
				cin >> score[j][k];
			}
		}
		//첫번째 줄은 고정
		for (int j = 1; j <= n; j++) {
			if (j == 1) {
				ans[0][j] = score[0][j];
				ans[1][j] = score[1][j];
			}
			//두번째 줄부터 비교하면서 확인
			else {
				ans[0][j] = max(ans[1][j - 1], ans[1][j - 2]) + score[0][j];
				ans[1][j] = max(ans[0][j - 1], ans[0][j - 2]) + score[1][j];
			}
		}
		cout << max(ans[0][n], ans[1][n]) << "\n";
	}
}
