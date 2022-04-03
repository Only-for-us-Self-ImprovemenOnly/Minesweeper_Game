import java.util.Scanner; 

public class Main {

	public static void main(String[] args) {
		int satir, sutun ; 
		System.out.println("MAYIN TARLASINA  HOSGELDÝNÝZ ");
		System.out.println("OYNAMAK ÝSTEDÝÐÝNÝZ BOYUTLARI GÝRÝNÝZ: ");
		Scanner klavye = new Scanner(System.in); 
		System.out.print("Satýr Sayýsý ; ");
		satir = klavye.nextInt(); 
		System.out.println("Sütun Sayýsý : ");
		sutun = klavye.nextInt(); 
		if(satir<=0 || sutun <= 0 ) {
			System.out.println("Yanlýþ Boyut Girdiniz.");
			System.out.println("Programý Tekrar Baþlatýnýz . ");
			
		}else {
		Mayin mayinTarlasi = new Mayin(satir,sutun); 
		mayinTarlasi.baslat();
		}
	klavye.close();
	}
	
	

}
