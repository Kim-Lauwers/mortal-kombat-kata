package kata.mortalkombat.tournament.commentator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class CommentatorTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void whenCommentatorGivesComment_thenOutputCaptorSuccess() {
        final String comment = "Comments about Mortal Kombat";

        new Commentator().giveComment(comment);

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(comment);
    }
}