package br.edu.icomp.ufam.iartes.apppedidoslanche.Models;

public class OrdersModel {

    int orderImage;
    String orderItemName, valueOrder, idPedido;

    public OrdersModel(int orderImage, String soldItemName, String valueOrder, String idPedido) {
        this.orderImage = orderImage;
        this.orderItemName = soldItemName;
        this.valueOrder = valueOrder;
        this.idPedido = idPedido;
    }

    public OrdersModel() {

    }


    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getOrderItemName() {
        return orderItemName;
    }

    public void setOrderItemName(String orderItemName) {
        this.orderItemName = orderItemName;
    }

    public String getValueOrder() {
        return valueOrder;
    }

    public void setValueOrder(String valueOrder) {
        this.valueOrder = valueOrder;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }
}
