import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashTable<K, V> implements Map<K,V> {
	
	private final double LOAD_FACTOR_THRESHOLD = 0.75;
	
	private int arraySize;
	private List<Entry<K,V>>[] entries;
	
	public HashTable() {
		this(10);
	}
	
	public HashTable(int initalCapacity) {
		entries = (LinkedList<Entry<K,V>>[]) new LinkedList[initalCapacity];
		arraySize = 0;
	}

	@Override
	public int size() {
		
		return arraySize;
	}

	@Override
	public boolean isEmpty() {
		
		arraySize =  0;
		entries = null;
		return true;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		
		int i = 0;
		while(i < entries.length) {
			if(entries[i] == null) {
				
			}
		}
		
		return null;
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
