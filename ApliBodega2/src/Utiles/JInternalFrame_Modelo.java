package Utiles;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JInternalFrame_Modelo extends javax.swing.JInternalFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Creates new form JInternalFrame */
    JPanel panel;

    public JInternalFrame_Modelo( JPanel panel ,String t, boolean ban1, boolean ban2 , boolean ban3, boolean ban4) {
        super( t, ban1, ban2, ban3, ban4  );
        this.panel = panel;
        initComponents();
        setContentPane( panel );
        pack();
//        JOptionPane.showMessageDialog(this, "Prueba mensaje-.");
        setDefaultCloseOperation( javax.swing.JInternalFrame.DISPOSE_ON_CLOSE );
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setName("Form"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 394, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 286, Short.MAX_VALUE));
        
        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
