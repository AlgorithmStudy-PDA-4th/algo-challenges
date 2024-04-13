#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int box[51];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m, big=0;
	vector<int> crane;
	vector<int> bb;
	int cnt = 0;

	cin >> n;
	for (int i = 0; i < n; i++) {//ũ���� ���� �Է�
		int tmp;
		cin >> tmp;
		crane.push_back(tmp);
	}
	sort(crane.begin(), crane.end());//ũ���� ����
	cin >> m;
	for (int i = 0; i < m; i++) {//�ڽ� ���� �Է�
		int tmp;
		cin >> tmp;
		big = max(tmp, big);
		if (big > crane[n - 1]) {
			cout << -1;
			return 0;
		}
		bb.push_back(tmp);
	}
	sort(bb.begin(), bb.end());//�ڽ� ����

	int j = 0;
	for (int i=0; i < bb.size();) {//�ڽ� �з��ϱ�
		while (bb[i] <= crane[j]) {
			box[j]++;
			i++;
			if (i == m) break;
		}
		j++;
	}

	while (1) {
		cnt++;
		for (int i = 0; i < n; i++) {
			if (box[i] != 0) {
				box[i]--;//���� �ϳ� �Ű�
				m--;
			}
			else {//�� �Ű����� ������ �ϳ� �Ű�
				int j = i;
				while (j > 0 && box[j]==0) j--;
				if (box[j] > 0) {
					box[j]--;
					m--;
				}
			}
			
			if (m == 0) {
				cout << cnt;
				return 0;
			}
		}
	}
}