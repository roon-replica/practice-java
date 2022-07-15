### 인터페이스를 왜 쓰는지

- 이미 알고 있는 것들
    - 변경이 필요할 때 수정이 쉬움
        - 예를 들어, Map<String,String> map = new HashMap<>();

          이렇게 사용하고 있었는데 map의 키 값에 따른 정렬이 필요해지면 생성하는 부분만 TreeMap으로 바꿔주면 됨
    - 공통으로 처리하니 중복코드 줄여줌. 추상 클래스도 마찬가지로
    - 공통인 부분은 하나로 처리하니 더 객체지향적이게 됨
    - 그 외에 더 특별한 뭔가가 있으려나..

- 추가로 알게된 것들
    - class cast
    - 인터페이스에 정의된 상수는 자동으로 public static final이라고 함
    - 정렬(Comparable 인터페이스)
      - 모든 클래스가 Comparable 인터페이스를 구현해서 정렬을 하도록 설계되어 있음


- 의문점들, 이해안되는 내용
  - 왜 인터페이스는 public 접근만 허용하도록 설계되었나
  - 인터페이스에 메서드를 추가하는 것이 "바이너리 수준에서 호환된다"는게 무슨 말인지..
  - Variable used in lambda expression should be final or effectively final 오류 발생 원인
    - 실행 스택, 람다 캡처링, java의 메모리 구조(call by value)에 대한 이해와 관련되어 있음

