import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private Container cp;
    private JPanel A = new JPanel();
    private JPanel B = new JPanel(new GridLayout(1, 6, 3, 3));
    private JLabel jlb =new JLabel();
    private ImageIcon icon=new ImageIcon("炸彈.png");
    private Timer ti;

    //------------
    private JButton jbtnRUN=new JButton("RUN");
    private JButton jbtnon=new JButton("上");
    private JButton jbtndown=new JButton("下");
    private JButton jbtnright=new JButton("左");
    private JButton jbtnleft=new JButton("右");
    private JButton jbtnexit=new JButton("結束");
    //----------------
    private int dirFlag=1;
    private int obx=0;
    private int oby=0;
    private int obw=122;
    private int obh=118;


    public MainFrame(){
        init();
    }
    public void init(){
        this.setDefaultCloseOperation(3);//設定關閉視窗的按鈕

        this.setBounds(0, 0, 800, 800);//設置介面大小
//        this.setResizable(false);

        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3, 3));

        jlb.setIcon(icon);
        jlb.setBounds(obx,oby,obw,obh);

        A.add(jlb);

        B.add(jbtnRUN);
        B.add(jbtnon);
        B.add(jbtndown);
        B.add(jbtnright);
        B.add(jbtnleft);
        B.add(jbtnexit);

        cp.add(A, BorderLayout.CENTER);
        cp.add(B, BorderLayout.SOUTH);

        jbtnRUN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ti.start();
            }
        });

        jbtnon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dirFlag=1;
            }
        });

        jbtndown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dirFlag=2;
            }
        });

        jbtnright.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dirFlag=3;
            }
        });

        jbtnleft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dirFlag=4;
            }
        });

        ti=new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (dirFlag){
                    case 1:
                        if (oby-20>0){
                            oby-=20;
                        }
                        break;
                    case 2:
                        if (oby+20<620){
                            oby+=20;
                        }
                        break;
                    case 3:
                        if (obx-20>0) {
                            obx -= 20;
                        }
                        break;
                    case 4:
                        if (obx+20<670){
                            obx+=20;
                        }
                        break;
                }
                jlb.setLocation(obx,oby);
            }
        });

        jbtnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
