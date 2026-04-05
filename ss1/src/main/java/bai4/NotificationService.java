package bai4;

@Service
// NotificationService cần EmailSender và SmsSender để gửi thông báo.
// Constructor Injection giúp khai báo dependency rõ ràng ngay khi tạo object.
// Cách này phù hợp với dependency bắt buộc, dễ test và dễ bảo trì.
public class NotificationService {

    private final EmailSender emailSender;
    private final SmsSender smsSender;

    public NotificationService(EmailSender emailSender, SmsSender smsSender) {
        // Spring sẽ tự tiêm EmailSender và SmsSender vào constructor này.
        // Nhờ đó class không cần tự new object, đảm bảo loose coupling.
        this.emailSender = emailSender;
        this.smsSender = smsSender;
    }
}

@Service
// Field Injection tiêm dependency trực tiếp vào thuộc tính bằng @Autowired.
// Cách này viết ngắn hơn, nhưng dependency bị ẩn,
// khó test hơn và kém minh bạch hơn Constructor Injection.
public class NotificationService {

    @Autowired
    // Spring tự động tiêm EmailSender vào field này
    private EmailSender emailSender;

    @Autowired
    // Spring tự động tiêm SmsSender vào field này
    private SmsSender smsSender;
}

// Trong 2 cách trên, Constructor Injection được đánh giá tốt hơn
// vì dependency rõ ràng, an toàn hơn và dễ kiểm thử khi hệ thống có lỗi như SMS mất kết nối.