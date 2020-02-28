package gui;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

@SuppressWarnings("serial")
public class BasicProductWindow extends JDialog {

	private JPanel contentPanel;
	private JTextField txtCode;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtAmount;
	private JTextField txtWeight;

	private boolean ok=false;

	/**
	 * @return true, if Ok button is pressed; false, otherwise.
	 */
	public boolean okPressed () {
		return ok;
	}

	/**
	 * Constructor
	 */
	public BasicProductWindow() {
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		setBounds(100, 100, 508, 313);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
				new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,}));
		setContentPane(contentPanel);

		this.setTitle("Super on-line - Product");

		JLabel lblProduktua = new JLabel("PRODUCT");
		lblProduktua.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPanel.add(lblProduktua, "10, 2");

		JLabel lblKodea = new JLabel("Code");
		contentPanel.add(lblKodea, "2, 4, right, default");

		txtCode = new JTextField();
		contentPanel.add(txtCode, "4, 4, fill, default");
		txtCode.setColumns(10);
		txtCode.setEditable(false);
		txtCode.setVisible(true);
		txtCode.setEnabled(false);

		JLabel lblName = new JLabel("Name");
		contentPanel.add(lblName, "2, 6, right, default");

		txtName = new JTextField();
		contentPanel.add(txtName, "4, 6, 7, 1, fill, default");
		txtName.setColumns(10);

		JLabel lblPrice = new JLabel("Price");
		contentPanel.add(lblPrice, "2, 8, right, default");

		txtPrice = new JTextField();
		contentPanel.add(txtPrice, "4, 8, fill, default");
		txtPrice.setColumns(10);

		JLabel lblAmount = new JLabel("Amount");
		contentPanel.add(lblAmount, "2, 12, right, default");

		txtAmount = new JTextField();
		contentPanel.add(txtAmount, "4, 12, fill, default");
		txtAmount.setColumns(10);

		JLabel lblWeight = new JLabel("Weight");
		contentPanel.add(lblWeight, "2, 14, right, default");

		txtWeight = new JTextField();
		contentPanel.add(txtWeight, "4, 14, fill, default");
		txtWeight.setColumns(10);


		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leihokoOsagaiakHasieratu();
				ok = false;
				setVisible(false);
			}
		});

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//field validation first:
				String msg = "";

				//that the requirements must be fulfilled:
				for (Component control : contentPanel.getComponents()) {
					if ((control instanceof JTextField) &&
							(control.isVisible()) &&
							(control.isEnabled())) {
						if (((JTextField) control).getText().equals("")) {
							msg = "In all fields you have to put something";
							break;
						}
					}
				}

				//that the numeric fields be filled correctly:
				if (((txtPrice.isVisible()) && !isAReal(txtPrice.getText())) || 
						((txtWeight.isVisible()) && !isAReal(txtWeight.getText())) || 
						((txtAmount.isVisible()) && !isAnInteger(txtAmount.getText()))) {
					msg = msg + " In numeric fields, numeric values must be entered (integer or real).";
				}

				if (msg.equals("")) {
					ok = true;
					setVisible(false);					
				} else {
					JOptionPane.showMessageDialog(null, msg, "Super on-line - Validation error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		JButton btnClean = new JButton("Clean");
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leihokoOsagaiakHasieratu();
			}
		});

		contentPanel.add(btnOk, "4, 20");
		contentPanel.add(btnClean, "12, 20");
		contentPanel.add(btnCancel, "14, 20");

	}

	/**
	 * @param n string
	 * @return true, if n is integer number; false, otherwise.
	 */
	private static boolean isAnInteger(String n) {
		try {
			Integer.parseInt(n);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * @param n string
	 * @return true, if n is real number; false, otherwise.
	 */
	private static boolean isAReal(String n) {
		try {
			Double.parseDouble(n);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * sets the empty string in the text boxes in the window and 
	 * selects the first value in the combined list
	 * 
	 */
	private void leihokoOsagaiakHasieratu() { 
		for(Component control : contentPanel.getComponents()) {
			if(control instanceof JTextField) {
				((JTextField)control).setText("");
			}
			else if (control instanceof JComboBox<?>) {
				((JComboBox<?>)control).setSelectedIndex(0);
			}
		}
	}



	//methods for fetching window values:

	/**
	 * @return the value entered in the code box
	 */
	public int getTxtCode() {
		return Integer.parseInt(txtCode.getText());
	}

	/**
	 * @return the value entered in the name box
	 */
	public String getTxtName() {
		return txtName.getText();
	}

	/**
	 * @return the value entered in the price box
	 */
	public double getTxtPrice() {
		return Double.parseDouble(txtPrice.getText());
	}

	/**
	 * @return the value entered in the amount box
	 */
	public int getTxtAmount() {
		return Integer.parseInt(txtAmount.getText());
	}

	/**
	 * @return the value entered in the weight box
	 */
	public double getTxtWeight() {
		return Double.parseDouble(txtWeight.getText());
	}

}
