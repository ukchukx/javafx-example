package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class SampleController {
  @FXML
  private Label lblErrors;

  @FXML
  private TextField txtEmail;

  @FXML
  private TextField txtPassword;

  @FXML
  private Button btnSignin;

  private static String email = "test@email.com", password = "password";

  @FXML
  public void handleSignin(MouseEvent event) {
    if (event.getSource() == btnSignin) {
      setError("");

      if (! txtEmail.getText().matches("^\\w+\\.*\\w*@\\w+\\.\\w+")) {
        setError("Provide a valid email address");
        return;
      }

      if (txtPassword.getText().isEmpty()) {
        setError("Provide a password");
        return;
      }

      boolean matches = txtEmail.getText().equals(email) && txtPassword.getText().equals(password);

      clearInputs();

      if (! matches) {
        setError("Email or password incorrect");
        return;
      }

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Sign in successful");
      alert.setHeaderText(null);
      alert.setContentText("Sign in successful!");
      alert.showAndWait();
    }
  }

  private void clearInputs() {
    txtPassword.setText("");
    txtEmail.setText("");
  }

  private void setError(String error) {
    lblErrors.setTextFill(Color.RED);
    lblErrors.setText(error);
  }
}
