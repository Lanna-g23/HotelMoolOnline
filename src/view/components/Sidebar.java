package view.components;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Sidebar extends VBox {
    public Button btnCliente = new Button("Clientes");
    public Button btnFuncionario = new Button("Funcionarios");
    public Button btnQuarto = new Button("Quartos");
    public Button btnReserva = new Button("Reservas");
    public Button btnRelatorio = new Button("Relatórios");

    public Sidebar(){
        //imagens
        Image iconFuncionario = new Image(getClass().getResourceAsStream("/view/resources/img/icon-funcionario.png"));
        Image iconCliente = new Image(getClass().getResourceAsStream("/view/resources/img/icon-cliente.png"));
        Image iconQuarto = new Image(getClass().getResourceAsStream("/view/resources/img/icon-quarto.png"));
        Image iconReserva = new Image(getClass().getResourceAsStream("/view/resources/img/icon-reserva.png"));
        Image iconRelatorio = new Image(getClass().getResourceAsStream("/view/resources/img/icon-relatorio.png"));

        //carregamento das fontes
        Font fontRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" + "RobotoCondensed-Regular.ttf"), 14);
        Font fontNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" + "RobotoCondensed-Bold.ttf"), 15);

        ImageView viewImgBtnFun = new ImageView(iconFuncionario);
        viewImgBtnFun.setFitWidth(20); //Definição de largura
        viewImgBtnFun.setFitHeight(20); //Definição de altura
        btnFuncionario.setGraphic(viewImgBtnFun);

        ImageView viewImgBtnCad = new ImageView(iconCliente);
        viewImgBtnCad.setFitWidth(20);
        viewImgBtnCad.setFitHeight(20);
        btnCliente.setGraphic(viewImgBtnCad);

        ImageView viewImgBtnQua = new ImageView(iconQuarto);
        viewImgBtnQua.setFitWidth(20);
        viewImgBtnQua.setFitHeight(20);
        btnQuarto.setGraphic(viewImgBtnQua);

        ImageView viewImgBtnRe = new ImageView(iconReserva);
        viewImgBtnRe.setFitWidth(20);
        viewImgBtnRe.setFitHeight(20);
        btnReserva.setGraphic(viewImgBtnRe);

        ImageView viewImgBtnRel = new ImageView(iconRelatorio);
        viewImgBtnRel.setFitWidth(20);
        viewImgBtnRel.setFitHeight(20);
        btnRelatorio.setGraphic(viewImgBtnRel);


        Label lblMenu = new Label("Grand Moon");
        lblMenu.setStyle("-fx-text-fill: #ba8900;");
        lblMenu.setFont(Font.font(fontNegrito.getFamily(), 25));

        //estilização dos botões
        String styleButton = "-fx-background-color: transparent;" +
                             "-fx-border-color: transparent;" +
                             "-fx-graphic-text-gap: 10px;" +
                             "-fx-alignment: center;" +
                             "-fx-cursor: hand;" ; //Setar o cursor da mãozinha

        btnFuncionario.setStyle(styleButton);
        btnCliente.setStyle(styleButton);
        btnQuarto.setStyle(styleButton);
        btnReserva.setStyle(styleButton);
        btnRelatorio.setStyle(styleButton);

        //Objetivo: ao passar o mouse, troca o fundo do botão de cor
        btnCliente.setOnMouseEntered(evento ->
                btnCliente.setStyle(styleButton.replace("transparent", "#E4D6ABFF")));
        btnCliente.setOnMouseExited(evento -> btnCliente.setStyle(styleButton));

        btnFuncionario.setOnMouseEntered(evento ->
                btnFuncionario.setStyle(styleButton.replace("transparent", "#E4D6ABFF")));
        btnFuncionario.setOnMouseExited(evento -> btnFuncionario.setStyle(styleButton));

        btnQuarto.setOnMouseEntered(evento ->
                btnQuarto.setStyle(styleButton.replace("transparent", "#E4D6ABFF")));
        btnQuarto.setOnMouseExited(evento -> btnQuarto.setStyle(styleButton));

        btnReserva.setOnMouseEntered(evento ->
                btnReserva.setStyle(styleButton.replace("transparent", "#E4D6ABFF")));
        btnReserva.setOnMouseExited(evento -> btnReserva.setStyle(styleButton));

        btnRelatorio.setOnMouseEntered(evento ->
                btnRelatorio.setStyle(styleButton.replace("transparent", "#E4D6ABFF")));
        btnRelatorio.setOnMouseExited(evento -> btnRelatorio.setStyle(styleButton));


        //espaçamento externo (margem) do componente label até o botão
        setMargin(lblMenu, new Insets(80,       0,       50,        0));
                       //margem:      superior,    direita,    interior,      esquerda

        setSpacing(12); //Metodo setSpacing para espaçar todos os componentes que fazem parte do menu

        setStyle("-fx-background-color: rgb(255,255,255); -fx-padding: 20px");
        getChildren().addAll(lblMenu, btnCliente, btnFuncionario, btnQuarto, btnReserva, btnRelatorio);

    }
}
