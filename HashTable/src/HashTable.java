import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.lang.Math;

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
		
	    return size() == 0;
	}

	@Override
	public boolean containsKey(Object key) {
	    if(key == null) {
            throw new NullPointerException("Key cannot be null");
        }
	    
	    int hashcode = Math.abs(key.hashCode());
        int index = hashcode % entries.length;
        
        if(entries[index] == null) {
            return false;
        } else {
            List<Entry<K, V>> keyList = entries[index];
            
            for(int i = 0; i < keyList.size(); i++) {
                Entry<K, V> subKeyList = keyList.get(i);
                
                if(subKeyList.getKey().equals(key)) {
                    return true;
                }
            }
        }
	    
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
	    if(value == null || entries == null) {
	        throw new NullPointerException("Values cannot be null");
	    }
	   
	    for(int i = 0; i < entries.length; i++) {
	        
	      if(entries[i] != null) {
	          
	          for(Entry<K, V> entry : entries[i]) {
	              if(entry.getValue().equals(value)) {
	                  return true;
	              }
	          }
	      }
	       
	    }
		
		return false;
	}

	@Override
	public V get(Object key) {
	    
		if(key == null) {
		    throw new NullPointerException("Key cannot be null");
		}
		
		int hashcode = Math.abs(key.hashCode());
        int index = hashcode % entries.length;
		
		if(entries[index] == null) {
		    return null;
		} else {
		    List<Entry<K, V>> entryList = entries[index];
		    
		    for(int i = 0; i < entryList.size(); i++) {
		      
		        Entry <K, V> entry = entryList.get(i);
		        
		        if(entry.getKey().equals(key)) {
		            return entry.getValue();
		        } 
		        
		    }
		}
		
		return null;
	}

	// TODO Replace existing value doesn't work.
	@Override
	public V put(K key, V value) {

	    int hashcode = Math.abs(key.hashCode());
	    int index = hashcode % entries.length;
	    V valueReplaced = null;

	    if(entries[index] == null) {
	        List<Entry<K,V>> myList = new LinkedList<Entry<K,V>>();
	        myList.add(new HashTableEntry<K,V>(key,value));
	        
	        entries[index] = myList;
	        arraySize++;
	    }
	    else {
	        List<Entry<K,V>> list = entries[index];
	        
	        //if same key exits, replace the value;
	        for(int i = 0; i < list.size(); i++) {
	            Entry<K,V> currentEntry = list.get(i);
	            
	            if(currentEntry.getKey().equals(key)) {
	                valueReplaced = currentEntry.getValue();
	                currentEntry.setValue(value);
	            }
	        }
	        
	        if(valueReplaced == null) {
	            list.add(new HashTableEntry<K,V>(key, value));
	        }
	        
	        arraySize++;
	    }

	    return value;
	}

	@Override
	public V remove(Object key) {
	    
        if(key == null || entries == null) {
            throw new NullPointerException("Key cannot be null");
        }
        
        int hashcode = Math.abs(key.hashCode());
        int index = hashcode % entries.length;
        V valueReturned = null;
        
        if(entries[index] == null) {
            return null;
        } else {
            List<Entry<K,V>> entryList = entries[index];
            
            for(int i = 0; i < entryList.size(); i++) {
                
                Entry<K, V> entry = entryList.get(i);
                
                if(key.equals(entry.getKey())) {
                    valueReturned = entry.getValue();  
                    entryList.remove(entry);
                    break;
                }
            }
        }
        
        if(valueReturned != null) {
            arraySize--;
        }
		return valueReturned;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		
	   //TODO
		
	}

	@Override
	public void clear() {
		
	    arraySize = 0;
	    entries = (LinkedList<Entry<K,V>>[]) new LinkedList[entries.length];
		
	}

	@Override
	public Set<K> keySet() {
	    
	    if(entries == null) {
	        throw new NullPointerException("Array is null");
	    }
	    
	    Set<K> allKeys = new HashSet<K>();
	    
	    for(int i = 0; i < entries.length; i++) {
	        
	        List<Entry<K,V>> entryList = entries[i];
	        
	        if(entryList != null) {
	            for(Entry<K,V> entry : entryList) {
	              allKeys.add(entry.getKey());
	            }
	        }
	    }
	    
		return allKeys;
	}

	@Override
	public Collection<V> values() {
		if(entries == null) {
		    throw new NullPointerException("Array is null");
		}
		
		Collection<V> valuesList = new LinkedList<V>();
		
		for(int i = 0; i < entries.length; i++) {
		    if(entries[i] == null) {
		        continue;
		    }
		    
		    for(Entry<K,V> entry : entries[i]) {
		        valuesList.add(entry.getValue());
		    }
		}
		
		return valuesList;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K,V>> keyValueSet = new HashSet<Entry<K,V>>();
		
		for(int i = 0; i < entries.length; i++) {
		    if(entries[i] == null) {
		        continue;
		    } else {
		        List<Entry<K,V>> entryList = entries[i]; 
		        
		        for(int j = 0; j < entryList.size(); j++) {
		            keyValueSet.addAll(entryList);
		        }
		    }
		    
		}
		return keyValueSet;
	}
	
	@Override
	public String toString() {
	    StringBuilder builder = new StringBuilder();
	
	    for(int i = 0; i < entries.length; i++) {
	        if(entries[i] == null) {
	            continue;
	        }
	        
	        for(Entry<K,V> entry : entries[i]) {
	            builder.append("{ " + entry.getKey() + " : " + entry.getValue() + " }");
	        }
	    }
	    
	    return builder.toString();
	    
	}
	
}
