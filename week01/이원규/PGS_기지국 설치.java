class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cur = 1; // 현재 위치
        int idx = 0; // 기지국 위치

        while (cur <= n) {
            //범위 넘어가면 끝
            if (idx >= stations.length || cur < stations[idx] - w) {
                answer++; //cur + W 지점에 설치
                cur = cur + 2 * w + 1;
            } else {
                cur = stations[idx] + w + 1; // 현재 위치를 범위 밖으로 이동
                idx++;
            }
        }

        return answer;
    }
}