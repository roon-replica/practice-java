package reference_vs_value;

import java.util.Scanner;

public class CopyOnWrite {

	public static void main(String[] args) {
		var origin = new Origin<>("sample value");
		var copyOnWrite = new CopyOnWriteObject(origin);

		while (true) {
			var scanner = new Scanner(System.in);
			var command = scanner.next();

			if (command.equals("stop")) {
				break;
			} else {
				var value = copyOnWrite.value;
				copyOnWrite.updateValue(command);

				var valueAfterUpdate = copyOnWrite.value;

				System.out.println("[address, value]: " + value);
				System.out.println("[address, value]: " + valueAfterUpdate);
			}
		}
	}

	static class Origin<T> {

		public T value;

		public Origin(T value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return this.hashCode() + " " + value.toString();
		}
	}

	static class CopyOnWriteObject {

		public Origin<String> value; // Origin 참조 포함하여 기본적으로 공유 가능.
		private boolean isCopied; // 처음에 한 번 카피하는거

		public CopyOnWriteObject(Origin<String> value) {
			this.value = value;
			this.isCopied = false;
		}

		public void updateValue(String newValue) { // 근데 update하면 deep copy를 만드는 전략!!!
			if (!isCopied) { // 만약 이게 없으면 걍 레퍼런스 똑같은거 바라보게 되는거임
				this.value = new Origin<>(newValue);
				isCopied = true;
				System.out.println("copied! This happens only once!");
			}
			this.value.value = newValue;
		}
	}

}
