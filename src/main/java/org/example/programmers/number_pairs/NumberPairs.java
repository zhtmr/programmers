package org.example.programmers.number_pairs;

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

            int count;


            for (int i = 0; i <= 9; i++) {
                count = commonCount(xList, yList, String.valueOf(i));
                if(count > 0) {
                    for (int j = 0; j < count; j++) {
                        nums.add(i);
                    }
                }
            }


            if(nums.isEmpty()) {
                answer = "-1";
                return answer;
            }


            if(nums.stream().allMatch(e -> e.equals(0))) {
                answer = "0";
                return answer;
            }


            return nums.stream()
                    .sorted(Comparator.reverseOrder())
                    .map(Object::toString)
                    .collect(Collectors.joining());


        }

        private int commonCount(List<String> xList, List<String> yList, String s) {
            int xcount = (int)xList.stream().filter(e -> e.equals(s)).count();
            int ycount = (int)yList.stream().filter(e -> e.equals(s)).count();
            return Math.min(xcount,ycount);
        }
    }




    public static void main(String[] args) {
        String solution = new Solution().solution("100", "123450");

//        String solution = new Solution().solution("5525", "1255");
        System.out.println(solution);




    }
}
