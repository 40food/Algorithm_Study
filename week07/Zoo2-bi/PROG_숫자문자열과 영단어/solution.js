function solution(s) {
  const words = [
    "zero", "one", "two", "three", "four",
    "five", "six", "seven", "eight", "nine"
  ];

  for (let i = 0; i < words.length; i++) {
    const regex = new RegExp(words[i], "g"); // 전역 검색
    s = s.replace(regex, i); // 문자열 교체
  }

  return Number(s);
}
