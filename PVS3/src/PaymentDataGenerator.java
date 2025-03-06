import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Payment {
    private String transactionId;
    private String userId;
    private double amount;
    private LocalDateTime transactionDate;
    private String paymentMethod;
    private String status;
    private String category;

    public Payment(String transactionId, String userId, double amount, LocalDateTime transactionDate, 
                   String paymentMethod, String status, String category) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.category = category;
    }

    public String getTransactionId() { return transactionId; }
    public String getUserId() { return userId; }
    public double getAmount() { return amount; }
    public LocalDateTime getTransactionDate() { return transactionDate; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getStatus() { return status; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("Payment{ID=%s, User=%s, Amount=%.2f, Date=%s, Method=%s, Status=%s, Category=%s}",
                transactionId, userId, amount, transactionDate, paymentMethod, status, category);
    }

    public static List<Payment> generateSamplePayments(int count) {
        Random random = new Random();
        List<String> users = Arrays.asList("U001", "U002", "U003", "U004", "U005");
        List<String> paymentMethods = Arrays.asList("Credit Card", "Debit Card", "PayPal", "Bank Transfer");
        List<String> statuses = Arrays.asList("Completed", "Pending", "Failed");
        List<String> categories = Arrays.asList("Groceries", "Entertainment", "Utilities", "Travel", "Shopping");

        return IntStream.range(0, count).mapToObj(i -> new Payment(
                "TXN" + (1000 + i),
                users.get(random.nextInt(users.size())),
                10 + (500 * random.nextDouble()),
                LocalDateTime.now().minusDays(random.nextInt(30)),
                paymentMethods.get(random.nextInt(paymentMethods.size())),
                statuses.get(random.nextInt(statuses.size())),
                categories.get(random.nextInt(categories.size()))
        )).collect(Collectors.toList());
    }
}

public class PaymentDataGenerator {
    public static void main(String[] args) {
        List<Payment> payments = Payment.generateSamplePayments(100);
        payments.forEach(System.out::println);

        System.out.println("---------------");
        // Vypsat všechny completed platby
        payments.stream()
                .filter(payment -> payment.getStatus().equals("Completed"))
                .forEach(System.out::println);

        // Vypsat všechny platby více jak 200 a seřadit dle data
        System.out.println("------------------------------------");
        payments.stream()
                .filter(payment -> payment.getAmount() >= 200)
                .sorted(Comparator.comparing(Payment::getTransactionDate).reversed())
                .forEach(System.out::println);
        System.out.println("------------------");
        // Vypsat průměrnou výši od uživatele U001
        double avg = payments.stream()
                .filter(payment -> payment.getUserId().equals("U001"))
                .mapToDouble(value -> value.getAmount())
                .average()
                .orElse(0);
        System.out.println("Průměrnou výši uživatelů od U001: " + avg);
        System.out.println("-----------------------------");
        // Vypsat celkový počet platebb pro uživatele U003)
        int count = (int) payments.stream()
                .filter(payment -> payment.getUserId().equals("U003"))
                .count();
        System.out.println("Počet plateb od U003: " + count );
        System.out.println("---------------");
        // Vypsta celkový součet plateb v kategorii Entertainment

        int sum = (int) payments.stream()
                .filter(payment -> payment.getCategory().equals("Entertainment"))
                .mapToInt(value -> (int) value.getAmount())
                .sum();

        System.out.println("Součet čísel: " + sum);
        System.out.println("-----------------------");
        // Vypsat celkovou sumu, ktera je pending za poslední týden
        int sum2 = (int) payments.stream()
                .filter(payment -> payment.getStatus().equals("Pending") && payment.getTransactionDate().isAfter(LocalDateTime.now().minusWeeks(1)))
                .mapToInt(value -> (int) value.getAmount())
                .sum();

        System.out.println("Součet čísel: " + sum2);
        System.out.println("-------------------");
    }
}
