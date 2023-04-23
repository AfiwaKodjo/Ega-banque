package ega.appli.ega.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;
@Entity
@NoArgsConstructor
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCli;
    @Column(length = 30)
    private String nom;
    @Column(length = 30)
    private String prenom;
    private LocalDate dateNaissance;
    @Column(length = 1)
    @Enumerated(EnumType.ORDINAL)
    private TypeSex sex;
    private String email;
    private String tel;
    private String nationalité;
    @JsonIgnoreProperties
    @OneToMany(targetEntity = Compte.class,cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "idCli", referencedColumnName = "idCli")

    private List<Compte> comptes;
}
