
package deg;
import java.awt.Color;
import java.util.ListIterator;
//import java.awt.geom.Line2D;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;




public class Deg {
public static int[][] tahta;
public static Deg nesne;
public static int kom_mat[][];
public static tahta Frame;
public static int bitisDugumu=7;
public static double[][] Q_matrisi;
 

    public Deg(){
	tahta=new int[8][8];
	for(int i=0;i<8;i++){
		for(int j=0;j<8;j++){
		tahta[i][j]=0;
		}
	}
	
		kom_mat=new int[64][64];
	for(int i=0;i<64;i++){
		for(int j=0;j<64;j++){
			 kom_mat[i][j]=-1;
		}
	}

	kom_mat[7][7]=100;
	duvar();
	kom();
        Q_matrisi=new double[64][64];
	for(int i=0;i<64;i++){
		for(int j=0;j<64;j++){
			Q_matrisi[i][j]=0;
		}
	}
	yolBul();
       
}

 public double yolBul(){//BEYAZ PULUN GİDECEĞİ YOLU BULUYOR(QLEARNİNG ALGORİTMASI ARAŞTIRILIP YAZILMIŞTIR)

    int[] komsular = new int[64];

    for(int k = 0; k < 64; ++k){

        Random rand = new Random();
        int start = (rand.nextInt(64) + 1) % 64;
        int komsuSayisi;
        double max = 0;

        do{
            for(int t=0; t < 64; ++t)
                komsular[t] = -2;

            int m = 0;
            for(int i = 0; i < 64; ++i){
                if(kom_mat[start][i] != -1){
                    komsular[m] = i;
                    ++m;
                }
            }
            komsuSayisi = m;

            int j = (rand.nextInt(64) + 1) % komsuSayisi;
            int index = komsular[j];

            m = 0;
            for(int t=0; t < 64; ++t)
                komsular[t] = -2;
            for(int l=0; l < 64; ++l){
                if(kom_mat[index][l] != -1){
                    komsular[m] = l;
                    ++m;
                }
            }
            komsuSayisi = m;

            max = Q_matrisi[index][komsular[0]];
            for(int y = 0; y < komsuSayisi; ++y){
                if(Q_matrisi[index][komsular[y]] > max)
                    max = Q_matrisi[index][komsular[y]];
            }
            Q_matrisi[start][index] = (kom_mat[start][index] + ( 0.8 * max ));

            start = index;
            
       }while(start != bitisDugumu);
    }
    return 0;
}
public void duvar(){//SİYAH PULLARINYERLERİNİ BELİRLİYOR RASTGELE ATAMA İŞLEMİNİ YAPIYOR.
	int a=0;
	Random rastgele=new Random();
	a=rastgele.nextInt(7)+2;
	int b = 0,c = 0;
	while(a>0){
	do{
		b=rastgele.nextInt(8);
		c=rastgele.nextInt(8);
	}while((b==7&&c==0)||(b==0&&c==7) );
	tahta[b][c]=-1;
	a--;
	}
}





    public boolean duvar_v(int i,int j){//GİDELEN KOMŞUDA SİYAH PUL OLUP OLMADIĞINI KONTROL EDİYOR.
	if(tahta[i][j]==-1) return true;
	else return false;
}

   
public void kom(){//TÜM KOMŞULUKLARI BULUYOR VE KOM_MAT MATRİSİNE ATIYOR.
int i,u,a,sa,so,j;
 

for(i=0;i<64;i++){
        int x=i/8;
	int y=i%8;
       
    for(int c=0;c<1;c++){
        x=x+1;
        for(int c2=0;c2<2;c2++){
	
            if(x>=0&&x<8&&y>=0&&y<8){
				 j=x*8+y;
				if(!duvar_v(x,y)&&i!=j){
					if(j!=7) kom_mat[i][j]=0;
					else kom_mat[i][j]=100;
				}
                                
                               
        }
      x=x-2;
    }
}
x=i/8;
for(int s1=0;s1<1;s1++){
        y=y+1;
        for(int s2=0;s2<2;s2++){
	
            if(x>=0&&x<8&&y>=0&&y<8){
				 j=x*8+y;
				if(!duvar_v(x,y)&&i!=j){
					if(j!=7) kom_mat[i][j]=0;
					else kom_mat[i][j]=100;
				}
                                
                                
        }
       y=y-2;
    }
}





}

}
	
public static void main(String[] args) {
		 
            	 nesne=new Deg();
	
            	 Frame = new tahta(nesne);
		 Frame.setSize(900,600);
		
		 Frame.setTitle("PUL OYUNU");
		 Frame.setBackground(Color.blue);
		 Frame.setResizable(false);
		 Frame.setVisible(true);
		 

            
            
            
	}


   
	
    
}
