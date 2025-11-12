function solution(s) {
  let temp = "";
  let answer = "";

  for (let ch of s) {
    if (ch >= "0" && ch <= "9") {
      answer += ch;
    } else {
      temp += ch;
      switch (temp) {
        case "zero":
          answer += 0;
          temp = "";
          break;
        case "one":
          answer += 1;
          temp = "";
          break;
        case "two":
          answer += 2;
          temp = "";
          break;
        case "three":
          answer += 3;
          temp = "";
          break;
        case "four":
          answer += 4;
          temp = "";
          break;
        case "five":
          answer += 5;
          temp = "";
          break;
        case "six":
          answer += 6;
          temp = "";
          break;
        case "seven":
          answer += 7;
          temp = "";
          break;
        case "eight":
          answer += 8;
          temp = "";
          break;
        case "nine":
          answer += 9;
          temp = "";
          break;
      }
    }
  }
  return Number(answer);
}
