package mvc.enity;

import javax.persistence.*;

@Entity
@Table(name="OrderDetail")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "product_name")
    private String productName;

    private int quantity;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name="product_id")
    private ProductEnity product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public ProductEnity getProduct() {
        return product;
    }

    public void setProduct(ProductEnity product) {
        this.product = product;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}