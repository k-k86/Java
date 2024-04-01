package exercise.ex103;

public class PostalCodeService {
	
	private static int[] POSTAL_CODES = 
		{9012201, 9012204, 9012205, 9012206, 
		9012221, 9012223, 9012225, 9012227,};
	
	private static final String[] TOWN_NAMES = {
			"宜野湾市新城", "宜野湾市上原","宜野湾市赤道",
			"宜野湾市愛知", "宜野湾市伊佐", "宜野湾市大山",
			"宜野湾市大謝名", "宜野湾市宇地泊",
};
	
	public static int getPostalCode(String address) {

		for(int i = 0; i < TOWN_NAMES.length; i++) {
			
			if( TOWN_NAMES[i].equals(address) ) {
				
				return POSTAL_CODES[i];
			}
		}
		return 0;	
	}
	
	public static String getAddress(int postalCode) {
		
		for(int i = 0; i < TOWN_NAMES.length; i++) {
			
			if(POSTAL_CODES[i] == postalCode) {
				
				return TOWN_NAMES[i];
			}
			
		}
	
		return null;
	}

}
