import java.util.Scanner; 

public class Main {

	public static void main(String[] args) {
		int satir, sutun ; 
		System.out.println("MAYIN TARLASINA  HOSGELD�N�Z ");
		System.out.println("OYNAMAK �STED���N�Z BOYUTLARI G�R�N�Z: ");
		Scanner klavye = new Scanner(System.in); 
		System.out.print("Sat�r Say�s� ; ");
		satir = klavye.nextInt(); 
		System.out.println("S�tun Say�s� : ");
		sutun = klavye.nextInt(); 
		if(satir<=0 || sutun <= 0 ) {
			System.out.println("Yanl�� Boyut Girdiniz.");
			System.out.println("Program� Tekrar Ba�lat�n�z . ");
			
		}else {
		Mayin mayinTarlasi = new Mayin(satir,sutun); 
		mayinTarlasi.baslat();
		}
	klavye.close();
	}
	
	

}
