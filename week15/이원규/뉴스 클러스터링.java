import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        double answer = 0;
        // 교집합/합집합 => 자카드 유사도
        // 다중집합일때 교집합은 같은거 min, 합집합은 같은거 max
        // 대문자, 소문자 구분x
        // 영문자로 된 글자 쌍만 유효
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();

        //다중집합 생성
        for (int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);
            if ((c1 >= 'A' && c1 <= 'Z') && (c2 >= 'A' && c2 <= 'Z')) {
                list1.add(String.valueOf(c1) + String.valueOf(c2));
            }
            ;
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);
            if ((c1 >= 'A' && c1 <= 'Z') && (c2 >= 'A' && c2 <= 'Z')) {
                list2.add(String.valueOf(c1) + String.valueOf(c2));
            }
        }

        // 중복 원소 처리를 위해 두 집합 정렬
        Collections.sort(list1);
        Collections.sort(list2);

        // 교집합, 합집합 계산
        for (String s : list1) {
            if (list2.remove(s)) { // 같은거 있으면 list2에서 삭제하고 교집합에 추가
                intersection.add(s);
            }
            union.add(s);
        }
        for (String s : list2) {
            union.add(s);
        }

        if (union.size() == 0) {
            answer = 1;
        } else {
            answer = (double) intersection.size() / (double) union.size();
        }

        return (int) (answer * 65536);
    }
}