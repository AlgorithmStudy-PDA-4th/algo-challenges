#include<iostream>
#include<string.h>
#include<vector>
#include<queue>


using namespace std;

// 전역 변수 선언
vector<pair<int, int>> cost[1001];
int ans[1001];


// 다익스트라 수행
void dijkstra(int st) {
	// 초기 거리 확인
	ans[st] = 0;
	// 오름차순 우선순위 큐 <비용, 도시> <====== <도시, 비용>으로 하면 안됨 !
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push({ 0, st });
	
	while (!pq.empty()) {
		pair<int, int> tmp = pq.top();
		pq.pop();
		int curCost = tmp.first;
		int curCity = tmp.second;
		
		//이미 구한 비용이 더 작은지 확인
		if (curCost > ans[curCity]) continue;

		for (int i = 0; i < cost[curCity].size(); i++) {
			int nextCity = cost[curCity][i].first;
			int nextCost = curCost + cost[curCity][i].second;
			if (ans[nextCity] > nextCost) {
				pq.push({ nextCost, nextCity });
				ans[nextCity] = nextCost;
			}
		}
	}
}


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	// 변수 선언
	int city, bus, start, end;
	cin >> city >> bus;

	//거리 초기화(10만이 최대가 아님;;)
	fill(ans, ans + 1001, 100000001);

	// 그래프 입력
	for (int i = 0; i < bus; i++) {
		int st, en, co;
		cin >> st >> en >> co;
		cost[st].push_back({en, co});
	}

	// 출발지, 도착지 입력
	cin >> start >> end;

	dijkstra(start);
	cout << ans[end];
}
