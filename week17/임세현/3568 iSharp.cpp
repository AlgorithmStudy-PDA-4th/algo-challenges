#include<iostream>
#include<string>
#include<sstream>
#include<vector>

using namespace std;

int main() {
	string input;

	getline(cin, input);

	istringstream iss(input);
	vector<string> v;
	string name;

	while (iss >> name) {
		v.push_back(name);
	}

	for (int i = 1; i < v.size(); i++) {
		int len = v[i].size() - 2;
		if (v[i].size() == 1) cout << v[0] << " " << v[i] << ';\n';
		else {
			cout << v[0];
			int size = 0;
			for (int j = len; j > 0; j--) {
				if (v[i][j] == '*' || v[i][j] == '&') cout << v[i][j];
				else if (v[i][j] == ']') {
					cout << "[]";
					j--;
				}
				else {
					size = j;
					break;
				}
			}
			cout << " " << v[i].substr(0,size+1) << ";\n";
		}
	}
}
