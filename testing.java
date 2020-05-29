package pack1.testing;
import java.io.IOException; 
import java.util.ArrayList; 
import java.util.HashMap; 
import java.util.List; 
import java.util.Map; 
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Testing {

	public static void main (String[] args) {
	    List<Bank> bankList = new ArrayList<>();
	    bankList.add(new Bank("Bank 1", "IDR", 1));
	    bankList.add(new Bank("Bank 2", "IDR", 2));
	    bankList.add(new Bank("Bank 3", "MYR", 3));
	    bankList.add(new Bank("Bank 4", "MYR", 4));
        bankList.add(new Bank("Bank 5", "USD", 5));
        
        Map<String, Integer> map = new HashMap<String, Integer>();
	       for(Bank p : bankList) {
	        	if(!map.containsKey(p.getCurrency())){
	        		map.put(p.getCurrency(), 0);           
	        	}
	    		incrementValue(map, p.getCurrency());     
	    		String hasil = p.getBankId(map.get(p.getCurrency()));
	    		System.out.println(hasil);
	        }
	      }
           
//        Map<String, List<Person>> personByCity = new HashMap<>();
//        Integer bnkid = 99;
//        for(Person p : people){
//        	if(!personByCity.containsKey(p.getCity())){
//        		personByCity.put(p.getCity(), new ArrayList<>());                
//        	}
//	          personByCity.get(p.getCity()).add(p);
//        }
        
        // Let's see how we can group objects in Java 8
//		  personByCity =  people.stream()
//		                       .collect(Collectors.groupingBy(Person::getCity));
        
        //System.out.println("Person grouped by cities in Java 8: " + personByCity);	}
	
	public static<K> void incrementValue(Map<K,Integer> map, K key)
	{
		AtomicInteger atomic = new AtomicInteger(map.containsKey(key) ? map.get(key) : 0);
		map.put(key, atomic.incrementAndGet());
	}
}

class Bank { 
	private String bankId; 
	private String name; 
	private String currency;
	
	public Bank() { 
	}
	
	public Bank(String name, String city, int age) { 
		this.name = name; this.currency = city; 
	}
	
	public String getName() { 
		return name; 
	} 
	
	public void setName(String name) { 
		this.name = name; 
	} 
	
	public String getCurrency() { 
		return currency; 
	}
	
	public void setCity(String city) { 
		this.currency = city; 
	} 
	
	public void setBankId(String bankId) { 
		this.bankId = bankId; //ity.substring(0, 2) + String.valueOf(age); 
	} 
	
	public String getBankId(int bnkid) {
		String curr = "";
		if(countDigit(bnkid) > 2) {
			curr = currency.substring(0, 1);
		}
		else {
			curr = currency.substring(0, 2);
		}
		bankId = String.format("%s%02d", curr, bnkid);
		return bankId;
	}
	
	@Override public String toString() { 
		return String.format("Bank ID = %s0%s", currency); 
	} 
	
	public int countDigit(int num)
	{
		int count = 0;
		while(num != 0)
        {
            num /= 10;
            ++count;
        }
		
		return count;
	}
	
//	@Override 
//	public int hashCode() { 
//		int hash = 7; hash = 79 * hash + Objects.hashCode(this.name); 
//		hash = 79 * hash + Objects.hashCode(this.city); 
//		hash = 79 * hash + this.age; 
//		return hash; 
//	} 
	
//	@Override 
//	public boolean equals(Object obj) { 
//		if (obj == null) { 
//			return false; 
//		} 
//		if (getClass() != obj.getClass()) { 
//			return false; 
//			} 
//	final Person other = (Person) obj; 
//	if (!Objects.equals(this.name, other.name)) { 
//		return false; 
//	} 
//	if (!Objects.equals(this.city, other.city)) { 
//		return false; 
//	} 
//	if (this.age != other.age) { 
//		return false; 
//	} 
//	return true; 
//  } 
}
