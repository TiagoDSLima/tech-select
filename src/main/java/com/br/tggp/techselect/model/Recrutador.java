package com.br.tggp.techselect.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "recrutador")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recrutador implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recrutador")
    private Long idRecrutador;

    @NotBlank
    @Email
    @Size(max = 100)
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @NotBlank
    @Size(max = 255)
    @Column(name = "senha", nullable = false, length = 255)
    private String senha;

    @NotBlank
    @Size(max = 100)
    @Column(name = "nome_empresa", nullable = false, length = 100)
    private String nomeEmpresa;

    @Size(max = 500)
    @Column(name = "url_logo", length = 500)
    private String urlLogo;

    @NotBlank
    @Size(max = 100)
    @Column(name = "nome_completo", nullable = false, length = 100)
    private String nomeCompleto;

    @OneToMany(mappedBy = "recrutador")
    private List<Setor> setores;

    @OneToMany(mappedBy = "recrutador")
    private List<Vaga> vagas;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
