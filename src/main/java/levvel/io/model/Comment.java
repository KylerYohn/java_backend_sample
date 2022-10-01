package levvel.io.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
// create a new class called comment that will store each comment that will be
// attached to a blog
public class Comment {

    String Author;
    String Text;

}
