package view;

import javafx.application.Application; //Ciclo de vida da aplicação (init(), start(), stop() --> launch())
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; //Classe Scene: container que contém os layouts
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox; //Classe VBox: é um dos tipos de layouts
import javafx.stage.Stage; //Classe Stage é a própria janela (incluso barra de opções: minimizar, maximizar, fechar)
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.components.PanelButtons;
import view.components.Sidebar;

public class CadCliente extends Application {
    @Override
    public void start(Stage janela) throws Exception {
        Sidebar menu = new Sidebar();
        PanelButtons buttons = new PanelButtons();

        //Carregar imagens
        //logo
        Image imagIcon = new Image(getClass().getResourceAsStream("/view/resources/img/logo-moon-new.png"));

        //icon de cliente e usuario
        Image imagUserBlue = new Image(getClass().getResourceAsStream("/view/resources/img/imgUserBlue.png"));


        //criação de um container principal chamando mainPane
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu);


        //Parâmetros para definir como a imagem será visualizada
        ImageView viewImgUserBlue = new ImageView(imagUserBlue);
        viewImgUserBlue.setFitWidth(20);
        viewImgUserBlue.setFitHeight(20);


        //titulo
        Label lblTitulo = new Label("Cadastro de Clientes");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox tituloBox = new HBox(10,viewImgUserBlue,lblTitulo);
        tituloBox.setAlignment(Pos.CENTER);

        tituloBox.setPadding(new Insets(20,20,20,20));
        tituloBox.setAlignment(Pos.CENTER);

        tituloBox.setStyle("-fx-background-color: rgba(80,213,243,0.5)");

        //escrição:
        //nome do cliente
        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();
        txtNome.setPromptText("Digite seu nome:");

        //CPF do cliente
        Label lblCPF = new Label("CPF: ");
        TextField txtCPF = criarMascaraCampo("###.###.###-##");
        txtCPF.setPromptText("Digite seu CPF:");

        //Email do cliente
        Label lblEmail = new Label("E-mail: ");
        TextField txtEmail = new TextField();
        txtEmail.setPromptText("Digite seu e-mail:");
        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com","@outlook.com","@hotmail.com","@icloud.com");
        boxEmail.setPromptText("Selecione:");
        HBox selecionaBox = new HBox(10, boxEmail, txtEmail, lblEmail);

        //telefone do cliente
        Label lblTel = new Label("Telefone: ");
        TextField txtTel = criarMascaraCampo("(##) ####-####");
        txtTel.setPromptText("(__)____-____");

        GridPane formGrid = new GridPane();
        formGrid.add(lblNome, 0, 0);
        formGrid.add(txtNome, 1, 0);
        formGrid.add(lblCPF, 0, 1);
        formGrid.add(txtCPF, 1, 1);
        formGrid.add(lblEmail, 0, 2);
        formGrid.add(txtEmail, 1, 2);
        formGrid.add(selecionaBox, 2, 2);
        formGrid.add(lblTel, 0, 3);
        formGrid.add(txtTel, 1, 3);


        formGrid.add(buttons, 1, 4);

        formGrid.setHgap(10); //Gap(lacuna) de uma coluna para outra (na horizantal)
        formGrid.setVgap(10); //Gap(lacuna) de uma coluna para outra (na vertical)
        formGrid.setAlignment(Pos.CENTER);

        tituloBox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10,tituloBox, formGrid);
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);
        mainPane.setStyle("-fx-background-color: rgba(223,223,223,0.43);");
      //  layout.setStyle("-fx-background-color: pink;");

                                //layout -> mainPane
        Scene scene = new Scene(mainPane, 700, 600);
        janela.setTitle("Hotel Moon");

        //colocar um icon na janela (stage) -> ícon da empresa/marca
        janela.getIcons().add(imagIcon);
        janela.setScene(scene);
        janela.setResizable(false); //Impede a janela de redimensionar
        janela.show();
    }
    //Metodo para criar um campo de texto com mascara
    private TextField criarMascaraCampo(String mascara) {
        TextField txtMascara = new TextField();
        txtMascara.textProperty().addListener((observable, oldValue, newValue) ->
        {
            String value = newValue.replaceAll("[^0-9]", "");
            StringBuilder formatacaoCampo = new StringBuilder();
            int index = 0;
            for (char caracter : mascara.toCharArray()) {
                if (caracter == '#') {
                    if (index < value.length()) {
                        formatacaoCampo.append(value.charAt(index));
                        index++;
                    }
                    else {
                        break;
                    }
                }
                else {
                    formatacaoCampo.append(caracter);
                }
            }
            txtMascara.setText(formatacaoCampo.toString());
        });
        return txtMascara;
    }


    public static void main(String[] args) {
        launch(args); //Inicializa o JAVAFX (aplicação)
    }
}
