#include<iostream>
#include<vector>
#include<climits>
#include<algorithm>
/*
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<int> v;
	int n;
	int mini = INT_MAX;
	int ans_1, ans_2;

	cin >> n;
	for (int i = 0; i < n; i++) {
		int t;
		cin >> t;
		v.push_back(t);
	}
	sort(v.begin(), v.end());

	int fir = 0, sec = n - 1;
	while (fir != sec) {
		int tmp = v[fir] + v[sec];
		if (tmp == 0) {
			cout << v[fir] << " " << v[sec];
			return 0;
		}
		if (abs(tmp) < mini) {
			mini = abs(tmp);
			ans_1 = v[fir];
			ans_2 = v[sec];
		}
		if (tmp > 0) sec--;
		else fir++;
	}
	cout << ans_1 << " " << ans_2;
}*/

/*

¹Ý·Ê ¸ðÀ½
5
-99 -2 -1 4 98
-99 98

4
-100 -2 -1 103
-100 103

5
-99 -2 -1 4 99
-99 99

5
-2 -1 1 4 99
-1 1

5
-17 -9 3 7 99
-1 1

10
-87 -42 -40 -22 -11 23 29 78 79 98
-22 23

5
-6 -8 -1 -2 -3
-2 -1


5
6 8 1 2 3
1 2

3
-10 1 2
1 2

4
999999995 999999996 999999997 1000000000
999999995 999999996

5
-98 -97 1 2 92
1 2


5
1 4 3 5 2
1 2

5
-1 4 5 6 7
-1 4

4
-4 95 -80 -2
-4 -2

5
-100 1 2 3 4
1 2

3
-3 1 3
-3 3

9
-100 -90 0 90 130 130 130 130 130
-90 90


5
-5 -3 -1 3 10
-3 3

5
-99 -98 1 0 96
0 1

5
-98 -97 1 2 92
1 2

3
-10 1 2
1 2

5
100 -1 -2 -3 -4
-2 -1

5
-100 1 2 3 4
1 2

6
-502 -80 -60 23 100 1002
-80 100

5
-100 -50 20 40 80
-50 40


*/