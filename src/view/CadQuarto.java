package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.components.PanelButtons;
import view.components.Sidebar;

public class CadQuarto extends Application {
    @Override
    public void start(Stage janela) throws Exception {
        Sidebar menu = new Sidebar();
        PanelButtons buttons = new PanelButtons();

        //logo
        Image imagIcon = new Image(getClass().getResourceAsStream("/view/resources/img/logo-moon-new.png"));


        //criação de um container principal chamando mainPane
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu);

        //titulo
        Label lblTitulo = new Label("Quartos e reservas");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox tituloBox = new HBox(10,lblTitulo);
        tituloBox.setAlignment(Pos.CENTER);


        tituloBox.setPadding(new Insets(20,20,20,20));
        tituloBox.setAlignment(Pos.CENTER);

        tituloBox.setStyle("-fx-background-color: rgba(80,213,243,0.5)");

        //tipo
        Label lblQuarto = new Label("Quarto:");
        TextField txtQuarto= new TextField();
        txtQuarto.setPromptText("Digite o quarto");

        //Nome
        Label lblNomeQua = new Label("Nome ");
        TextField tfNomeQuar = new TextField();
        tfNomeQuar.setPromptText("Digite o nome do cliente");
        //Spinner <Integer> lblqur = Spinner<>(1,6,1);

        //numero
        Label lblNumero = new Label("Numero: ");
       // TextField txtNumero = new TextField();
        TextField txtNumero = criarMascaraCampo("###");
        txtNumero.setPromptText("Digite o numero");

        //preco
        Label lblPreco = new Label("Preço:");
       // TextField tfPreco = new TextField();
        TextField tfPreco = criarMascaraCampo("###,##");
        tfPreco.setPromptText("Digite o preco");

        GridPane formGrid = new GridPane();
        formGrid.add(lblQuarto, 0, 0);
        formGrid.add(txtQuarto, 1, 0);
        formGrid.add(lblNomeQua, 0, 1);
        formGrid.add(tfNomeQuar, 1, 1);
        formGrid.add(lblNumero, 0, 2);
        formGrid.add(txtNumero, 1, 2);
        formGrid.add(lblPreco, 0, 3);
        formGrid.add(tfPreco, 1, 3);


        formGrid.add(buttons, 1, 4);

        formGrid.setHgap(10); //Gap(lacuna) de uma coluna para outra (na horizantal)
        formGrid.setVgap(10); //Gap(lacuna) de uma coluna para outra (na vertical)
        formGrid.setAlignment(Pos.CENTER);

        tituloBox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10,tituloBox, formGrid);
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);
        mainPane.setStyle("-fx-background-color: rgba(166,166,166,0.43);");

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
