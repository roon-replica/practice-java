### 참고

- https://www.baeldung.com/cs/deep-vs-shallow-copy
- https://www.baeldung.com/java-deep-copy

### references vs values

- small reference instead of the larger value

### shallow copy vs deep copy

- shallow copy: 새 객체인데 원본의 데이터에 대한 참조를 복사하는 방식을 의미하는 듯. `공유`한다는거임
- deep copy: 원본 데이터 내부까지 전부 다 값으로 복사. `의존이 전혀 없는거임`
- **reference, shallow, deep copy 개념을 정리하면   
  참조가 같은거 vs 참조는 다른데 내부 참조는 같음 vs 참조도 다르고 내부 참조도 다름으로 분류가능한듯!!**

### 불변성 vs 복사

- deep copy하면 원본이랑 새 객체랑 아예 관련없어져서 독립적이고 좋음. 근데 비쌈  
  불변이면 값이 안바뀌니까 shallow copy해도 문제없을것!

### copy on write

- 필요할때만 lazy하게 복사한다는 의미인듯
- 
