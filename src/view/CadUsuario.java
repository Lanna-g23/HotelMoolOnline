package view;

import javafx.application.Application; //Ciclo de vida da aplicação (init(), Start(), stop(), --> launch())
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; //classe Scene: container que contém as layouts
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox; //classe VBox: é um dos tipos de layouts
import javafx.stage.Stage;//classe Stage é a própria janela (incluso barra de opções: minimizar, maximizar, fechar)
import javafx.scene.control.Label;
import view.components.PanelButtons;
import view.components.Sidebar;

public class CadUsuario extends Application {

    @Override
    public void start(Stage janela) throws Exception {
        Sidebar menu = new Sidebar();
        PanelButtons buttons = new PanelButtons();

        //Logo da janela
        Image imagIcon = new Image(getClass().getResourceAsStream("/view/resources/img/logo-moon-new.png"));

        //Icon do usuario
        Image imagUserBlack = new Image(getClass().getResourceAsStream("/view/resources/img/imgUserBlack.png"));
        ImageView viewImagUserBlack = new ImageView(imagUserBlack);
        viewImagUserBlack.setFitHeight(20);
        viewImagUserBlack.setFitWidth(20);

        //Criação de um container principal chamando mainPane
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu);


        //Titulo
        Label lblTituloFu = new Label("Cadastro do Funcionario");
        lblTituloFu.setAlignment(Pos.CENTER);
        lblTituloFu.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox tituloBox = new HBox(10,viewImagUserBlack,lblTituloFu);
        tituloBox.setAlignment(Pos.CENTER);

        tituloBox.setPadding(new Insets(20,20,20,20));
        tituloBox.setAlignment(Pos.CENTER);

        tituloBox.setStyle("-fx-background-color: rgba(166,166,166,0.43)");

        //Nome do Funcionario
        Label lblNomeFu = new Label("Nome: ");
        TextField tfNomeFu = new TextField();
        tfNomeFu.setPromptText("Digite seu nome");

        //Email do Funcionario
        Label lblEmFu = new Label("Email: ");
        TextField txtEmFu = new TextField();
        txtEmFu.setPromptText("Digite seu e-mail");
        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com","@outlook.com","@hotmail.com","@icloud.com");
        boxEmail.setPromptText("Selecione:");
        HBox selecionaBox = new HBox(10, boxEmail, txtEmFu, lblEmFu);


        //Senha do Funcionario
        Label lblSenha = new Label("Senha: ");
        TextField txtSenha= new TextField();
        txtSenha.setPromptText("Digite sua senha");


        //Setor do Funcionario
        Label lblCargo = new Label("Cargo:");
        TextField txtCargo= new TextField();
        txtCargo.setPromptText("Digite seu cargo");

        GridPane formGrid = new GridPane();
        formGrid.add(lblNomeFu, 0, 0);
        formGrid.add(tfNomeFu, 1, 0);
        formGrid.add(lblEmFu, 0, 2);
        formGrid.add(txtEmFu, 1, 2);
        formGrid.add(selecionaBox, 2, 2);
        formGrid.add(lblSenha, 0, 3);
        formGrid.add(txtSenha, 1, 3);
        formGrid.add(lblCargo, 0, 4);
        formGrid.add(txtCargo, 1, 4);

        formGrid.add(buttons, 1, 5);


        formGrid.setHgap(10); //Gap(lacuna) de uma coluna para outra (na horizantal)
        formGrid.setVgap(10); //Gap(lacuna) de uma coluna para outra (na vertical)
        formGrid.setAlignment(Pos.CENTER);

        tituloBox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(20,tituloBox, formGrid);
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);
        mainPane.setStyle("-fx-background-color: rgb(255,255,255);");

        Scene scene = new Scene(mainPane, 700, 600 );
        janela.setTitle("Hotel Moon");

        janela.getIcons().add(imagIcon);
        janela.setScene(scene);
        janela.setResizable(false);
        janela.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}