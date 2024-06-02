import math

# 자연수 N 입력받기
N = int(input())

# 에라토스테네스의 체로 소수구하기
# 처음엔 모든 수가 소수인 것으로 초기화
arr = [True] * (4_000_001)

# 2부터 N의 제곱근까지의 모든 수를 확인
for i in range(2, int(math.sqrt(4_000_000))+1):
    # i가 소수인 경우
    if arr[i]:
        # i를 제외한 i의 모든 배수 지우기
        j = 2
        while i * j <= 4_000_000:
            arr[i*j] = False
            j += 1

count = 0 # 소수들의 합의 갯수 (구해야하는 값)
sum = 2 # 포인터 사이 소수들의 합
end = 2 # 소수는 2부터 시작하므로

#첫번째 포인터를 증가시키며 반복
for start in range(2,N+1):
    # 소수인 수로만 포인터 이동하게끔
    if arr[start]:
        # 두번째 포인터를 가능한 만큼 반복
        while end < N+1 and sum+end < N :
            end += 1
            # 만약 소수라면 sum에 추가
            if arr[end]:
                sum += end
        # 부분합이 N이면 카운트 증가
        if sum == N:
            count +=1
        sum -= start

print(count)