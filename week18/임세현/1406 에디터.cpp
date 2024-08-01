#include<iostream>
#include<stack>
#include<string>

using namespace std;

int main() {
	stack<char> s, s2;
	string str;
	int n;
	char c;

	cin >> str >> n;
	for (int i = 0; i < str.length(); i++) s.push(str[i]);
	for (int i = 0; i < n; i++) {
		cin >> c;
		if (c == 'L' && !s.empty()) {
			s2.push(s.top());
			s.pop();
		}
		else if (c == 'D' && !s2.empty()) {
			s.push(s2.top());
			s2.pop();
		}
		else if (c == 'B' && !s.empty()) {
			s.pop();
		}
		else if (c == 'P') {
			char c2;
			cin >> c2;
			s.push(c2);
		}
	}
	while (!s.empty()) {
		s2.push(s.top());
		s.pop();
	}
	while (!s2.empty()) {
		cout << s2.top();
		s2.pop();
	}
}
