package view;

import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Login extends Application {

    private boolean senhaVisivel = false;



    public void start (Stage janela) throws Exception {

        // carregamento das imagens
        Image eyeOpen = new Image(getClass().getResourceAsStream("/view/resources/img/icons8-eye-50.png"));
        Image eyeClose = new Image(getClass().getResourceAsStream("/view/resources/img/icons8-eye-48.png"));


        //Visualização das imagens
        ImageView eye = new ImageView(eyeOpen);
        eye.setFitHeight(20);
        eye.setFitWidth(20);

        ImageView eye1 = new ImageView(eyeClose);
        eye1.setFitHeight(20);
        eye1.setFitWidth(20);

        //componemte utilizado para senha no javaFX
        PasswordField senha = new PasswordField();
        senha.setPromptText("Digite sua senha");

        //TextField
        TextField txtSenha = new TextField();
        txtSenha.setPromptText("Digite sua senha");
        txtSenha.setVisible(false);
        txtSenha.setManaged(false);

        //Butão
        Button toggleBtn= new Button();
        toggleBtn.setGraphic(eye);
        toggleBtn.setStyle("-fx-background-color: transparent;");

        toggleBtn.setOnAction( event -> {

            //seta o texto de txtSenha (Visivel ) para senha (passaw)
            if (senhaVisivel) {
                senha.setText(txtSenha.getText());
                senha.setVisible(true);
                senha.setManaged(true);
                txtSenha.setVisible(false);
                txtSenha.setManaged(false);
                toggleBtn.setGraphic(eye1);
                senhaVisivel = false;
            } else {
                txtSenha.setText(txtSenha.getText());
                txtSenha.setVisible(true);
                txtSenha.setManaged(true);
                senha.setVisible(false);
                txtSenha.setManaged(false);
                toggleBtn.setGraphic(eye1);
                senhaVisivel = true;
                

            }



        });



        HBox senhaBox = new HBox(10, senha, toggleBtn);
        senhaBox.setAlignment(Pos.CENTER);

        //icon da logo
            Image imagIcon = new Image(getClass().getResourceAsStream("/view/resources/img/logo-moon-new.png"));
            ImageView imageTop = new ImageView(imagIcon);
            imageTop.setFitHeight(30);
            imageTop.setFitWidth(30);


        //imagem do hotel
        Image imagFrench = new Image(getClass().getResourceAsStream("/view/resources/img/R (1).jpg"));
        ImageView imageFrench = new ImageView(imagFrench);

        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(imageFrench);


        //Login
        Label lblLogin = new Label("Faça seu Login");
        lblLogin.setAlignment(Pos.CENTER);
        lblLogin.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox tituloHbox = new HBox(10, imageTop, lblLogin);
        tituloHbox.setAlignment(Pos.CENTER);

        Label lblEmail = new Label();
        TextField tfEmail = new TextField();
        tfEmail.setPromptText("Digite seu E-mail");
        tfEmail.setStyle("-fx-background-color: #FFFFFFFF;" +
                "-fx-border-color: #c0c0c3;" +
                "-fx-border-radius: 15;" +
                "-fx-padding: 8 30 8 40;" +
                "-fx-background-image: url(/view/resources/img/icons8-mail-50.png); " +
                "-fx-background-repeat: no-repeat; " +
                "-fx-background-position: left 14px center;" +
                "-fx-background-size: 19px 19px;" +
                "-fx-prompt-text-fill: #888888;");

        TextField tfSenha = new TextField();
        tfSenha.setPromptText("Digite sua senha");
        tfSenha.setStyle("-fx-background-color: #FFFFFFFF;" +
                "-fx-border-color: #c0c0c3;" +
                "-fx-border-radius: 15;" +
                "-fx-padding: 8 30 8 40;" +
                "-fx-background-image: url(/view/resources/img/icons8-eye-50.png); " +
                "-fx-background-repeat: no-repeat; " +
                "-fx-background-position: left 14px center;" +
                "-fx-background-size: 19px 19px;" +
                "-fx-prompt-text-fill: #888888;");

        tfSenha.setOnMouseEntered(event -> {
            tfSenha.setStyle("-fx-background-color: #FFFFFFFF;" +
                    "-fx-border-color: #c0c0c3;" +
                    "-fx-border-radius: 15;" +
                    "-fx-padding: 8 30 8 40;" +
                    "-fx-background-image: url(/view/resources/img/icons8-eye-48.png); " +
                    "-fx-background-repeat: no-repeat; " +
                    "-fx-background-position: left 14px center;" +
                    "-fx-background-size: 19px 19px;" +
                    "-fx-prompt-text-fill: #888888;");
        });





        Button tbLogin = new Button("Login");
        tbLogin.setStyle("-fx-font-size: 14px;" +
                "-fx-background-radius: 30;" +
                "-fx-border-radius: 30;" +
                "-fx-font-weight: bold;" +
                "-fx-background-color: #7da2ea;" +
                "-fx-text-fill: white;" +
                "-fx-padding: 6 60 6;" +
                "-fx-border-color: transparent;" +
                "-fx-border-width: 1;");
        tbLogin.setTranslateX(5);

        GridPane formPane = new GridPane();
        formPane.add(lblEmail,0,0);
        formPane.add(tfEmail,1,0);
        formPane.add(tfSenha,1,1);
        formPane.setHgap(10);
        formPane.setVgap(10);
        formPane.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10,tituloHbox, formPane, tbLogin);
        layout.setAlignment(Pos.CENTER);

        mainPane.setCenter(layout);

        Scene scene = new Scene(mainPane, 950, 596);
        janela.setTitle("Hotel Moon");
        janela.getIcons().add(imagIcon);
        janela.setScene(scene);
        janela.setResizable(false);
        janela.show();
    }

    public static void main(String[] args) {
        launch(args); //Inicializa o JAVAFX (aplicação)
    }
}
