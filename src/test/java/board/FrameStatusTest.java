package board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("프레임 상태는")
class FrameStatusTest {

    @Test
    @DisplayName("new 예약어를 통해 생성된다.")
    public void constructor_UseNewKeyword_Success(){
        // when
        final FrameStatus frameStatus = new FrameStatus();

        // then
        assertThat(frameStatus).isNotNull();

        // 출력 확인용
        // System.out.println(Arrays.toString(frameStatus.getFrameStatus().toArray()));
    }
}
