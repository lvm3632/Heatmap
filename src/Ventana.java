import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import java.awt.Font;

public class Ventana extends JFrame {

	private JPanel contentPane;
	public View2 mapa;
	public static JTextField txtTmp_up;
	private JLabel TMP_UP;
	private JLabel lblTmpdown;
	public static JTextField txtTmpdown;
	private JLabel lblTmpleft;
	public static JTextField txtTemp_left;
	private JLabel lblTmpright;
	public static JTextField txtTmp_right;
	private JLabel lblRowscolumns;
	public static JTextField textFieldRowColumns;
	private JButton btnGenerarMapa;
	private JLabel label;

	
	boolean flag=false;
	private JLabel lblValorMayor;
	public static JTextField txtFieldValorMayor;
	private JLabel lblLowTemperature;
	public static JTextField txtLowTemperature;
	private JLabel lblAvg;
	public static JTextField textFieldAvg;
	private JLabel lblTemperatures;
	private JLabel label_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private View2 mapa;
			public void run() {
				try {
					Ventana frame = new Ventana(mapa.mapaDefault());
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana(BufferedImage imagen) {
		super("Mapa de calor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
			JLabel mapa = new JLabel();
			
			
			mapa.setBounds(10,11,this.getWidth()-80,this.getHeight()-150);
			contentPane.add(mapa);
			ImageIcon MyImage = new ImageIcon(imagen);
			Image img = MyImage.getImage();
			Image newImg = img.getScaledInstance(mapa.getWidth(), mapa.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon image = new ImageIcon(newImg);
			mapa.setIcon(image);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 153));
		contentPane.add(panel, BorderLayout.SOUTH);
		
		lblTemperatures = new JLabel("Temperatures -");
		lblTemperatures.setForeground(new Color(255, 255, 255));
		panel.add(lblTemperatures);
		
		lblValorMayor = new JLabel("High:");
		lblValorMayor.setHorizontalAlignment(SwingConstants.LEFT);
		lblValorMayor.setForeground(new Color(255, 255, 255));
		panel.add(lblValorMayor);
		
		txtFieldValorMayor = new JTextField();
		txtFieldValorMayor.setEditable(false);
		txtFieldValorMayor.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtFieldValorMayor.setBackground(new Color(204, 204, 204));
		panel.add(txtFieldValorMayor);
		txtFieldValorMayor.setColumns(6);
		
		lblLowTemperature = new JLabel("Low:");
		lblLowTemperature.setForeground(new Color(255, 255, 255));
		panel.add(lblLowTemperature);
		
		txtLowTemperature = new JTextField();
		txtLowTemperature.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtLowTemperature.setEditable(false);
		txtLowTemperature.setForeground(new Color(0, 0, 0));
		txtLowTemperature.setBackground(new Color(204, 204, 204));
		panel.add(txtLowTemperature);
		txtLowTemperature.setColumns(5);
		
		lblAvg = new JLabel("Avg:");
		lblAvg.setToolTipText("");
		lblAvg.setForeground(new Color(255, 255, 255));
		panel.add(lblAvg);
		
		textFieldAvg = new JTextField();
		textFieldAvg.setEditable(false);
		textFieldAvg.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldAvg.setBackground(new Color(204, 204, 204));
		textFieldAvg.setForeground(new Color(0, 0, 0));
		panel.add(textFieldAvg);
		textFieldAvg.setColumns(5);
		
		label_1 = new JLabel("|");
		label_1.setForeground(new Color(255, 255, 255));
		panel.add(label_1);
		
		TMP_UP = new JLabel("tmp_up");
		TMP_UP.setForeground(new Color(230, 230, 250));
		panel.add(TMP_UP);
		
		txtTmp_up = new JTextField();
		panel.add(txtTmp_up);
		txtTmp_up.setColumns(4);
		
		lblTmpdown = new JLabel("tmp_down");
		lblTmpdown.setForeground(new Color(230, 230, 250));
		panel.add(lblTmpdown);
		
		txtTmpdown = new JTextField();
		panel.add(txtTmpdown);
		txtTmpdown.setColumns(4);
		
		lblTmpleft = new JLabel("tmp_left");
		lblTmpleft.setForeground(new Color(230, 230, 250));
		panel.add(lblTmpleft);
		
		txtTemp_left = new JTextField();
		panel.add(txtTemp_left);
		txtTemp_left.setColumns(4);
		
		lblTmpright = new JLabel("tmp_right");
		lblTmpright.setForeground(new Color(230, 230, 250));
		panel.add(lblTmpright);
		
		txtTmp_right = new JTextField();
		panel.add(txtTmp_right);
		txtTmp_right.setColumns(4);
		
		lblRowscolumns = new JLabel("rows_columns");
		lblRowscolumns.setForeground(new Color(230, 230, 250));
		panel.add(lblRowscolumns);
		
		textFieldRowColumns = new JTextField();
		textFieldRowColumns.setColumns(4);
		panel.add(textFieldRowColumns);
		
		label = new JLabel("    ");
		panel.add(label);
		
		String high = String.format("%.2f", MatrixBuilder.high);
		String avg = String.format("%.2f", MatrixBuilder.avg);
		String low = String.format("%.2f", MatrixBuilder.low);
	
		txtLowTemperature.setText(low);
		textFieldAvg.setText(avg);
		txtFieldValorMayor.setText((high));
		
		
		btnGenerarMapa = new JButton("Generar Mapa");
		btnGenerarMapa.addActionListener(new ActionListener() {
			private View2 mapa;
			
			public void actionPerformed(ActionEvent e) {
				
				Ventana frame2 = new Ventana(mapa.mapaNuevo());
				frame2.setVisible(true);
				frame2.setLocationRelativeTo(null);
				
				frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		btnGenerarMapa.setHorizontalAlignment(SwingConstants.RIGHT);
		btnGenerarMapa.setBackground(UIManager.getColor("Button.light"));
		panel.add(btnGenerarMapa);
		
	
	}

}
