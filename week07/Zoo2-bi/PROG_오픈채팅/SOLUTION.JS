function solution(record) {
  const logs = [];
  const users = {};

  for (let i = 0; i < record.length; i++) {
    const parts = record[i].split(" ");
    const cmd = parts[0];
    const id = parts[1];
    const nick = parts[2];

    if (cmd === "Enter") {
      users[id] = nick; 
      logs.push(`${id} 들어옴`);
    } else if (cmd === "Leave") {
      logs.push(`${id} 나감`);
    } else if (cmd === "Change") {
      users[id] = nick; 
    }
  }

  const result = [];
  for (let i = 0; i < logs.length; i++) {
    const [id, action] = logs[i].split(" ");
    const nick = users[id];
    if (action === "들어옴") result.push(`${nick}님이 들어왔습니다.`);
    else result.push(`${nick}님이 나갔습니다.`);
  }

  return result;
}
