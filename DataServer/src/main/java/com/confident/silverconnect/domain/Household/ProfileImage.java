package com.confident.silverconnect.domain.Household;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class ProfileImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "household_id", nullable = false)
    private Household household;

    @NotNull
    private String fileOriginalName;

    @NotNull
    private String fileName;

    @NotNull
    private String url;

    @Builder
    public ProfileImage(Household household, String fileOriginalName, String fileName, String url) {
        this.household = household;
        this.fileOriginalName = fileOriginalName;
        this.fileName = fileName;
        this.url = url;
    }
}
