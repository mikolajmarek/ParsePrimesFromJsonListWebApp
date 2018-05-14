package pl.mj.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@Setter
@Getter
public class DownloadedData {
    String id;
    int size;
    List<Integer> data;
}
