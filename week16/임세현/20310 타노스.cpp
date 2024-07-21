#include<iostream>
#include<string>

using namespace std;

int main() {
	string s;
	cin >> s;

	int one = 0, zero = 0;
	for (int i = 0; i < s.size(); i++) {
		if (s[i] == '0') zero++;
	}
	one = s.size() - zero;
	int one2 = 0, zero2 = 0;
	int zero_limit = zero / 2, one_limit = one / 2;
	string s2 = "";

	for (int i = 0; i < s.size(); i++) {
		//cout << zero2 << " " << one2 << "\n";
		if (one2 == one_limit && zero2 == zero_limit) break;
		if (s[i] == '0' && zero2 < zero_limit) {
			s2 += s[i];
			zero2++;
		}
		if (s[i] == '1') {
			if (one == one_limit || zero2 == zero_limit) {
				s2 += s[i];
				one2++;
			}
			else one--;
		}

	}
	cout << s2;
}
