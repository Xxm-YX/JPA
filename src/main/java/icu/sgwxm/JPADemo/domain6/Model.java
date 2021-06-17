package icu.sgwxm.JPADemo.domain6;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.io.File;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Model {

    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name="system_uuid",strategy = "uuid")
    private String modelId;

    @Column(name = "modelName")
    private String modelName;

    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY)
    private List<FilePath> filePaths;
}
