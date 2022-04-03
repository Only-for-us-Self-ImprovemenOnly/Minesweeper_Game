import java.util.Scanner;
import java.util.Random;
public class Mayin {
int satir,sutun,basarili=0,puan=0; 
int [][] gizliMap; 
int [][] map ; 
int size;
boolean game = true ; 

Scanner scan = new Scanner(System.in);
Random rastgele = new Random(); 

Mayin(int satir,int sutun){
	this.satir= satir ;
	this.sutun=sutun; 
	this.gizliMap=new int [satir][sutun]; 
	this.map=new int [satir][sutun]; 
	this.size=satir*sutun;
}
public void baslat() {
	int x , y ; 
	bombaYerleri(); 
	System.out.println("Gizli Map");
	yazdirma(gizliMap);  
	System.out.println("------------");
	System.out.println("Oyuncu Mapi");
	 
	System.out.println("OYUN BAÞLADI : ");
	while(game) {
	yazdirma(map);
	System.out.print("Satýr Sayýsýný Giriniz : ");	
	x= scan.nextInt(); 
	System.out.print("Sütun Sayýsýný Giriniz : ");
	y = scan.nextInt();
	if(x<0 || x>satir-1 ) {
		System.out.println("Geçersiz Kordinatlar :: ");
		continue; 
	
	}
	if(y<0 || y>sutun-1 ) {
		System.out.println("Geçersiz Kordinatlar :: ");
	
	}
	
	if(gizliMap[x][y] != -1 ) {
		kontrol(x,y);
		basarili++;
		puan++; 
		point(x,y); 
		if(basarili == (size-(size/4))) {
			System.out.println("Tebrikler Hiçbir Bombaya Basmadýn  !");
			
		break; 
		}
		continue; 
		}
	else {
		game=false; 
		System.out.println("Game Over**");
		 
	}
	}	
}
public void kontrol(int x , int y) {
	if(gizliMap[x][y] == 0) {
		if((x>0)  && (gizliMap[x-1][y]== -1)  ) {
			map[x][y]++;
			
		}
		if( ( x<satir-1) && (gizliMap[x+1][y]== -1) ) {
			map[x][y]++;
		}
		if((y<sutun-1) &&  (gizliMap[x][y+1]== -1 ) ) {
			map[x][y]++;
		}
		if((y>0) &&  (gizliMap[x][y-1]== -1 )) {
			map[x][y]++;
		}
		
	}
	
	
}
public void bombaYerleri() {
	int Ysatir,Ysutun,sayac=0; 
	while(sayac!=(size/4)) {
		Ysatir=rastgele.nextInt(satir);
		Ysutun=rastgele.nextInt(sutun); 
		if(gizliMap[Ysatir][Ysutun] != -1 ) {
			gizliMap[Ysatir][Ysutun] = - 1; 
			sayac++; 
		}
	}
}

public void yazdirma(int [][] arry) {
	for(int i = 0 ; i<arry.length; i++) {
		for(int j = 0 ; j<arry[0].length; j++) {
			if(arry[i][j] >= 0 ) {
				System.out.print(" ");
			}
			System.out.print(arry[i][j] + "\t");
		}
		System.out.println(" ");
	}
}
public void point(int x,int y ) {
	if(gizliMap[x][y] != -1  ) {
		puan++;
		System.out.println("Puan = " + puan);
	}
}
/* 
 * KULLANICI TUSA BASIP TEKRARDAN OYUN EKRANINCA ERISEBÝLCEK (DUZENLEME OLUCAK HATA VERÝYOR ) 
 * EKRANDA BOMBAYA BASMADIKCA PUAN VERÝCEK 
 * 
public void tekrarBaslatma() {
	System.out.println("Tekrar Baþlamak Ýstermisiniz . ");
	System.out.println("Tekrar Baþlamak Ýçin "+" 1  "+ " tusuna basýnýz ");
	System.out.println("Oyundan Çýkmak Ýçin "+" 2   "+ " tusuna basýnýz ");

	int  x = scan.nextInt(); 
	switch(x) {
	case 1  : 
		baslat(); 
	case 2 : 
		System.out.println("Oyundan Ayrýldýnýz . ");
	default : 
		System.out.println("Yalýþ Tuþlama Yaptýnýz . ");
	}
	
		
}*/
	
}
