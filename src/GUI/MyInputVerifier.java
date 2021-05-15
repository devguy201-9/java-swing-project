/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.kingaspx.toast.util.Toast;
import java.math.BigDecimal;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Asus
 */
public class MyInputVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        if (!text.equals("")) {
            try {
                BigDecimal value = new BigDecimal(text);
                return (value.scale() <= Math.abs(4));
            } catch (NumberFormatException e) {
                new Toast.ToastError("Vui lòng nhập số !!!", Toast.SHORT_DELAY);
                ((JTextField) input).setText("");
                return false;
            }
        } else {
            return true;
        }
    }

}
