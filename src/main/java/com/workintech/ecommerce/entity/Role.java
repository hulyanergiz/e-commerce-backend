package com.workintech.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="role",schema="ecommerce")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be null or blank.")
    @Size(min=1,max=20, message ="Name must have between 1 and 20 characters.")
    private String name;
    @NotBlank(message = "Code cannot be null or blank.")
    @Size(min=1,max=20,message = "Code must have between 1 and 20 characters.")
    private String code;

    @Override
    public String getAuthority() {
        return code;
    }
}
