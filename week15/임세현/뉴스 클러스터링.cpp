#include<algorithm>
#include<unordered_map>
#include <string>

using namespace std;

int solution(string str1, string str2) {
    
    unordered_map<string, int> m1, m2;
    string s1 = str1;
    string s2 = str2;
    
    //소문자로 전환
    for (int i = 0; i < s1.size(); i++) {
		s1[i] = tolower(s1[i]);
	}
	for (int i = 0; i < s2.size(); i++) {
		s2[i] = tolower(s2[i]);
	}
    
    //다중집합 생성
	for (int i = 0; i < s1.size() - 1; i++) {
		if ((s1[i] >= 'A' && s1[i] <= 'Z') || (s1[i] >= 'a' && s1[i] <= 'z')) {
			if ((s1[i + 1] >= 'A' && s1[i + 1] <= 'Z') || (s1[i + 1] >= 'a' && s1[i + 1] <= 'z')) {
				string tmp = s1.substr(i, 2);
				m1[tmp]++;
			}
		}
		else continue;
	}
	for (int i = 0; i < s2.size() - 1; i++) {
		if ((s2[i] >= 'A' && s2[i] <= 'Z') || (s2[i] >= 'a' && s2[i] <= 'z')) {
			if ((s2[i + 1] >= 'A' && s2[i + 1] <= 'Z') || (s2[i + 1] >= 'a' && s2[i + 1] <= 'z')) {
				string tmp = s2.substr(i, 2);
				m2[tmp]++;
			}
		}
		else continue;
	}
    
    if (s1 == s2) return 65536;
    int n = 0, u = 0;
	if (m1.size() != 0 && m2.size() != 0) {
		//m1에 대해 진행
		for (auto it = m1.begin(); it != m1.end(); it++) {
			string fir = it->first;
			int sec = it->second;

			//혼자만 있나?
			if (m2[fir] == 0) u += m1[fir];
			//교집합인가?
			else {
				u += max(m1[fir], m2[fir]);
				n += min(m1[fir], m2[fir]);
			}
		}
		//m2에 대해 진행
		for (auto it = m2.begin(); it != m2.end(); it++) {
			string fir = it->first;

			//혼자만 있나?
			if (m1[fir] == 0) u += m2[fir];
			//교집합인가? -> 두번째는 볼 필요 없음
			else continue;
		}
		return 65536 * n / u;
	}
	else return 0;
    
    
}
