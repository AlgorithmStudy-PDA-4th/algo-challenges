import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_N = 51;
    static final int MAX_P = 31;

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static class Tuple implements Comparable<Tuple> {
        int first, second, third;

        Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        @Override
        public int compareTo(Tuple other) {
            if (this.first != other.first) {
                return Integer.compare(this.first, other.first); // first 값을 기준으로 비교
            }
            if (this.second != other.second) {
                return Integer.compare(this.second, other.second); // second 값을 기준으로 비교
            }
            return Integer.compare(this.third, other.third); // third 값을 기준으로 비교
        }
    }

    static int n, m, p, c, d;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static int[] points = new int[MAX_P];
    static Map<Integer, Pair> pos = new HashMap<>();
    static Pair rudolf = new Pair(0, 0);

    static int[][] board = new int[MAX_N][MAX_N];
    static boolean[] is_live = new boolean[MAX_P];
    static int[] stun = new int[MAX_P];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken()); //산타 수
        c = Integer.parseInt(st.nextToken()); // 루돌프 힘
        d = Integer.parseInt(st.nextToken()); // 산타 힘

        st = new StringTokenizer(br.readLine());
        rudolf.first = Integer.parseInt(st.nextToken());
        rudolf.second = Integer.parseInt(st.nextToken());
        board[rudolf.first][rudolf.second] = -1;

        for (int i = 1; i <= p; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken()); //산타 번호
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pos.put(id, new Pair(x, y));
            board[x][y] = id;
            is_live[id] = true;
        }

        for (int t = 1; t <= m; t++) {
            int cx = 10000;
            int cy = 10000;
            int cIdx = 0;

            //살아있는 산타 중 가장 가까운 산타
            for (int i = 1; i <= p; i++) {
                if (!is_live[i]) continue;

                Tuple currentBest = new Tuple((cx - rudolf.first) * (cx - rudolf.first) + (cy - rudolf.second) * (cy - rudolf.second), -cx, -cy);
                Tuple currentValue = new Tuple((pos.get(i).first - rudolf.first) * (pos.get(i).first - rudolf.first) + (pos.get(i).second - rudolf.second) * (pos.get(i).second - rudolf.second), -pos.get(i).first, -pos.get(i).second);

                if (currentValue.compareTo(currentBest) < 0) {
                    cx = pos.get(i).first;
                    cy = pos.get(i).second;
                    cIdx = i;
                }
            }
            //산타 방향으로 루돌프 이동
            if (cIdx != 0) {
                Pair prevRudolf = new Pair(rudolf.first, rudolf.second);
                int mx = 0;
                if (cx > rudolf.first) mx = 1;
                else if (cx < rudolf.first) mx = -1;

                int my = 0;
                if (cy > rudolf.second) my = 1;
                else if (cy < rudolf.second) my = -1;

                rudolf.first += mx;
                rudolf.second += my;
                board[prevRudolf.first][prevRudolf.second] = 0;

                //루돌프 충돌
                if (rudolf.first == cx && rudolf.second == cy) {
                    int firstX = cx + mx * c;
                    int firstY = cy + my * c;
                    int lastX = firstX;
                    int lastY = firstY;

                    stun[cIdx] = t + 1;

                    // 이동 위치에 산타 있는 경우, 연쇄 이동
                    while (isInRange(lastX, lastY) && board[lastX][lastY] > 0) {
                        lastX += mx;
                        lastY += my;
                    }
                    while (!(lastX == firstX && lastY == firstY)) {
                        int beforeX = lastX - mx;
                        int beforeY = lastY - my;

                        if (!isInRange(beforeX, beforeY)) break;

                        int idx = board[beforeX][beforeY];

                        if (!isInRange(lastX, lastY)) {
                            is_live[idx] = false;
                        } else {
                            board[lastX][lastY] = board[beforeX][beforeY];
                            pos.put(idx, new Pair(lastX, lastY));
                        }

                        lastX = beforeX;
                        lastY = beforeY;
                    }
                    points[cIdx] += c;
                    pos.put(cIdx, new Pair(firstX, firstY));
                    if (isInRange(firstX, firstY)) {
                        board[firstX][firstY] = cIdx;
                    } else {
                        is_live[cIdx] = false;
                    }
                }
            }

            board[rudolf.first][rudolf.second] = -1;

            // 산타들이 루돌프 방향으로 이동
            for (int i = 1; i <= p; i++) {
                if (!is_live[i] || stun[i] >= t) continue;

                int minDist = (pos.get(i).first - rudolf.first) * (pos.get(i).first - rudolf.first) + (pos.get(i).second - rudolf.second) * (pos.get(i).second - rudolf.second);
                int moveDir = -1;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = pos.get(i).first + dx[dir];
                    int ny = pos.get(i).second + dy[dir];

                    if (!isInRange(nx, ny) || board[nx][ny] > 0) continue;

                    int dist = (nx - rudolf.first) * (nx - rudolf.first) + (ny - rudolf.second) * (ny - rudolf.second);
                    if (dist < minDist) {
                        minDist = dist;
                        moveDir = dir;
                    }
                }

                if (moveDir != -1) {
                    int nx = pos.get(i).first + dx[moveDir];
                    int ny = pos.get(i).second + dy[moveDir];

                    if (nx == rudolf.first && ny == rudolf.second) {
                        stun[i] = t + 1;

                        int moveX = -dx[moveDir];
                        int moveY = -dy[moveDir];

                        int firstX = nx + moveX * d;
                        int firstY = ny + moveY * d;
                        int lastX = firstX;
                        int lastY = firstY;

                        if (d == 1) {
                            points[i] += d;
                        } else {
                            // 만약 이동한 위치에 산타가 있을 경우, 연쇄적으로 이동이 일어납니다.
                            while (isInRange(lastX, lastY) && board[lastX][lastY] > 0) {
                                lastX += moveX;
                                lastY += moveY;
                            }

                            // 연쇄적으로 충돌이 일어난 가장 마지막 위치에서 시작해,
                            // 순차적으로 보드판에 있는 산타를 한칸씩 이동시킵니다.
                            while (!(lastX == firstX && lastY == firstY)) {
                                int beforeX = lastX - moveX;
                                int beforeY = lastY - moveY;

                                if (!isInRange(beforeX, beforeY)) break;

                                int idx = board[beforeX][beforeY];

                                if (!isInRange(lastX, lastY)) {
                                    is_live[idx] = false;
                                } else {
                                    board[lastX][lastY] = board[beforeX][beforeY];
                                    pos.put(idx, new Pair(lastX, lastY));
                                }

                                lastX = beforeX;
                                lastY = beforeY;
                            }

                            points[i] += d;
                            board[pos.get(i).first][pos.get(i).second] = 0;
                            pos.put(i, new Pair(firstX, firstY));
                            if (isInRange(firstX, firstY)) {
                                board[firstX][firstY] = i;
                            } else {
                                is_live[i] = false;
                            }
                        }
                    } else {
                        board[pos.get(i).first][pos.get(i).second] = 0;
                        pos.put(i, new Pair(nx, ny));
                        board[nx][ny] = i;
                    }
                }
            }
            // 라운드가 끝나고 탈락하지 않은 산타들의 점수를 1 증가시킵니다.
            for (int i = 1; i <= p; i++) {
                if (is_live[i]) points[i]++;
            }
        }
        for (int i = 1; i <= p; i++)
            System.out.print(points[i] + " ");
    }

    private static boolean isInRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }
}