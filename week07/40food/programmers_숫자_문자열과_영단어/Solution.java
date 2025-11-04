package programmers_숫자_문자열과_영단어;

import java.util.ArrayList;

class Solution {
  public int solution(String s) {
    int answer = 0;

    ArrayList<Integer> list = new ArrayList<>();

    String[] array = s.split("");
    for (int i = 0; i < s.length(); i++) {
      String now = array[i];
      if (now.compareTo("0") >= 0 && now.compareTo("9") <= 0)
        list.add(Integer.parseInt(now));
      else {
        switch (now) {
          case "z":
            list.add(0);
            i += 3;
            break;
          case "o":
            list.add(1);
            i += 2;
            break;
          case "t":
            if (array[i + 1].equals("w")) {
              list.add(2);
              i += 2;
            } else {
              list.add(3);
              i += 4;
            }
            break;
          case "f":
            if (array[i + 1].equals("o")) {
              list.add(4);
              i += 3;
            } else {
              list.add(5);
              i += 3;
            }
            break;
          case "s":
            if (array[i + 1].equals("i")) {
              list.add(6);
              i += 2;
            } else {
              list.add(7);
              i += 4;
            }
            break;
          case "e":
            list.add(8);
            i += 4;
            break;
          case "n":
            list.add(9);
            i += 3;
            break;
          default:
            break;
        }
      }
    }

    for (int i : list) {
      answer *= 10;
      answer += i;
    }

    return answer;
  }
}