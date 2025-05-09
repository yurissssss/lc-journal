class Solution {
    public boolean isValid(String s) {
        //Deque를 Stack처럼 사용
        Deque<Character> stack = new ArrayDeque<>();

        //문자열 s를 한 글자씩 순회
        //여는 괄호 -> 닫는 괄호를 stack에 push 
        // --> 나중에 닫는 괄호가 올 때 비교할 수 있도록 준비
        for (char p : s.toCharArray()) {
            switch (p) {
                case '(': stack.push(')'); break;
                case '{': stack.push('}'); break;
                case '[': stack.push(']'); break;
                //닫는괄호일 경우
                default: 
                    //!stack.isEmpty(): stack이 비어있으면 -> 짝이 안 맞음
                    //stack.peek(): stack에서 맨 위에 있는 요소 확인 (p와 같은지)
                    if (!stack.isEmpty() && stack.peek() == p) {
                    stack.pop();  //스택의 마지막 문자 제거 
                } else {
                    //문자열 유효성 조건 위배 -> false 반환
                    return false;
                }
            }
        }
        //문자열 순회 종료, stack이 비어있으면 true / 아니라면 false 반환
        return stack.isEmpty();
    }
}