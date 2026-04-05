package bai2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
// Spring mặc định bean là Singleton.
// Nếu chỉ dùng @Component thì toàn bộ hệ thống sẽ dùng chung 1 object PlaySession.
// Vì PlaySession có biến trạng thái playTime nên khi một máy cộng thời gian,
// các máy khác cũng bị ảnh hưởng, dẫn đến tính nhầm tiền.
// Dùng @Scope("prototype") để mỗi lần lấy bean sẽ tạo ra 1 object mới,
// tương ứng mỗi máy / mỗi phiên chơi có bộ đếm thời gian riêng.
public class PlaySession {

    private double playTime = 0;
    // playTime là dữ liệu trạng thái của từng phiên chơi,
    // vì vậy không nên để bean này ở scope Singleton.

    public void addTime(double time) {
        this.playTime += time;
    }

    public double getPlayTime() {
        return playTime;
    }
}
