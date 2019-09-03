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
	   
		V oldValue = this.value;
		this.value = value;
		return oldValue;
	}
	
	@Override
	public String toString() {
	  
//	    String stringResults = "{ " + getKey() + ": " + getValue() + "}";
//	    
//	    return stringResults;
	    
	    StringBuilder results = new StringBuilder();
	    
	    results.append("{ ");
	    results.append(getKey());
	    results.append(":");
	    results.append(getValue());
	    results.append("}");
	    
	    return results.toString();
	}

}
