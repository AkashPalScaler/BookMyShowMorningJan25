package com.scaler.BookMyShowMorningJan25.Models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@MappedSuperclass
public class BaseModel {
    @Id
    private Long id;
    private Date CreatedAt;
    private Date ModifiedAt;
}
