package hello.aop.exam;

import hello.aop.exam.annotation.Retry;
import hello.aop.exam.annotation.Trace;
import org.springframework.stereotype.Repository;

@Repository
public class ExamRepository {

    private static int seq = 0;

    /**
     * 5번에 한번 실패하는 요청
     */
    @Trace
    @Retry(4) // Retry 에노테이션의 int value()의 값을 4로 변경 (디폴트는 3으로 설정)
    public String save(String itemId) {
        seq++;
        if(seq % 5 == 0) {
            throw new IllegalStateException("예외 발생");
        }
        return "ok";
    }
}
