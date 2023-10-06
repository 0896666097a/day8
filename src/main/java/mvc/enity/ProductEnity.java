package mvc.enity;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class ProductEnity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "productName")
    private String productName;
    @Column(name="product_description")
    private String productDescription;
    @Column(name = "price")
    private double price;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private OrderDetails ordersDetails;

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public OrderDetails getOrdersDetails() {
        return ordersDetails;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOrdersDetails(OrderDetails ordersDetails) {
        this.ordersDetails = ordersDetails;
    }

    public ProductEnity(){

    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    @Override
    public String toString() {
        return "OrderDetails{" + "id=" + id + ", productName='" + productName + '\'' + ", price='" + price +'\'' + ",ordersDetails='" + ordersDetails + '}';
    }

    public void setOrders(String s) {
    }
}
