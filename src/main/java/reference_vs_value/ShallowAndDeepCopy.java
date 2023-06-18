package reference_vs_value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShallowAndDeepCopy {

	public static void main(String[] args) {
		shallowCopyExample();
		deepCopyExample();
	}

	static void shallowCopyExample() {
		var sharedData = Arrays.asList("1", "2", "3");
		var origin = new Value(sharedData);
		var shallowCopy = new Value(sharedData);

		System.out.println(origin + " " + shallowCopy);
		shallowCopy.data.set(0, "changed");
		System.out.println(origin + " " + shallowCopy); // both changed. because of sharing
	}

	static void deepCopyExample() {
		var sharedData = Arrays.asList("1", "2", "3");
		var origin = new Value(sharedData);
		var deepCopy = new Value(new ArrayList<>(sharedData));

		System.out.println(origin + " " + deepCopy);
		deepCopy.data.set(0, "changed");
		System.out.println(origin + " " + deepCopy); // origin not changed.
	}

	static class Value<T> {

		public List<T> data;

		Value(List<T> data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}

}
