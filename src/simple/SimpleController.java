
package simple;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SimpleController implements Initializable {

    @FXML
    private TextField first;
    @FXML
    private TextField second;
    @FXML
    private TextArea output;
    @FXML
    private ScrollPane scrollpane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void Execute(ActionEvent event) {
        
        Integer f = Integer.parseInt(first.getText());
        Integer s = Integer.parseInt(second.getText());
        
        int gcd = 1;
        
        for (int i = 1; i <=f  && i <= s; ++i) {
          if (f % i == 0 && s % i == 0)
            gcd = i;
        }
        output.setText("The GCD for "+f+" and "+s+" is: "+gcd);
        
        output.appendText("\nThe primes for the 1st number are:\n");

        int flag = 0, count=0, Total=0;
        for (int i = 1; i <= f; i++) {
            if (i == 1 || i == 0)
                continue;

            flag = 1;
 
            for (int j = 2; j <= i / 2; ++j) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1){
                output.appendText(i+"\t");
                count++;
                Total++;
                
                if(count == 10){
                    output.appendText("\n");
                    count = 0;
                    
                }
            }
        }
        output.appendText("\nThere are "+Total+" primes <= to the number "+f);
        
        output.appendText("\nThe primes for the 2nd number are:\n");

        int flag1 = 0, count1=0, Total1=0;
        for (int i = 1; i <= s; i++) {
            if (i == 1 || i == 0)
                continue;

            flag1 = 1;
 
            for (int j = 2; j <= i / 2; ++j) {
                if (i % j == 0) {
                    flag1 = 0;
                    break;
                }
            }
            if (flag1 == 1){
                output.appendText(i+"\t");
                count1++;
                Total1++;
                
                if(count1 == 10){
                    output.appendText("\n");
                    count1 = 0;
                    
                }
            }
        }
        output.appendText("\nThere are "+Total1+" primes <= to the number "+f);
    }

    @FXML
    private void Clear(ActionEvent event) {
        first.setText("");
        second.setText("");
        output.setText("");
    }

    @FXML
    private void Exit(ActionEvent event) {
        System.exit(0);
    }  
}
