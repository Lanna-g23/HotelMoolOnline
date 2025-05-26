package model;

import java.util.Date;

public class Pedido {
    private int id;
    private String usuario_id;
    private String cliente_id;
    private Date data;
    private String pagamento;

    public Pedido(int id, String usuario_id, String cliente_id, Date data, String pagamento) {
        this.usuario_id = usuario_id;
        this.cliente_id = cliente_id;
        this.pagamento = pagamento;
        this.data = data;
    }
    public String getUsuario_id() {
        return usuario_id;
    }
    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }
    public String getCliente_id() {
        return cliente_id;
    }
    public void setCliente_id(String cliente_id) {
        this.cliente_id = cliente_id;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public String getPagamento() {
        return pagamento;
    }
    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
}
