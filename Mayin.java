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
	 
	System.out.println("OYUN BA�LADI : ");
	while(game) {
	yazdirma(map);
	System.out.print("Sat�r Say�s�n� Giriniz : ");	
	x= scan.nextInt(); 
	System.out.print("S�tun Say�s�n� Giriniz : ");
	y = scan.nextInt();
	if(x<0 || x>satir-1 ) {
		System.out.println("Ge�ersiz Kordinatlar :: ");
		continue; 
	
	}
	if(y<0 || y>sutun-1 ) {
		System.out.println("Ge�ersiz Kordinatlar :: ");
	
	}
	
	if(gizliMap[x][y] != -1 ) {
		kontrol(x,y);
		basarili++;
		puan++; 
		point(x,y); 
		if(basarili == (size-(size/4))) {
			System.out.println("Tebrikler Hi�bir Bombaya Basmad�n  !");
			
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
 * KULLANICI TUSA BASIP TEKRARDAN OYUN EKRANINCA ERISEB�LCEK (DUZENLEME OLUCAK HATA VER�YOR ) 
 * EKRANDA BOMBAYA BASMADIKCA PUAN VER�CEK 
 * 
public void tekrarBaslatma() {
	System.out.println("Tekrar Ba�lamak �stermisiniz . ");
	System.out.println("Tekrar Ba�lamak ��in "+" 1  "+ " tusuna bas�n�z ");
	System.out.println("Oyundan ��kmak ��in "+" 2   "+ " tusuna bas�n�z ");

	int  x = scan.nextInt(); 
	switch(x) {
	case 1  : 
		baslat(); 
	case 2 : 
		System.out.println("Oyundan Ayr�ld�n�z . ");
	default : 
		System.out.println("Yal�� Tu�lama Yapt�n�z . ");
	}
	
		
}*/
	
}
