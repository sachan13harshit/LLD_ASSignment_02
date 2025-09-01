import com.example.orders.*;
import java.util.List;

public class TryIt {
    public static void main(String[] args) {
        OrderLine l1 = new OrderLine("A", 1, 200);
        OrderLine l2 = new OrderLine("B", 3, 100);
        Order o = new Order.Builder("o2", "a@b.com")
                .addLine(l1)
                .addLine(l2)
                .setDiscountPercent(10)
                .build();

        System.out.println("Total after discount: " + o.totalAfterDiscount());

        // Mutation attempt (impossible now — no setters, no exposed modifiable list)
        System.out.println("Lines: " + o.getLines().size());
    }
}
