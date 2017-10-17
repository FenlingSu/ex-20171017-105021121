import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    private Dimension dis = Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW = 400, frmH = 500, disW, disH;
    private Container cp ;
    private JPanel jpn = new JPanel(new GridLayout(3,3));
    private JTextField jtf = new JTextField();
    private JButton jbtn[] = new JButton[9];
    private LoginFrame loginFrame;

    public MainFrame(LoginFrame login){
        loginFrame = login;
        initComp();
    }

    private void initComp(){
        disW = dis.width;
        disH = dis.height;
     //   this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                loginFrame.setVisible(true);
            }
        });
        this.setBounds(disW/2-frmW/2,disH/2-frmH/2,frmW,frmH);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(5,5));
        cp.add(jpn, BorderLayout.CENTER);
        cp.add(jtf, BorderLayout.NORTH);
        jtf.setEditable(false);
        for(int i =0; i<9 ;i++){
            jbtn[i] = new JButton(Integer.toString(i));
            jpn.add(jbtn[i]);
            jbtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tempbtn = (JButton) e.getSource();
                    jtf.setText(jtf.getText()+tempbtn.getText());
                }
            });
        }
    }
}
