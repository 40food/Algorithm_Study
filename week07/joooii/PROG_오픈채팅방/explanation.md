### 프로그래머스 - 오픈채팅방

### 코드

```js
function solution(record) {
  const result = [];
  const users = {};
  const logs = [];

  for (let i = 0; i < record.length; i++) {
    const line = record[i].split(" ");
    const command = line[0];
    const uid = line[1];
    const nickname = line[2];

    if (command === "Enter") {
      users[uid] = nickname;
      logs.push([command, uid]);
    } else if (command === "Leave") {
      logs.push([command, uid]);
    } else if (command === "Change") {
      users[uid] = nickname;
    }
  }

  for (let i = 0; i < logs.length; i++) {
    const [command, uid] = logs[i];
    const name = users[uid];
    if (command === "Enter") {
      result.push(`${name}님이 들어왔습니다.`);
    } else {
      result.push(`${name}님이 나갔습니다.`);
    }
  }

  return result;
}
```
