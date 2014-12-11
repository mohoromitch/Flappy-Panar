import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class FP_Component extends JComponent
{
   private Timer t;
   private final int DELAY = 16;          //Timer delay in ms.
   private JFrame parent_frame;     //The JFrame that owns this
   private MouseAdapter m_adapter;
   private FP_Panar panar;

   public FP_Component() 
   {
      ActionListener taskPerformer = new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            moveObjects();
            repaint();
         }
      };

      t = new Timer(DELAY, taskPerformer);
      t.start();

      m_adapter = new FP_Click_Listener(this);
      this.addMouseListener(m_adapter);

      panar = new FP_Panar();
   }
   public FP_Component(JFrame frame)
   {
      super();
      parent_frame = frame;
   }

   public void mouseClicked()
   {
      panar.recieveClick();
   }

   public void moveObjects()
   {
      panar.move();
   }

   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      setBackground(new Color(30, 30, 30));
      Graphics2D g2 = (Graphics2D) g;

      panar.draw(g2);
   }
}
