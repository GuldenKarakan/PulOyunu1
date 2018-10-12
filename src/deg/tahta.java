
package deg;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ListIterator;
import java.util.Vector;

public class tahta extends Frame {
    int x=60;
	int y=500;
	int dx=(500/8);
	int dy=(500/8);
	int r=30;
	private Image i;
	private Graphics graph;
	public  static int say;

	int baslangic=7*8+0;
	int hedef=0*8+7;
	private static boolean sayac=true;
	private int[][] santranc_tah;
        private double[][] Q_mat;
	
	public static Vector<Integer> yol;
	public static Vector<Integer> siyah_pul;
	private int[] sayilar={8,7,6,5,4,3,2,1};
	private char[] harfler={'A','B','C','D','E','F','G','H'};
 	private static  final int birim=(500/8);
 	public int j;
        public static TextArea metin;



        public tahta(Deg nesne) {
	santranc_tah=nesne.tahta;
	Q_mat=nesne.Q_matrisi;
	say=0;
	yol=new Vector<Integer>();
	siyah_pul=new Vector<Integer>();
      
 addWindowListener(new WindowAdapter() {
   public void windowClosing(WindowEvent e) {
     dispose();
     System.exit(0);
   }
 });
 
 
 setLayout(null);
 Button myObj1=new Button("BAŞLA");
 Button myObj2=new Button("BİTİR");
 Button myObj3=new Button("YENİ OYUN");
 Button myObj4=new Button("CIKIS");
 Button myObj5=new Button("KURALLAR");

 metin=new TextArea("",55,200);
 

 add(myObj3);
 add(myObj1);
 add(myObj2);
 add(myObj4);
 add(myObj5);
 add(metin);

 metin.setVisible(true);
 metin.setLocation(590,50);
 metin.setSize(300,400);
 myObj1.setSize(100,20);
 myObj2.setSize(100,20);
 myObj1.setLocation(30,550);
 myObj2.setLocation(130,550);
 myObj3.setSize(100,20);
 myObj3.setLocation(230,550);
 myObj4.setSize(100,20);
 myObj4.setLocation(330,550);
 myObj5.setSize(100,50);
 myObj5.setLocation(680,480);


 myObj1.addActionListener(new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent e) {
			 
			 Thread myThread1=new myThread();
			   myThread1.start();
			  
               siyah_pul.clear();
               yol.clear();
			     
		}

           
                
           
	});
 
 myObj2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		   baslangic=hedef;
		 
		
		  
	}
});
 
 myObj3.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		  
		
		  dispose();
		  tahta yeni_tahta=new tahta(new Deg());
		  yeni_tahta.setSize(900,600);
		  yeni_tahta.setTitle("PUL OYUNU");
		  yeni_tahta.setBackground(Color.blue);
		  yeni_tahta.setResizable(false);
		  yeni_tahta.setVisible(true);
		
	}
});    
        
      myObj4.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		  
		
		  dispose();
		
		
	}
});   
 
  myObj5.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 
            
            
               
		metin.append("1-) Hareket eden beyaz pul;\n" +
"	- Çapraz ilerleyemez.\n" +
"	- Siyah pulları yiyemez.\n" +
"	- Siyah pulların üzerinden geçemez.\n");
		  metin.append("2-) Oyunun kurallarını bozmayacak şekilde random olarak 0 ile 9 adet arasında siyah pullar yerleştiriliyor. \n");
		  metin.append("3-) Oyun her zaman bite bilmelidir.\n");
                  metin.append("4-) Beyaz pul mümkün olan en kısa yol takip edilerek oyun tamamlıyor. \n ");
		
	}
});  
 
 
 
 
 
        }

      public boolean duvar_v(int i,int j){
	if(santranc_tah[i][j]==-1) return true;
	else return false;
}
    
       public void siyah_pul_bul(int x,int y){
	int i,u,a,sa,so;
 

i=x*8+y;
         x=i/8;
	 y=i%8;
       
    for(int c=0;c<1;c++){
        x=x+1;
        for(int c2=0;c2<2;c2++){
	
            if(x>=0&&x<8&&y>=0&&y<8){
				 
				if(duvar_v(x,y)){
					siyah_pul.add(x);
					  siyah_pul.add(y);
					
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
				 
				if(duvar_v(x,y)){
					siyah_pul.add(x);
					  siyah_pul.add(y);
				}
                                
                                
        }
       y=y-2;
    }

}
       }
       
public void yolu_yaz(Vector<Integer> vector,String isim){
 String a;
	ListIterator<Integer> iter = vector.listIterator();
	metin.append("\n"+isim+"\n");
	if(isim.equals("Beyaz pulun yolu=")) metin.append("A1->");
	for(j=0;j<vector.size();j++){
		//System.out.println();
		metin.append(Character.toString(harfler[vector.get(j+1)]));
		metin.append(Integer.toString(8-vector.get(j)));
		j++;
		if(j!=vector.size()-1) metin.append("->");
               
	}
	
	//metin.disable();
	
}

         public void paint(Graphics g) {//TAHTA ÇİZİLİRKEN İNTERNETTEN YARARLANILMŞTIR.
		
		this.getContentPane().setBackground(Color.darkGray);
        g.setColor(Color.red);
        g.fillRect(50,50,500,500);
        g.drawRect(50,50,500,500);
        g.setColor(Color.darkGray);
        g.fillRect(590,0,300,500);
        g.drawRect(590,0,300,500);
        g.setColor(Color.blue);
        for(int i=7;i>=0;i--){
       	 String b=Integer.toString(sayilar[i]);
       	 g.drawString(b,30,i*birim+90);
       	
        }
        for(int i=0;i<8;i++){
       	 String b=Character.toString(harfler[i]);
       	 g.drawString(b,i*birim+80,560);
        }
        for(int j=0;j<8;j+=2){
        for(int i=0;i<8;i+=2){
            g.fill3DRect(i*birim+50,j*birim+50,birim,birim,true);
            g.fill3DRect(i*birim+birim+50,j*birim+birim+50,birim,birim,true);
        }
       }
       
       g.setColor(Color.black);
          for(int i=0;i<8;i++){
    	   for(int j=0;j<8;j++){
    		   if(santranc_tah[i][j]==-1){
    			   g.fillOval(j*birim+birim,i*birim+birim,40,40);
    		   }
    	   }
       }
       g.setColor(Color.white);
	   g.fillOval(x, y,r,r);
		
		
	}

 
public void update(Graphics g) {
		
		if(i==null){
			i=createImage(this.getSize().width,this.getSize().height);
			graph=i.getGraphics();
		}
		
		graph.setColor(getBackground());
		graph.fillRect(0,0,this.getSize().width,this.getSize().height); 
		graph.setColor(getForeground());
		paint(graph);
		g.drawImage(i,0,0,this);
	}

   
public class myThread extends Thread{

 public void run() {
  		double max=0;
		int hamle1=0;
		 
		 x=(baslangic%8)*(500/8)+60;
		 y=(baslangic/8)*(500/8)+60;
		
		 siyah_pul_bul(baslangic/8,baslangic%8);
		 
		 yol.add(baslangic/8);
		 yol.add(baslangic%8);
		 repaint();
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while(baslangic!=hedef){
			int durum=baslangic;
			for(int j=0;j<64;j++){
				
				if(max<Q_mat[durum][j]&&durum!=j){
				  max=Q_mat[durum][j];
				  hamle1=j;
				  
				}
			}
			
			if(max>0){
				
				 x=(hamle1%8)*(500/8)+60;
				 y=(hamle1/8)*(500/8)+60;
				 yol.add(hamle1/8);
				 yol.add(hamle1%8);
				 siyah_pul_bul(hamle1/8, hamle1%8);

			}
			baslangic=hamle1;
			repaint();
			 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		}
		
		yolu_yaz(yol,"beyaz pulun yolu=");
		
              
                  yolu_yaz(siyah_pul,"karşılaşılan siyah pullar=");
                
                
		baslangic=7*8+0;
		hedef=0*8+7;
		
}
    }


}
