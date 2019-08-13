import java.util.Map.Entry;

public class HashTableEntry<K, V> implements Entry<K, V> {
	
	private K key;
	private V value;
	
	public HashTableEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V value) {
		// TODO Auto-generated method stub
		return null;
	}

}
