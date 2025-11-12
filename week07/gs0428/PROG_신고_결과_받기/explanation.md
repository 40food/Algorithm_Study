### [92334 - 신고 결과 받기](https://school.programmers.co.kr/learn/courses/30/lessons/92334)

#### 코드

```js
function solution(id_list, report, k) {
  // id 길이
  const n = id_list.length;

  // 유저별 이메일 받을 횟수, 신고 당한 횟수, 자신을 신고한 유저들을 관리하는 객체
  const userList = {};
  id_list.forEach((id) => {
    userList[id] = {
      email: 0,
      reported: 0,
      reportedUser: [],
    };
  });

  // 정지된 유저 목록
  const stopedUsers = [];

  report.forEach((user) => {
    const [A, B] = user.split(" ");
    // A가 B를 신고한 적이 없을 때 실행
    if (!userList[B].reportedUser.includes(A)) {
      // B 객체에서 신고한 사람 id(A)를 삽입
      userList[B].reportedUser.push(A);
      // B의 신고당한 횟수가 k와 같다면 정지 유저 목록에 삽입
      if (++userList[B].reported === k) {
        stopedUsers.push(B);
      }
    }
  });

  // 정지 당한 사람들을 순회하며
  stopedUsers.forEach((user) => {
    // 유저 목록에서 자신을 신고한 사람들의 객체에 email 값을 증가
    userList[user].reportedUser.forEach((report) => {
      userList[report].email++;
    });
  });

  // 최초 입력 받은 id 목록을 순회하며 해당 유저에 할당된 email 값 return
  return id_list.map((id) => userList[id].email);
}
```
