package org.example.programmers;

import java.util.*;
import java.util.stream.Collectors;


public class NumberPairs {
    static class Solution {
        public String solution(String X, String Y) {
            String answer = "";
            ArrayList<Integer> nums = new ArrayList<>();


            String[] XcharArray = X.split("");
            String[] YcharArray = Y.split("");
            List<String> xList = Arrays.stream(XcharArray).collect(Collectors.toList());
            List<String> yList = Arrays.stream(YcharArray).collect(Collectors.toList());

            int x_num, j_num;

            //    "5525"	"1255"

            for (int i = 0; i < xList.size(); i++) {
                x_num = Integer.parseInt(xList.get(i));
                for (int j = 0; j < yList.size(); j++) {
                    j_num = Integer.parseInt(yList.get(j));

                    if (x_num == j_num) {
                        nums.add(j_num);
                        yList.remove(j);
                        break;
                    }
                }
            }


            if(nums.isEmpty()) {
                answer = "-1";
                return answer;
            }


            if(nums.get(0) == 0) {
                answer = "0";
                return answer;
            }


            return nums.stream()
                    .sorted(Comparator.reverseOrder())
                    .map(Object::toString)
                    .collect(Collectors.joining());


        }
    }
    public static void main(String[] args) {
        String solution = new Solution().solution("100", "123450");

//        String solution = new Solution().solution("5525", "1255");
        System.out.println(solution);




    }
}
